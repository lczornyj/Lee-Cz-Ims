

public class Product {
	
	private String name;
	private int productid;
	private int stock;
	
	public Product(int productid,String name, int lvl)
	{
		this.name = name;
		this.stock = lvl;
		this.productid = productid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getproductid() {
		return productid;
	}
	public void setproductid(int productid) {
		this.productid = productid;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	} 
	public String toString(String string){
		String stringA;
		stringA = this.name;
		return stringA;
	}
	
}