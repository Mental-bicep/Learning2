package com.zepto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zepto.repository.OrderRepository;
import com.zepto.requests.ProductRequest;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	public String addProducts(ProductRequest productRequest) {
		System.out.println("inside the service layer..................");
		
		String prodId = orderRepository.addProductToDB();
		return prodId;
	}
}
