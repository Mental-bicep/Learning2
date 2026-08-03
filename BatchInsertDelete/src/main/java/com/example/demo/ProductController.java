package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Endpoint to trigger batch inserts
    @PostMapping("/insert")
    public String insertData() {
        return productService.insertThousandsOfRecords();
    }

    // Endpoint to test slow standard deletion
    @DeleteMapping("/delete-standard")
    public String deleteStandard() {
        return productService.standardDeleteAll();
    }

    // Endpoint to test fast batch deletion
    @DeleteMapping("/delete-batch")
    public String deleteBatch() {
        return productService.batchDeleteAll();
    }
    
 // ADD THIS ENDPOINT FOR THE TRUE FAST DELETE
    @DeleteMapping("/delete-fastest")
    public String deleteFastest() {
        return productService.trueFastDeleteAll();
    }
}