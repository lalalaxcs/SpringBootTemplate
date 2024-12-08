package org.jiumao.moduleweb.storeorder.service;

import org.jiumao.moduleweb.storeorder.repository.CustomerRepository;
import org.springframework.stereotype.Service;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/12/8 20:32]
 */
@Service
public class CustomerApplicationService {
	private final CustomerRepository customerRepository;

	public CustomerApplicationService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Long registerCustomer(){
		return 0L;
	}
}
