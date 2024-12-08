package org.jiumao.moduleweb.web;

import org.jiumao.moduleweb.storeorder.domain.dto.OrderRequest;
import org.jiumao.moduleweb.common.Exception.JMBizException;
import org.jiumao.moduleweb.common.dto.ApiResponse;
import org.jiumao.moduleweb.storeorder.domain.dto.OrderResponse;
import org.jiumao.moduleweb.storeorder.service.OrderApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("/order/list")
	public ApiResponse<List<OrderResponse>> getAllOrder(){
		List<OrderResponse> allOrder = orderApplicationService.getAllOrder();
		return ApiResponse.ofSuccess(allOrder,"查询成功");
	}

	@PostMapping("/order/saveSingle")
	public ApiResponse<Long> saveOrderSingle(@RequestBody OrderRequest orderRequest) {
		try {
			Long id = orderApplicationService.saveOrderSingle(orderRequest);
			return ApiResponse.ofSuccess(id, "订单创建成功!");
		} catch (JMBizException e) {
			return ApiResponse.ofFailed(null, e.getMessage());
		} catch (RuntimeException runtimeException) {
			return ApiResponse.ofError(500, null, runtimeException.getMessage());
		}
	}
}
