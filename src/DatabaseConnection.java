
import java.sql.*;

public class DatabaseConnection {
	
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	 static final String DB_URL = "jdbc:mysql://10.50.15.30:3306/mydb";  
	 static final String USER = "LC";  
	 static final String PASS = "Chutney2000";
	 static Connection conn = null;
	 static Statement stmt = null;
	 
	 public DatabaseConnection() { 
		 openConnection();
		
	 }
	 
	 public void openConnection(){
		 System.out.println("Connecting to database...");
		 try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public void createEntry() {
		 try { 
		 System.out.println("Inserting records into the table..."); 
		 int ID = 5; String ProductName = "Jake Gnome"; int StockAmount = 16;
		 stmt = conn.createStatement();
		 String sql = "INSERT INTO imsdatabase VALUES ("+ID+", '" +ProductName+ "', " + StockAmount+ ")";
		 System.out.println(sql);
		 stmt.executeUpdate(sql);
		 System.out.println("Inserted records into the table...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public void readEntry () {
		 System.out.println("Creating statement...");
		 try {
			stmt = conn.createStatement();
		
			// TODO Auto-generated catch block
			
		 String sql2 = "SELECT * FROM imsdatabase";
		 ResultSet rs = stmt.executeQuery(sql2); 
		 
		 	while (rs.next()) { 
		 		int ID = rs.getInt("ID");
		 		String Product = rs.getString("Name");
		 		int Stock = rs.getInt("Stock");
		 		System.out.println("Product ID: " + ID + ", Product Name: " + Product + ", Stock Amount: " + Stock);
		 		}
		 	rs.close();
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
	 }
	 
	 public void updateEntry(){
		 System.out.println("Creating statement...");
		 	try {
				stmt = conn.createStatement();
			
				
			
		 	String sql3 =  "UPDATE imsdatabase SET Stock = 100 WHERE ID = 2";
		 	stmt.executeUpdate(sql3);
		 	} catch (SQLException e) {
			// TODO Auto-generated catch block
		 		e.printStackTrace();
		 	}
	 }
	 

	 public void closeConnection() {
	

	 
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
		 System.out.println("Goodbye!"); 
		} 
	 
	
}



