package org.jiumao.moduleweb.storeorder.domain.service;

import org.jiumao.moduleweb.storeorder.domain.dto.OrderResponse;
import org.jiumao.moduleweb.storeorder.domain.entities.Order;
import org.springframework.stereotype.Service;

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
}
