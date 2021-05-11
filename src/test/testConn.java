package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testConn {

	public static void main(String[] args) {
		
		// Initialize database connection parameters
		
		String jdbcURL = "jdbc:mysql://localhost:3306/db";
		String username = "";
		String password = "";
		
		try {
			
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			
			if(connection != null) {
				
				System.out.print("Connection Established ! \n");
				
				connection.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}