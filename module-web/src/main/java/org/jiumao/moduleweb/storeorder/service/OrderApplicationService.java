package org.jiumao.moduleweb.storeorder.service;

import lombok.extern.slf4j.Slf4j;
import org.jiumao.moduleweb.common.Exception.JMBizException;
import org.jiumao.moduleweb.storeorder.domain.dto.OrderRequest;
import org.jiumao.moduleweb.storeorder.domain.dto.OrderResponse;
import org.jiumao.moduleweb.storeorder.domain.entities.MenuItem;
import org.jiumao.moduleweb.storeorder.domain.entities.Order;
import org.jiumao.moduleweb.storeorder.domain.entities.TeaMaker;
import org.jiumao.moduleweb.storeorder.domain.service.OrderService;
import org.jiumao.moduleweb.storeorder.domain.vo.embed.Amount;
import org.jiumao.moduleweb.storeorder.domain.vo.embed.CusMoney;
import org.jiumao.moduleweb.storeorder.repository.MenuItemRepository;
import org.jiumao.moduleweb.storeorder.repository.OrderRepository;
import org.jiumao.moduleweb.storeorder.repository.TeaMakerRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/12/2 22:39]
 */
@Service
@Slf4j
public class OrderApplicationService {
	private final OrderRepository orderRepository;
	private final OrderService orderService;
	private final TeaMakerRepository teaMakerRepository;
	private final MenuItemRepository menuItemRepository;

	public OrderApplicationService(OrderRepository orderRepository, OrderService orderService, TeaMakerRepository teaMakerRepository, MenuItemRepository menuItemRepository) {
		this.orderRepository = orderRepository;
		this.orderService = orderService;
		this.teaMakerRepository = teaMakerRepository;
		this.menuItemRepository = menuItemRepository;
	}

	@Cacheable(value = "orderList")
	public List<OrderResponse> getAllOrder() {
		return orderRepository.findAll()
				.stream()
				.map(orderService::convertToOrderResponse)
				.toList();
	}

	@Transactional
	public Long saveOrderSingle(OrderRequest orderRequest) throws JMBizException {
		if (orderService.isMenuItemEmpty(orderRequest)) {
			throw new JMBizException("至少选择一个商品!");
		}
		Order createdOrder = orderService.fromOrderRequest(orderRequest);
		//query teaMaker
		Optional<TeaMaker> teaMaker = teaMakerRepository.findById(orderRequest.getTeaMakerId());
		teaMaker.ifPresentOrElse(createdOrder::setTeaMaker,
				() -> {
					throw new JMBizException("制作人未找到");
				});
		//query menuItem
		List<MenuItem> menuItemList = menuItemRepository.findAllById(orderRequest.getItemIds());
		if (orderService.isMenuItemNoLongExist(orderRequest, menuItemList)) {
			throw new JMBizException("所选商品中有已下架或不存在的商品!");
		}
		createdOrder.setItems(menuItemList);
		//calculate amount
		String currency = orderRequest.getCurrency();
		Double disAccount = orderRequest.getAmountDisCount();
		BigDecimal totalAmount = menuItemList.stream().map(m -> m.getPrice().getAmount()).reduce(BigDecimal.ZERO, BigDecimal::add);
		BigDecimal payAmount = totalAmount.multiply(BigDecimal.valueOf(disAccount));
		Amount amount = new Amount(disAccount, CusMoney.of(totalAmount, currency), CusMoney.of(payAmount, currency));
		createdOrder.setAmount(amount);
		log.info("即将保存订单");
		Order saveOrder = orderRepository.save(createdOrder);
		log.info("保存订单成功 id 为: {} ", saveOrder.getId());
		return saveOrder.getId();
	}
}
