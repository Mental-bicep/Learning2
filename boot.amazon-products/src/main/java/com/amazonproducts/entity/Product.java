package com.amazonproducts.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products") // Maps this class to the 'products' collection 
public class Product {

    @Id
    private String id; // MongoDB uses String/ObjectId for unique IDs [cite: 253]
    private String productName;
    private Double price;
    private String category;
    private Integer inventory;

    // Default Constructor
    public Product() {
    }

    // Parameterized Constructor
    public Product(String id, String productName, Double price, String category, Integer inventory) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.inventory = inventory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }
}