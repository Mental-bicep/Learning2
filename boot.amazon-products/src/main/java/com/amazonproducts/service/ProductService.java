package com.amazonproducts.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.stereotype.Service;

import com.amazonproducts.entity.Product;
import com.amazonproducts.repository.ProductRepository;

@Service
public class ProductService {

	
	private final MongoTemplate mongoTemplate;
	
    
	private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, MongoTemplate mongoTemplate) {
        this.productRepository = productRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }
    
    public String saveDynamicProduct(Map<String, Object> payload, String collectionName) {
        // 1. Create a MongoDB BSON Document from the map data
        Document document = new Document(payload);

        // 2. Use MongoTemplate to save the raw document directly into the cluster collection
        // This natively returns the saved document populated with the generated '_id'
        Document savedDoc = mongoTemplate.save(document, collectionName);

        // 3. Extract and return the automatically generated ObjectId string
        return savedDoc.getObjectId("_id").toString();
    }
}
