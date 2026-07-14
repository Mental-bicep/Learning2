package com.JDBCTransactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcPreparedStatementDemo {
	
	public void updateUsingPS(String status, int id) throws ClassNotFoundException, SQLException {
		String user = "root";
		String pass = "root";
		String connUrl = "jdbc:mysql://localhost:3306/kodewala";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(connUrl, user, pass);
		
		String updateQuery  = "update payment set status=? where id=?";
		PreparedStatement ps = conn.prepareStatement(updateQuery);
		
		ps.setString(1, status);
		ps.setInt(2, 1);
		
		int rows = ps.executeUpdate();
		if(rows > 0) System.out.println("record updated");
		else System.out.println("failure could not update records");
		
	}
	
	
	
}
