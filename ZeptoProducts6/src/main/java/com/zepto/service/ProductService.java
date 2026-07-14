package com.zepto.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zepto.dto.SavedProductResponseDto;
import com.zepto.entity.CategoryEntity;
import com.zepto.entity.ProductEntity;
import com.zepto.repository.CategoryRepository;
import com.zepto.repository.ProductRepository;
import com.zepto.request.ProductRequest;

@Service
public class ProductService {
	
	final CategoryRepository categoryRepository;
	final ProductRepository productRepository;
	
	public ProductService(CategoryRepository categoryRepository, ProductRepository productRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}
	
	
	public SavedProductResponseDto saveProduct(ProductRequest req) {
		
		Optional<CategoryEntity> catEnt = categoryRepository.findByCategoryName(req.getCategoryName());
		CategoryEntity catEntToUse;
		
		if(catEnt.isPresent()) catEntToUse = catEnt.get();
		else {
			catEntToUse = new CategoryEntity();
			catEntToUse.setCategoryName(req.getCategoryName());
			catEntToUse.setStatus("Active");
			categoryRepository.save(catEntToUse);
		}
		
		ProductEntity productEntity = new ProductEntity();
		productEntity.setProductName(req.getProductName());
		productEntity.setPrice(req.getPrice());
		productEntity.setQuantity(req.getQuantity());
		productEntity.setCategoryEntity(catEntToUse);
		
		ProductEntity savedProd = productRepository.save(productEntity);
		
		return getSavedProdDto(savedProd, req.getCategoryName());
		
	}
	
	public SavedProductResponseDto getSavedProdDto(ProductEntity prod, String cat) {
		SavedProductResponseDto dto = new SavedProductResponseDto();
		dto.setCategoryName(cat);
		dto.setPrice(prod.getPrice());
		dto.setProductName(prod.getProductName());
		dto.setQuantity(prod.getQuantity());
		return dto;
	}
	
	
}
