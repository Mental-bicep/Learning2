package com.EcomMpJdbc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductService {
	
	Connection conn;
	String showAllProducts;
	PreparedStatement showAllProductsQuery;
	String displayProductDetailsByName;
	PreparedStatement displayProductDetailsByNameQuery;
	
	
	public ProductService() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String connUrl = "jdbc:mysql://localhost:3306/ecom_mp_jdbc_based";
		conn = DriverManager.getConnection(connUrl,"root","root");
		
		showAllProducts = "select * from products";
		showAllProductsQuery=conn.prepareStatement(showAllProducts);
		
		displayProductDetailsByName = "select * from products where product_name=?";
		displayProductDetailsByNameQuery = conn.prepareStatement(displayProductDetailsByName);
	}
	
	public void viewAvailableProducts() throws SQLException {
		
		 ResultSet res = showAllProductsQuery.executeQuery();
		 
		 while (res.next()) {
			 String productName = res.getString("product_name");
			 float price = res.getFloat("price");
			 System.out.println(productName + "--"+ price);
			
		}
	}
	
	void displayProductDetails(String productName) throws SQLException {
		displayProductDetailsByNameQuery.setString(1,productName);
		ResultSet res = displayProductDetailsByNameQuery.executeQuery();
		while(res.next()) {
			int productId = res.getInt("product_id");
			String prodName = res.getString("product_name");
			float price = res.getFloat("price");
			int qty = res.getInt("quantity");
			System.out.println(productId+"**"+prodName+"**"+price+"**"+qty);
			
		}
	}
	
	int getProductId(String productName) throws SQLException {
		displayProductDetailsByNameQuery.setString(1,productName);
		ResultSet res = displayProductDetailsByNameQuery.executeQuery();
		while(res.next()) {
			int productId = res.getInt("product_id");
			return productId;
		}
		return -1;
	}

	
}
