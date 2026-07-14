package com.zepto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zepto.request.ProductRequest;
import com.zepto.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/saveProduct")
	@ResponseBody
	public String addProduct(ProductRequest req) {
		var id = productService.addNewProduct(req);
		
		return "prod added successfully with id = " + id;
	}
}
