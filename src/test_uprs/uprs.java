package test_uprs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class uprs {

	public static void main(String[] args) {
		
		String jdbc = "jdbc:mysql://localhost:3306/db";
		String username = "";
		String password = "";
		
		try(Connection conn = DriverManager.getConnection(jdbc, username, password)) {
			
			// Create Updatable result set
			Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rSet = stm.executeQuery("select enroll_no, name from student");
			
			// Move Cursor 
			rSet.first();
			System.out.println("Roll no. : " + rSet.getInt("enroll_no") + "  Name : " + rSet.getString("name"));
					
			rSet.absolute(2);
			System.out.println("Roll no. : " + rSet.getInt("enroll_no") + "  Name : " + rSet.getString("name"));
			
			rSet.last();
			System.out.println("Roll no. : " + rSet.getInt("enroll_no") + "  Name : " + rSet.getString("name"));
			
			// To Insert new Row
//			rSet.moveToInsertRow();
//			
//			rSet.updateInt("enroll_no", 103);
//			rSet.updateString("name", "jim");
//			rSet.insertRow();
//			
//			rSet.moveToCurrentRow();
			
			// Delete last Row
//			rSet.last();
//			rSet.deleteRow();

			
//			// To Update 3rd row
			rSet.last();
			rSet.updateInt("enroll_no", 104);
			rSet.updateString("name", "ram");
			
			rSet.updateRow();
			
			
			// Print updated data
			System.out.println("\n New Result : ");
			
			rSet.beforeFirst();
			while (rSet.next()) {
	            System.out.println("Roll no. : " + rSet.getInt("enroll_no") + 
	            		" \t Name : " + rSet.getString("name"));
	         }

			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
