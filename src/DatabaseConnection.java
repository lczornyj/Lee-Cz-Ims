
import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {
	
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	 //static final String DB_URL = "jdbc:mysql://Localhost:3306/mydb";  
	 static final String DB_URL = "jdbc:mysql://10.50.15.30:3306/mydb";  
	 static final String USER = "LC";  
	 //static final String PASS = "root";
	 static final String PASS = "Chutney2000";
	 static Connection conn = null;
	 static Statement stmt = null;
	 private static ArrayList<Product> products;
	 
	 
	 public DatabaseConnection() { 
		 products = new ArrayList<Product>();
		 openConnection();
		
	 }
	 
	 public void openConnection(){
		 try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public void createEntry(int numberOfProducts, String name, int stockLevel) {
		 try { 
		 //System.out.println("Inserting records into the table..."); 
			 
		 stmt = conn.createStatement();
		 String sql = "INSERT INTO imsdatabase (Name, Stock) VALUES ('"+ name + "', " + stockLevel+ ")";
		 //System.out.println(sql);
		 stmt.executeUpdate(sql);
		 System.out.println("Inserted records into the table...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public static void readEntry () {
		 System.out.println("Creating statement...");
		 try {
			stmt = conn.createStatement();
		
			// TODO Auto-generated catch block
			
		 String sql2 = "SELECT * FROM imsdatabase";
		 	products.clear();
		 	ResultSet rs = stmt.executeQuery(sql2); 
		 
		 	while (rs.next()) { 
		 	
		 		products.add(new Product(rs.getInt("ID"), rs.getString("Name"),  rs.getInt("Stock")));
		 		}
		 	/*for(Product pr : products){
		 		System.out.println("Product ID: " + pr.getproductid() + ", Product Name: " + pr.getName() + ", Stock Amount: " + pr.getStock());
		 	}*/
		 	rs.close();
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
	 }
	 
	 public void updateEntry(int findProductIndex, String name, int stock){
		 String sql3="";
		 
			if(stock==-1){
	  		 	sql3 =  "UPDATE imsdatabase SET Name = '" +  name  + "' WHERE ID = " + findProductIndex;
	  		 	
	
		 System.out.println("Creating statement...");
		 try {
			stmt = conn.createStatement();	
		 	stmt.executeUpdate(sql3);
		 	} catch (SQLException e) {
			// TODO Auto-generated catch block
		 		e.printStackTrace();
		 	}
			}else{
		 
			 	try {
			 		stmt = conn.createStatement();
				  	sql3 =  "UPDATE imsdatabase SET Stock = " + stock + " WHERE ID = " + findProductIndex;
			 	stmt.executeUpdate(sql3);
			 	} catch (SQLException e) {
				// TODO Auto-generated catch block
			 		e.printStackTrace();
			 	}
		 	
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
	 
	 public static ArrayList<Product> getProducts(){
		 readEntry();
		 return products;
	 }
	 
	 public int getArraySize(){
		 return products.size();
	 }
}



