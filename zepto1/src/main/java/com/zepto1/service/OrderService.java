package com.zepto1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zepto1.requests.OrderRequest;
import com.zepto1.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;
	
	public String method1(OrderRequest orderRequest) {
		System.out.println("inside the service layer.........");
		return orderRepository.method1(orderRequest);
	}
}
