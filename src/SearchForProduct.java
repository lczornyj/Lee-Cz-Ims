

import java.util.ArrayList;
import java.util.Scanner;
/**
 * This Class is designed to fulfil all the searches required to find, edit and update any product with in the IMS.
 * @author lczornyj
 *
 */

public class SearchForProduct {
	/**
	 * newSearch is designed for the user to decide by which attribute they want to search for.
	 * @param products
	 * @return
	 */
	public Product newSearch(ArrayList<Product> products) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("Do you wish to search by name / ID? ");
		String command = in.next();
		if(command.equals("name"))
			return nameSearch(products);
		return idSearch(products);
	}
	/**
	 *  nameSearch is setup so that a user can find a product specifically by its name.
	 *	It draws on user input to determine what product the user wishes to find
	 * @param products
	 * @return
	 */
	private Product nameSearch(ArrayList<Product> products) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("What is the products name? ");
		String name = in.nextLine();
			for(Product p : products) {
				//System.out.println(p.getName() + " : " + name);

				if (p.getName().equalsIgnoreCase(name)) {
					System.out.println(p.getName() + ", " + p.getproductid() + ", " + p.getStock());
					return p;
				}
			}
			return null;
		}
	/**
	 * idSearch is setup so that a user can find a product from its id number.
	 * This requires the user to input an id number in order to find the product associated with the number.
	 * @param products
	 * @return
	 */
	private Product idSearch(ArrayList<Product> products) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("What is the products ID number? ");
		int id = in.nextInt();
			for(Product p : products) {
				if (p.getproductid() == id)
					System.out.println(p.getName() + ", " + p.getproductid() + ", " + p.getStock());
					return p;			
			}
			return null;
	}
	
}