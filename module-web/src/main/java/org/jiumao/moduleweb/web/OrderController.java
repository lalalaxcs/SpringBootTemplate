package org.jiumao.moduleweb.web;

import org.jiumao.moduleweb.storeorder.domain.dto.OrderResponse;
import org.jiumao.moduleweb.storeorder.domain.entities.Order;
import org.jiumao.moduleweb.storeorder.service.OrderApplicationService;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author       : [xvChuShun]
 * @createTime   : [2024/12/3 12:30]
 */
@RestController
public class OrderController {
	private final OrderApplicationService orderApplicationService;

	public OrderController(OrderApplicationService orderApplicationService) {
		this.orderApplicationService = orderApplicationService;
	}

	@GetMapping("/allorder")
	public List<OrderResponse> getAllOrder(){
		return orderApplicationService.getAllOrder();
	}

	@GetMapping("/test")
	public String test(){
		return "hell";
	}

	@GetMapping("/getMoney")
	public Money getMoney() {
		// 返回一个 Money 对象
		return Money.of(CurrencyUnit.of("CNY"), BigDecimal.valueOf(100.00));
	}
}
