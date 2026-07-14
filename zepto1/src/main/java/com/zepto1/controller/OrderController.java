package com.zepto1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.zepto1.requests.OrderRequest;

import com.zepto1.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/placeOrder")
	public String placeOrders(@ModelAttribute OrderRequest orderRequest) {
		System.out.println("Inside the Controller Function");
		System.out.println(orderRequest);
		orderService.method1(orderRequest);

		return "default";
	}
}
