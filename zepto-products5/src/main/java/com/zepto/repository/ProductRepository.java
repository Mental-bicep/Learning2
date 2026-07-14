package com.zepto.repository;

import org.springframework.data.repository.CrudRepository;

import com.zepto.entity.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer>{
	
}
