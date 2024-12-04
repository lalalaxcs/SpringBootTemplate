package org.jiumao.moduleweb.storeorder.service;

import org.jiumao.moduleweb.storeorder.domain.dto.OrderResponse;
import org.jiumao.moduleweb.storeorder.domain.service.OrderService;
import org.jiumao.moduleweb.storeorder.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/12/2 22:39]
 */
@Service
public class OrderApplicationService {
	private final OrderRepository orderRepository;
	private final OrderService orderService;

	public OrderApplicationService(OrderRepository orderRepository, OrderService orderService) {
		this.orderRepository = orderRepository;
		this.orderService = orderService;
	}

	public List<OrderResponse> getAllOrder() {
		return orderRepository.findAll()
				.stream()
				.map(orderService::convertToOrderResponse)
				.toList();
	}
}
