package com.zepto.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zepto.entity.CategoryEntity;
import com.zepto.entity.ProductEntity;
import com.zepto.repository.CategoryRepository;
import com.zepto.repository.ProductRepository;
import com.zepto.request.ProductRequest;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public Long saveProduct(ProductRequest productRequest) {
		
		CategoryEntity cat;
		
		Optional<CategoryEntity> existingCat = categoryRepository.findByCategoryName(productRequest.getCategory());
		
		if(existingCat.isPresent()) cat =  existingCat.get();
		else {
			cat = new CategoryEntity();
			cat.setCategoryName(productRequest.getCategory());
			cat.setStatus("Active");
			categoryRepository.save(cat);
		}
		
		ProductEntity ent = productRequestToProductEntity(productRequest);
		ent.setCategoryEntity(cat);
		Long id = productRepository.save(ent).getProductId();	
			
		System.out.println("proudct attached to category= "+cat.getCategoryName()+" id= "+cat.getCategoryId());	
		
		
		
		if(id > 0) System.out.println("Prod created Pid = "+ id);
		else System.out.println("Prod could not be created");
		
		return id;
	}
	
	public ProductEntity productRequestToProductEntity(ProductRequest req) {
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
	
	// N+1 Issue in the below code
	@Transactional
	public void listAllProducts() {
		Iterable<CategoryEntity> categoryEntity = categoryRepository.findAll();
		
		for(CategoryEntity cat: categoryEntity) {
			System.out.println("**********************************************************");
			System.out.println(cat.toString());
			for(ProductEntity pEnt :cat.getProductEntities()) {
				System.out.println(pEnt.toString());
			}
		}
	}
	
	// solving the N+1 problem
	public void listAllProductsOptimized() {
		List<CategoryEntity> categoryEntity = categoryRepository.findAllCategoriesWithProductEntitesJoinFetch();
		
		for(CategoryEntity cat: categoryEntity) {
			System.out.println("**********************************************************");
			System.out.println(cat.toString());
			for(ProductEntity pEnt :cat.getProductEntities()) {
				System.out.println(pEnt.toString());
			}
		}
	}
	
	//Solving N+1 problem
	public void listAllProductsEntityGraph() {
		List<CategoryEntity> categoryEntity = categoryRepository.findAll();
		
		for(CategoryEntity cat: categoryEntity) {
			System.out.println("**********************************************************");
			System.out.println(cat.toString());
			for(ProductEntity pEnt :cat.getProductEntities()) {
				System.out.println(pEnt.toString());
			}
		}
	}
	
//	@Transactional
	public void listAllCategoriesUsingLazy() {
		Iterable<CategoryEntity> categories = categoryRepository.findAll();
		
//		for(CategoryEntity cat: categories) {
//			System.out.println("**********************************************************");
//			System.out.println(cat.toString());
//			for(ProductEntity pEnt :cat.getProductEntities()) {
//				System.out.println(pEnt.toString());
//			}
//		}
	}
	
	public void listAllCategoriesUsingEager() {
		Iterable<CategoryEntity> categories = categoryRepository.findAll();
		
		for(CategoryEntity cat: categories) {
			System.out.println("**********************************************************");
			System.out.println(cat.toString());
//			for(ProductEntity pEnt :cat.getProductEntities()) {
//				System.out.println(pEnt.toString());
//			}
		}
	}
	
	public void listAllProductsUsingLazy() {
		Iterable<ProductEntity> products = productRepository.findAll();
		
//		for(var prod: products) { // give error because of lazy
//			System.out.println("**********************************************************");
//			System.out.println(prod.toString());
//		}
	}
	
	public void listAllProductsUsingEager() {
		Iterable<ProductEntity> products = productRepository.findAll();
		
		for(ProductEntity prod: products) {
			System.out.println("**********************************************************");
			System.out.println(prod.toString());
			System.out.println(prod.getCategoryEntity().toString()); 
		}
	}
		
}
