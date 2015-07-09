	

import java.util.ArrayList;
import java.util.Scanner;

/**
 *  This class adds products to an ArrayList
 *  The user adds a product name and a stock level for the product
 *  The method then checks the product against existing products for duplicate.
 * 
 * @author lczornyj
 *
 */


public class AddProduct {
	DatabaseConnection dbc = new DatabaseConnection();
	/**
	 * This method is designed so that a user can add a new item into the list.
	 * When the user is typing in a name, the name cannot contain any numbers, punctuation or spaces inbetween names.
	 * The method will then check to see if there are any duplicates of the name, if there are the user will be notified
	 * 
	 * @param products
	 * @return
	 */

	public ArrayList<Product> addProduct(ArrayList<Product> products) {	
		System.out.print("What is the name of the product you wish to add? ");
		@SuppressWarnings("resource")
		
		String name = ImsGUI.textField_productName.getText();
		//duplicates
		boolean exsistes = false;
		for(Product p : products) {
			if (p.getName().equalsIgnoreCase(name))
				exsistes = true;
		}
		if (!exsistes){
			System.out.print("How many items of the product do you wish to add? ");
			
			
			////////////////// FINISH ADDING PRODUCT VIA GUI!! ///////////
			
			int stockLevel = ImsGUI.textField_productStock.get;
			int numberOfProducts = products.size();
			Product product = new Product(numberOfProducts,name,stockLevel);
			products.add(product);
			dbc.createEntry(numberOfProducts, name, stockLevel);
			
		}
		else {
			System.out.println("Item already exsists");
			products = addProduct(products);
		}
		
		
		return products;
	}
}