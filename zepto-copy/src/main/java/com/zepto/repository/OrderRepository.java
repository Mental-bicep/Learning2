package com.zepto.repository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

	public String addProductToDB() {
		System.out.println("Inside the Repo layer");
		return "Prod12345"; 
	}
	
}
