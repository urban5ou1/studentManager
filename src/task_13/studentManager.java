package task_13;

//Connecting to the MySql Database performing the following CRUD operations
//1.	Create database named “testDB”
//2.	In this database, create a table book having the columns bookID, bookName, authorName and numberOfPages
//3.	Insert 4-5 records into this table from Java application
//4.	Display the table records in the console
//5.	Delete 1-2 records from this table from Java application
//6.	Update 1 or 2 records and display


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
				String table_name = "student";
				int rows = statement.executeUpdate("CREATE TABLE "+table_name+"(bookID int(5), bookName varchar(30), authorName varchar(30), numberOfPages int(5))");
				System.out.println("A new Table '"+table_name+"' has been created.");
				
				
				// Insert 4 rows of students
				
				rows = statement.executeUpdate("insert into student values(11223, 'Harry Potter', 'JK rowling', 1242)");
				System.out.println("A new entry has been added : "+rows);
				
				rows = statement.executeUpdate("insert into student values(12123, 'The Book', 'Anonymous', 330)");
				System.out.println("A new entry has been added : "+rows);
				
				rows = statement.executeUpdate("insert into student values(13213, 'New India', 'JJ Singh', 240)");
				System.out.println("A new entry has been added : "+rows);
				
				rows = statement.executeUpdate("insert into student values(33221, 'Learn Core Java', 'Cay Horstmann', 1040)");
				System.out.println("A new entry has been added : "+rows);
				
				System.out.println("\n");
				
				// Show query-result in console
				
				ResultSet resultSet = statement.executeQuery("select * from student");
				while (resultSet.next()) {
					
					int book_id = resultSet.getInt(1);
					String book_name = resultSet.getString(2);
					String author_name = resultSet.getString(3);
					int pages = resultSet.getInt(4);
					
					System.out.println(book_id+" : "+book_name+" : "+author_name+" : "+pages);
				}
				
				System.out.println("\n");
				
				// Delete 1 record
				rows = statement.executeUpdate("delete from "+table_name+" where bookID=12123");
				System.out.println("One record deleted..");
				
				// Show query-result in console
				
				resultSet = statement.executeQuery("select * from student");
				while (resultSet.next()) {
					
					int book_id = resultSet.getInt(1);
					String book_name = resultSet.getString(2);
					String author_name = resultSet.getString(3);
					int pages = resultSet.getInt(4);
					
					System.out.println(book_id+" : "+book_name+" : "+author_name+" : "+pages);
				}
				
				System.out.println("\n");
				
				//Update 1 record
				
				rows = statement.executeUpdate("update "+table_name+" set authorName='Arvind' where bookID=13213");
				System.out.println("One record updated..");
				
				// Show query-result in console
				
				resultSet = statement.executeQuery("select * from student");
				while (resultSet.next()) {
					
					int book_id = resultSet.getInt(1);
					String book_name = resultSet.getString(2);
					String author_name = resultSet.getString(3);
					int pages = resultSet.getInt(4);
					
					System.out.println(book_id+" : "+book_name+" : "+author_name+" : "+pages);
				}
				
				connection.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
