package com.zepto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.zepto.requests.ProductRequest;
import com.zepto.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("saveProduct")
	@ResponseBody
	public String uploadProduct(@ModelAttribute ProductRequest productRequest) {
		Long id = productService.saveProduct(productRequest);
		return "Product added successfully --> prod id is " + id;
	}
	
	@GetMapping("/ShowSearchPage")
	public String showSearchPage() {
		return "search-page";
	}
	
	@GetMapping("/GetProduct")
	@ResponseBody
	public String getProduct(@RequestParam("productName") String productName) {
		return productService.getProductByName(productName);
	}
	
}
