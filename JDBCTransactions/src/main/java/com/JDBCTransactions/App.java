package com.JDBCTransactions;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
//    	JDBCTxns obj = new JDBCTxns();
    	
    	JdbcPreparedStatementDemo ps = new JdbcPreparedStatementDemo();
    	
    	
    	try {
//			obj.placeOrder();
    		
    		ps.updateUsingPS("checking", 1);
    		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
