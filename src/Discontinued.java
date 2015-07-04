import java.util.ArrayList;
import java.util.Scanner;


public class Discontinued {

	private SearchForProduct search = new SearchForProduct();
	private ArrayList<Product> products;
	private Product product;
	public Discontinued () {
		
		System.out.println("Do you want to discontinue a product? ");
		Scanner in = new Scanner(System.in);
		String yes = in.next();
		
		if(in.equals("yes")){
			
			this.products = products;
			product = search.newSearch(products);
			
			
			
			
		}
		
	}
	public ArrayList<Product> newDiscontinue(ArrayList<Product> products) {
		
		
		return products;
		
	}
	
}
