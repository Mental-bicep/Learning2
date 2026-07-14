package com.zepto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zepto.entity.ProductEntity;
import com.zepto.repository.ProductRepository;
import com.zepto.requests.ProductRequest;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public Long saveProduct(ProductRequest productRequest) {
		ProductEntity entity = productRepository.save(productRequestToEntity(productRequest));
		return entity.getProductId();
	}
	
	public ProductEntity productRequestToEntity(ProductRequest req) {
		ProductEntity obj = new ProductEntity();
		obj.setName(req.getName());
		obj.setDescription(req.getName());
		obj.setPrice(req.getPrice());
		obj.setQuantity(req.getQuantity());
		return obj;
		
	}
	
	public String getProductByName(String productName) {
		ProductEntity entity = productRepository.findProductByname(productName).get(0);
		return entity.toString();
	}
}
