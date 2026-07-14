package com.ec.mp2.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class ProductRepository {
	ArrayList<Product> DB  = new ArrayList<Product>();
	
	@PostConstruct
	public void initData() {
		DB.add(new Product("1","prod1",10,100));
		DB.add(new Product("2","prod2",10,100));
		DB.add(new Product("3","prod3",10,100));
		DB.add(new Product("4","prod4",10,100));
		DB.add(new Product("5","prod5",10,100));
		DB.add(new Product("6","prod6",10,100));
	}
	
	public ArrayList<Product> getAllProducts(){
		return DB;
	}
	
	public Product getProductById(String id) {
		for(Product prod: DB)
			if(prod.id.equals(id)) return prod;
		return null;
	}
	
}
