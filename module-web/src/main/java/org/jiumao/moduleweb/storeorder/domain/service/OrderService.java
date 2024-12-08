package org.jiumao.moduleweb.storeorder.domain.service;

import cn.hutool.core.util.ObjectUtil;
import org.jiumao.moduleweb.storeorder.domain.dto.OrderRequest;
import org.jiumao.moduleweb.storeorder.domain.dto.OrderResponse;
import org.jiumao.moduleweb.storeorder.domain.entities.MenuItem;
import org.jiumao.moduleweb.storeorder.domain.entities.Order;
import org.jiumao.moduleweb.storeorder.domain.vo.enums.OrderStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/12/3 22:48]
 */
@Service
public class OrderService {
	public OrderResponse convertToOrderResponse(Order order){
		return OrderResponse.builder()
				.id(order.getId())
				.amount(order.getAmount())
				.items(order.getItems())
				.createTime(order.getCreateTime())
				.updateTime(order.getUpdateTime())
				.status(order.getStatus())
				.teaMakerName(order.getTeaMaker().getName())
				.currency(order.getCurrency())
				.build();
	}

	public Order fromOrderRequest(OrderRequest orderRequest) {
		return Order.builder()
				.status(OrderStatus.CREATED)
				.currency(orderRequest.getCurrency()).build();
	}

	public boolean isMenuItemEmpty(OrderRequest orderRequest) {
		return ObjectUtil.isEmpty(orderRequest);
	}

	public boolean isMenuItemNoLongExist(OrderRequest orderRequest, List<MenuItem> menuItems) {
		return orderRequest.getItemIds().size() != menuItems.size();
	}
}
