

import java.util.ArrayList;

/**
 * This Class is designed to fulfil all the searches required to find, edit and update any product with in the IMS.
 * @author lczornyj
 *
 */

public class SearchForProduct {
	DatabaseConnection dbc = new DatabaseConnection();
	private String findProductbyName;// = ImsGUI.textField_findProductByName.getText();
	
	
	
	private int findProductById;// = Integer.parseInt(ImsGUI.textField_findProductById.getText());
	public SearchForProduct() {
	
		try
		{
			findProductbyName = ImsGUI.textField_findProductByName.getText();
				
		}
		catch (Exception e)
		{
			//System.out.println("ERROR 1");

		}
		try
		{
			findProductById = Integer.parseInt(ImsGUI.textField_findProductById.getText());	
		}
		catch (Exception e)
		{
			//System.out.println("ERROR 2");
		}
		
		
	}
	
	/*public void ReturnProductNumber(String tempString)
	{
		try
		{
			if(tempString != "")
			{	
				findProductById = Integer.parseInt(tempString);
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}*/
	/**
	 * newSearch is designed for the user to decide by which attribute they want to search for.
	 * @param products
	 * @return
	 */
	
	public Product newSearch(ArrayList<Product> products) {
		
		if(ImsGUI.textField_findProductById != null){
		//	System.out.println(products);
			return idSearch(products);
		}
		
		return nameSearch(products);
	}
	
	public Product newSearch(ArrayList<Product> products, boolean byID)
	{
		if(byID == true)
		{
			return idSearch(products);
		}
		else
		{
			return nameSearch(products);
		}
	}
	/**
	 *  nameSearch is setup so that a user can find a product specifically by its name.
	 *	It draws on user input to determine what product the user wishes to find
	 * @param products
	 * @return
	 */
	private Product nameSearch(ArrayList<Product> products) {
		
			String name = findProductbyName;
		
			for(Product p : products) {

				if (p.getName().equalsIgnoreCase(name)) {
					//System.out.println("ID:"+ p.getproductid() + ", Name: " + p.getName() + ",Stock Level: " + p.getStock());
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
			int id = findProductById;
			for(Product p : products) {
				if (p.getproductid() == id){
					//System.out.println("ID: " +p.getproductid()+ ", Name: " + p.getName() + ", Stock level " + p.getStock());
					
					
					return p;		
				}
			
			}
			return null;
	}
	
}