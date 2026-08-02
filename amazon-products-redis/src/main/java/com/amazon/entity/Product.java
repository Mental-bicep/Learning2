package com.amazon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products-redis")
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String productName;

    private Double price;
    private Integer inventory;

    // Standard Public Zero-Argument Constructor (For Jackson/JPA engines)
    public Product() {
		// TODO Auto-generated constructor stub
	}

    // Fully Parameterized Constructor
    public Product(Long id, String productName, Double price, Integer inventory) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.inventory = inventory;
    }

    // Explicit Getters and Setters (Lombok-Free Learning Model)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }
}
