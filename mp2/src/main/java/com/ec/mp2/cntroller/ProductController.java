package com.ec.mp2.cntroller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ec.mp2.repository.Product;
import com.ec.mp2.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public String showAllProductsOnProductDashboard(Model model) {
		ArrayList<Product> allProducts = productService.getAllProducts();
		model.addAttribute("allProducts", allProducts);
		return "dashboardPage";
	} 
	
}
