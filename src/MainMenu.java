




import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

/**
 * This is the main menu for the user, it contains all the commands that are accessible to the user in the console.
 * @author lczornyj
 *
 */
public class MainMenu {
/**
 * The inital declaration of the objects in the main method along with any variables. 
 */
	private DisplayHelp displayHelp = new DisplayHelp();
	private AddProduct add = new AddProduct();
	private SearchForProduct search = new SearchForProduct();
	private EditProduct edit = new EditProduct();
	private ArrayList<Product> products = new ArrayList<Product>();
	private String nameOfFile;
	private String fileLocation;
	
	/**
	 * The main method which is the central controller of the IMS created.
	 * This contains all commands used to initialise the programme along with the construction
	 * of the IMS.
	 * The main menu with the various commands are then accessed through the menuOptions method.
	 */
	
	public MainMenu() {
	displayHelp.displayMenuItems();
		menuOptions();
		
/**
 * Determines the files location and name using user inputs.
 * Then the list of products are output at the end of the inputs.
 */
		System.out.print("Enter the files location: ");
		Scanner in = new Scanner(System.in);
		fileLocation = in.nextLine().trim();
		System.out.print("What is the files name? ");
		Scanner user = new Scanner(System.in);
		nameOfFile = user.nextLine();
		File file = new File(fileLocation + nameOfFile+".txt");
		fileWritingMethod(file);
		for(Product product : products) 
		{
			System.out.println(product.getName() + ", " + product.getproductid() + ", " + product.getStock());			
		}
		numberGenerator();
	}
	/**
	 * The main menu options. This contains a user input at the start which then activates
	 * a particular method. This then loops round back to the main menu so that another
	 * method can be used. If at any point the user types in "End" the loop is broken and the
	 * main menu is terminated.
	 */
	private void menuOptions() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String command = in.next();
		switch (command) {
		case "Help": 
			displayHelp.displayMenuItems();
			menuOptions();
			break;
		case "Add": 
			products = add.addProduct(products);
			fileWritingMethod(null);
			menuOptions();
			break;
		case "Edit":
			products = edit.newEdit(products);
			menuOptions();
			break;
		case "Search":
			search.newSearch(products);
			menuOptions();
			break;
		case "End": 
			System.out.println("I want to end");
			break;
			default:
				System.out.println("I want to end");
				break;	
		}
	}
	/**
	 *  This exports the data from the array list to a text file based on what the
	 *  user has called the file. At the end of the text file, will be a date when 
	 *  the list was created.
	 */
		Calendar rightNow = Calendar.getInstance();
	public void fileWritingMethod(File outputfile) {
	try {
		DataOutputStream da = new DataOutputStream(new FileOutputStream(outputfile));
		da.writeUTF("Product   ID   Stock level \r\n");
		for (int i = 0; i < products.size(); ++i){
			da.writeUTF(products.get(i).getName() + "     " + products.get(i).getproductid() + "       " + products.get(i).getStock() + "\r\n");
			}
		da.writeUTF(rightNow.getTime().toLocaleString());
		da.close();
		}
	catch(IOException e){
		}
	}
	/**
	 * This is a random number generator to simulate the decrement of the stock
	 * level. If at any point a products stock level gets below 15, the method
	 * then outputs a warning.
	 */
	public void numberGenerator (){
		Random generator = new Random();
		int randomDecrease = generator.nextInt(10)+1;
		// select random product based of random integer selected and take product id from that number
		int maxvalue = products.size();
		Random stockgenerator = new Random();
		int stocknumber = stockgenerator.nextInt(maxvalue);
		int adjustments = products.get(stocknumber).getStock();
		int testLimits = adjustments - randomDecrease;
		if(testLimits <= 0){
			adjustments = 0;
		}	
		else { 
			adjustments = adjustments - randomDecrease;
		}
		products.get(stocknumber).setStock(adjustments);
		if (products.get(stocknumber).getStock() < 15){
			//System.out.println("the product" + (products.getName() + ", ID number " + product.getproductid() + ", has stock of " + product.getStock() + "Reorder this product");
			System.out.println("test");
		}
	}
	
	
	// work in progress for decrement along side the main method.
	public static void calculations(int numberGenerator) {
		
		for (int i = 0; i<1000000000; ++i){
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		}
	}	
}
