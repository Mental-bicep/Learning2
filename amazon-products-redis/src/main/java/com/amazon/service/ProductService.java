package com.amazon.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.amazon.entity.Product;
import com.amazon.repository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 1. CREATE: Persists record rows directly into local MySQL tables
    public Product saveProduct(Product product) {
        System.out.println(">>> [MySQL Database Log]: Writing new row directly to local SQL tables.");
        return productRepository.save(product);
    }

    // 2. READ: Checks the remote Upstash cloud cache bucket first. On miss, hits local MySQL.
    // (CahceName, key) -> upstashProductsCache::101 , upstashProductsCache::109 etc
    // value -> cacheName, key ->key in redis
    @Cacheable(value = "upstashProductsCache", key = "#id")
    public Product findProductById(Long id) {
        System.out.println(">>> [Cache Miss Log]: Key not found in Upstash. Querying local MySQL for ID: " + id);
        
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            throw new RuntimeException("Product record not found in MySQL database for ID: " + id);
        }
    }

    // 3. UPDATE: Syncs updated details with local MySQL and forces a refresh to the matching Upstash cloud key
    @CachePut(value = "upstashProductsCache", key = "#product.id")
    public Product updateProductDetails(Product product) {
        System.out.println(">>> [MySQL Database Log]: Updating row inside local SQL tables for ID: " + product.getId());
        if (!productRepository.existsById(product.getId())) {
            throw new RuntimeException("Cannot update. Target product record does not exist.");
        }
        return productRepository.save(product);
    }

    // 4. DELETE: Wipes the database row from local MySQL and clears the corresponding key from Upstash cloud memory
    @CacheEvict(value = "upstashProductsCache", key = "#id")
    public void deleteProductFromSystem(Long id) {
        System.out.println(">>> [MySQL Database Log]: Dropping row from local SQL tables for ID: " + id);
        productRepository.deleteById(id);
    }
}
