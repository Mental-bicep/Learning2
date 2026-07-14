package com.zepto1.repository;

import org.springframework.stereotype.Repository;

import com.zepto1.requests.OrderRequest;

@Repository
public class OrderRepository {

	public String method1(OrderRequest orderRequest) {
		System.out.println("inside repository layer");
		return "ord12345";
	}
}
