package com.zepto.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.dto.SavedProductResponseDto;
import com.zepto.request.ProductRequest;
import com.zepto.service.ProductService;

@RestController
public class ProductController {
	
	final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@PostMapping("/addProduct")
	public SavedProductResponseDto addProduct(@RequestBody ProductRequest req) {
		System.out.println("Product Req received "+ req.toString());
		return productService.saveProduct(req);
	}
	
}
