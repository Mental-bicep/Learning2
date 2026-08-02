package com.EcomMpJdbc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartService {
	
	ProductService productService;
	
	Connection conn;
	
	String insert;
	PreparedStatement insertQuery ;
	
	String removeString;
	PreparedStatement removeQuery;
	
	String viewCartString;
	PreparedStatement viewCartQuery;
	
	public CartService() throws SQLException, ClassNotFoundException {
		productService = new ProductService();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String connUrl = "jdbc:mysql://localhost:3306/ecom_mp_jdbc_based";
		conn = DriverManager.getConnection(connUrl,"root","root");
		
		insert = "insert into cart(user_id,product_id,qty,product_name) values(?,?,?,?)";
		insertQuery = conn.prepareStatement(insert);
		
		removeString = "update cart set qty=? where user_id=? and product_id=?";
		removeQuery = conn.prepareStatement(removeString);
		
		viewCartString = "select p.product_name,c.qty from cart c left join products p on c.product_id = p.product_id where c.user_id=?";
		viewCartQuery = conn.prepareStatement(viewCartString);
	}
	
	public void addToCart(int userId, String productName, int qty) throws SQLException {
		int productId = productService.getProductId(productName);
		if(productId == -1) System.out.println("Need to throw exception no such product");
		
		insertQuery.setInt(1,userId);
		insertQuery.setInt(2,productId);
		insertQuery.setInt(3,qty);
		insertQuery.setString(4, productName);
		
		boolean res = insertQuery.execute();
		if(res == false) System.out.println("Could not addtocart");
		else System.out.println("Added to cart successfully");
	}
	
	public void removeFromCart(int userId, String productName, int qty) throws SQLException {
		int productId = productService.getProductId(productName);
		if(productId == -1) System.out.println("Need to throw exception no such product");
		
		// REM: first make a check if already existing qty > removefrom cart qty 
		int rowsUpdated = removeQuery.executeUpdate();
	}
	
	public void viewCart(int userId) throws SQLException {
		ResultSet res = viewCartQuery.executeQuery();
		while(res.next()) {
			String productName = res.getString("product_name");
			int qty = res.getInt("qty");
			
			System.out.println(productName+"***"+qty);
			
		}
	}
	
}
