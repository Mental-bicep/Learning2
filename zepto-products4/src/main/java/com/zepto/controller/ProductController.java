package com.zepto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.zepto.request.ProductRequest;
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
	
	@GetMapping("ListAllProducts")
	@ResponseBody
	public void listAllProducts() {
		productService.listAllProducts();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//		productService.listAllProductsOptimized();
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//		productService.listAllProductsEntityGraph();
	}
	
	
	@GetMapping("/ListAllCategoriesLazy")
	@ResponseBody
	public void listAllCategoriesLazy() {
		System.out.println("Using Lazy Loading");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		productService.listAllCategoriesUsingLazy();
	}
	
	@GetMapping("/ListAllCategoriesEager")
	@ResponseBody
	public void listAllCategoriesEager() {
		System.out.println("Using Eager Loading");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		productService.listAllCategoriesUsingEager();
	}
	
	@GetMapping("/ListAllProductsLazy")
	@ResponseBody
	public void listAllProductsLazy() {
		System.out.println("Using Lazy Loading");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		productService.listAllProductsUsingLazy();
	}
	
	@GetMapping("/ListAllProductsEager")
	@ResponseBody
	public void listAllProductsEager() {
		System.out.println("Using Eager Loading");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		productService.listAllProductsUsingEager();
	}
}
