package com.amazonproducts.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.amazonproducts.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
