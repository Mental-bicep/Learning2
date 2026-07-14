package com.zepto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zepto.entity.CategoryEntity;
import com.zepto.entity.ProductEntity;
import com.zepto.repository.ProductRepository;
import com.zepto.request.ProductRequest;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public Long saveProduct(ProductRequest productRequest) {
		ProductEntity ent = productRequestToEntity(productRequest);
		
		CategoryEntity cat = new CategoryEntity();
		cat.setCategoryName(productRequest.getCategory());
		cat.setStatus("Active");
		
		ent.setCategoryEntity(cat); 
		cat.setProductEntity(ent);
		
		ProductEntity entity = productRepository.save(ent);
		
		if(entity.getProductId() > 0) System.out.println("Prod created Pid = "+ entity.getProductId());
		else System.out.println("Prod could not be created");
		
		return entity.getProductId();
	}
	
	public ProductEntity productRequestToEntity(ProductRequest req) {
		ProductEntity obj = new ProductEntity();
		obj.setName(req.getName());
		obj.setDescription(req.getDescription());
		obj.setPrice(req.getPrice());
		obj.setQuantity(req.getQuantity());
		return obj;
		
	}
	
	public String getProductByName(String productName) {
		ProductEntity entity = productRepository.findProductByname(productName).get(0);
		return entity.toString();
	}
}
