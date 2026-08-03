package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 1. Test Batch Inserts
    @Transactional
    public String insertThousandsOfRecords() {
        List<Product> products = new ArrayList<>();
        for (int i = 1; i <= 5000; i++) {
            products.add(new Product("Product " + i, Math.random() * 100));
        }
        
        long startTime = System.currentTimeMillis();
        // Thanks to application.properties, this will be batched 50 at a time!
        productRepository.saveAll(products);
        long endTime = System.currentTimeMillis();
        
        return "Inserted 5000 records in " + (endTime - startTime) + " ms.";
    }

    // 2. Test Standard Delete (Slow)
    @Transactional
    public String standardDeleteAll() {
        List<Product> allProducts = productRepository.findAll();
        
        long startTime = System.currentTimeMillis();
        // This executes a SELECT, and then 5000 individual DELETE statements
        productRepository.deleteAll(allProducts);
        long endTime = System.currentTimeMillis();
        
        return "Standard deleteAll() took " + (endTime - startTime) + " ms.";
    }

    // 3. Test Batch Delete (Fast)
    @Transactional
    public String batchDeleteAll() {
        List<Product> allProducts = productRepository.findAll();
        
        long startTime = System.currentTimeMillis();
        // This executes a single SQL statement: DELETE FROM product WHERE id IN (...) 
        // all productIds will be part of Where id IN(?,?,?),so all products will be delted in one go not just
        // the batch size mentioned in properties file.
        productRepository.deleteAllInBatch(allProducts);
        long endTime = System.currentTimeMillis();
        
        return "deleteAllInBatch() took " + (endTime - startTime) + " ms.";
    }
    
 // ADD THIS NEW METHOD TO SEE THE TRUE FASTEST DELETE
    @Transactional
    public String trueFastDeleteAll() {
        long startTime = System.currentTimeMillis();
        
        // No parameters, no IN clause. Just a raw, instant table wipe.
        productRepository.deleteAllInBatch(); 
        
        long endTime = System.currentTimeMillis();
        
        return "deleteAllInBatch() (No args) took " + (endTime - startTime) + " ms.";
    }
}