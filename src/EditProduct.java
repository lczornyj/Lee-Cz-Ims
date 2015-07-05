

import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class is designed to allow the user to edit a specific products stock level or name.
 * 
 * @author lczornyj
 *
 */
public class EditProduct {
	private SearchForProduct search = new SearchForProduct();
	private ArrayList<Product> products;
	private Product product;
	/**
	 * This method is designed to determine whether or not a user wants to edit a product or not.
	 * @param products
	 * @return
	 */
	
	public ArrayList<Product> newEdit(ArrayList<Product> products) {
		this.products = products;
		product = search.newSearch(products);
		System.out.print("Do you wish to edit this product? yes / no: ");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String edit = in.next();
		if(edit.equalsIgnoreCase("yes"))
			whatToEdit();
		return products;
	}
	/**
	 * This method determines what you want to edit based on a user input.
	 * If the user types "name", it then uses the editName method.
	 * If the user types anything other than name, then it registers it as stock and uses the editStock method.
	 */
	private void whatToEdit() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("Do you wish to edit the name / stock: ");
		String type = in.next();
		if(type.equalsIgnoreCase("name")){
			editName();
		System.out.println(product.getName() + ", " + product.getproductid() + ", " + product.getStock());}

		else {
			editStock();
			System.out.println(product.getName() + ", " + product.getproductid() + ", " + product.getStock());	
		}
	}
/**
 * This is the editName method, it requires the user to input a new name for the product, and then saves that new name for the product.
 * From here it then finds the original product in the ArrayList using the findIndexOf method and changes the name to what was typed.
 * When typing in a new name, there must not be any spaces, numbers or punctuation.
 */
	private void editName() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("What is the products new name? ");
		String name = in.nextLine();
		product.setName(name);
		products.set(findIndexOf(product), product);
	}
/**
 * This is the editStock method, it requires the user to input a new stock level for the product, and then saves that new quantity for the product.
 * From here it then finds the original product in the ArrayList using the findIndexOf method and changes the stock level to what was typed.
 * When typing in a new name, there must not be any spaces, letters or punctuation.
 */
	private void editStock() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("What is the products new stock level? ");
		int stock = in.nextInt();
		product.setStock(stock);
		products.set(findIndexOf(product), product);
	}
	/**
	 * This method locates the original products id based off of the product that was searched at the start of the class.
	 * It then finds the product in the ArrayList so that one of the edit methods can adjust the name/stock levels.
	 * @param product
	 * @return
	 */
	private int findIndexOf(Product product){
		for (int i = 0; i < products.size(); i++) {
			Product p = products.get(i);
			if (p.getproductid() == product.getproductid())
				return i;
		}
		return products.size()+1;
	}
}