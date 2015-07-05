
import java.sql.*;

public class DatabaseConnection {
	
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	 static final String DB_URL = "jdbc:mysql://localhost/mydb";  
	 static final String USER = "root";  
	 static final String PASS = "Chutney2000";
	 static Connection conn = null;
	 static Statement stmt = null;
	 
	 public void accessBD() {  
	 // create connection but not assigning a location
	   
	 // format of what i need to send
	 createProduct();
	 }
	 public void createProduct() {
	 try {
		 
		 Class.forName( "com.mysql.jdbc.Driver");
		 System.out.println("Connecting to database...");
		 conn = DriverManager.getConnection(DB_URL, USER, PASS);
		 System.out.println("Inserting records into the table..."); 
		 String ProductName = "Happy Gnome"; int StockAmount = 16;
		 stmt = conn.createStatement();
		 String sql = "INSERT INTO imsdatabase (\"Product Name\", \"Stock Amount\") " + "VALUES (\"" +ProductName+ "\"," + StockAmount+ ");";
		 System.out.println(sql);
		 stmt.executeUpdate(sql);
		 System.out.println("Inserted records into the table...");
		 System.out.println("Creating statement...");
		 stmt = conn.createStatement(); String sql2 = "SELECT ID, Product Name, Stock Amount FROM imsdatabase";
		 ResultSet rs = stmt.executeQuery(sql2); 
		 	while (rs.next()) { 
		 		int id = rs.getInt("id");
		 		String name = rs.getString("name");
		 		int date = rs.getInt("date");
		 		System.out.println("ID: " + id + ", name: " + name + ", date: " + date);
		 		}
	 	rs.close();
	 	
	 	System.out.println("Creating statement...");
	 	stmt = conn.createStatement();
	 	String sql3 =  "UPDATE Languages " + "SET date = 1994 WHERE id in (1, 2)";
	 	stmt.executeUpdate(sql3);
	 	System.out.println("Creating statement..."); 
	 	stmt = conn.createStatement();
	 	String sql4 = "DELETE FROM Languages " + "WHERE id = 1";
	 	stmt.executeUpdate(sql4);
	 } catch (SQLException sqle) {  
		 sqle.printStackTrace(); 
	 }
	 catch (Exception e) {  
		 e.printStackTrace(); 
	} finally { 
		 try { 
			 if (stmt != null)    conn.close();  
		 	}
		 catch (SQLException se) {		
		 } try {  
			 if (conn != null)     
			conn.close();    
		 	} catch (SQLException se) {    
		se.printStackTrace(); 
			}
		} 
	 System.out.println("Goodbye!"); 
	}
}



