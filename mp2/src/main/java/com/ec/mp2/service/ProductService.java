package com.ec.mp2.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.mp2.repository.Product;
import com.ec.mp2.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	public ArrayList<Product> getAllProducts(){
		return productRepository.getAllProducts();
	}
	
	public Product getProductById(String id) {
		return productRepository.getProductById(id);
	}
}
