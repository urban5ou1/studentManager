package task_12;

//Connecting to the MySql Database performing the following CRUD operations
//1.	Create table student having enrollment number, name and marks
//2.	Insert 4-5 records into the student table
//3.	Read the student table and display in the console


import java.sql.*;

public class studentManager {

	public static void main(String[] args) {
		
		// Initialize database connection parameters
		
		String jdbcURL = "jdbc:mysql://localhost:{port_number}/{database_name}";
		String username ="_username_";
		String password ="_password_";
		
		try {
			
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			
			if(connection != null) {
				
				System.out.print("Connection Established ! \n");
				
				Statement statement = connection.createStatement();
				
				// Create table
				
				int rows = statement.executeUpdate("CREATE TABLE student(enroll_no int(3), name varchar(30),marks float(5))");
				System.out.println("A new Table has been created.");
				
				// Insert 4 rows of students
				
				rows = statement.executeUpdate("insert into student values(100, 'gon', 93)");
				System.out.println("A new entry has been added : "+rows);
				
				rows = statement.executeUpdate("insert into student values(101, 'killua', 95)");
				System.out.println("A new entry has been added : "+rows);
				
				rows = statement.executeUpdate("insert into student values(102, 'kurapika', 91)");
				System.out.println("A new entry has been added : "+rows);
				
				rows = statement.executeUpdate("insert into student values(103, 'leorio', 85)");
				System.out.println("A new entry has been added : "+rows);
				
				System.out.println("\n");
				
				// Show query-result in console
				
				ResultSet resultSet = statement.executeQuery("select * from student");
				while (resultSet.next()) {
					
					int enrol_no = resultSet.getInt(1);
					String name = resultSet.getString(2);
					float marks = resultSet.getFloat(3);
					
					System.out.println(enrol_no+" : "+name+" : "+marks);
				}
				
				connection.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
