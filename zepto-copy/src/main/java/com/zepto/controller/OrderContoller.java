package com.zepto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.zepto.requests.ProductRequest;
import com.zepto.service.OrderService;

@Controller
public class OrderContoller {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/addProd")
	public String addProduct(@ModelAttribute ProductRequest productRequest) {
		System.out.println("inside the controller Function ....................");
		
		String res = orderService.addProducts(productRequest);
		System.out.println("Prod id is "+ res);
		return "default";
	}
}
