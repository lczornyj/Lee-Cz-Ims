	

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
		@SuppressWarnings("resource")	
		String name = products.get(0).getName();//ImsGUI.textField_productName.getText();
		//duplicates
		boolean exsistes = false;
		for(Product p : dbc.getProducts()) {
			if (p.getName().equalsIgnoreCase(name))
				exsistes = true;
		}
		if (!exsistes){
			////////////////// FINISH ADDING PRODUCT VIA GUI!! ///////////
			int stockLevel = Integer.parseInt(ImsGUI.textField_productStock.getText());
			int numberOfProducts = products.size();
			Product product = new Product(numberOfProducts,name,stockLevel);
			
			products.add(product);
			dbc.createEntry(numberOfProducts, name, stockLevel);
		}
		else {
			System.out.println("Item already exsists");
			//products = addProduct(products);
		}
		
		
		return products;
	}
}