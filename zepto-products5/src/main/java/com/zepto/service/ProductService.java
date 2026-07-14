package com.zepto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zepto.entity.CategoryEntity;
import com.zepto.entity.ProductEntity;
import com.zepto.repository.CategoryRepository;
import com.zepto.repository.ProductRepository;
import com.zepto.request.ProductRequest;

@Service
public class ProductService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public Integer addNewProduct(ProductRequest req) {
		Optional<CategoryEntity> cat = categoryRepository.findByCategory(req.getCategory());
		CategoryEntity catEntToUse;
		
		if(cat.isPresent()) catEntToUse = cat.get();
		else {
			catEntToUse = new CategoryEntity();
			catEntToUse.setCategory(req.getCategory());
			catEntToUse.setStatus("Active");
			categoryRepository.save(catEntToUse);
		}
		
		ProductEntity prod = new ProductEntity();
		prod.setDescription(req.getDescription());
		prod.setPrice(req.getPrice());
		prod.setProductName(req.getProductName());
		prod.setQuantity(req.getQuantity());
		prod.setCategoryEntity(catEntToUse);
		
		catEntToUse.getProductEntities().add(prod);
		
		Integer id = productRepository.save(prod).getProductId();
		
		System.out.println("saved successfully product with id = " + id);
		
		return id;
	}
	
}
