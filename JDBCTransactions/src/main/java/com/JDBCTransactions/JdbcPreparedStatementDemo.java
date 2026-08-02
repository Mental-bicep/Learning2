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
	
	public void batchInsert() throws ClassNotFoundException, SQLException {
		String user = "root";
		String pass = "root";
		String connUrl = "jdbc:mysql://localhost:3306/kodewala";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(connUrl, user, pass);
		
		String insertQuery = "insert into payment(id,refid,status) values(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(insertQuery);
		
		int batchSize = 10;
		conn.setAutoCommit(false);
		for(int i=1; i<=100; ++i) {
			ps.setInt(1, i);
			ps.setString(2, "refid-"+i);
			ps.setString(3, "INIT");
			
			ps.addBatch();
			
			if(i%batchSize == 0) {
				System.out.println("Executing the ins query");
				ps.executeBatch();
				conn.commit();
				ps.clearBatch();
			}
		}
	}
	
	
	
}
