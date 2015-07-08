




import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
	private int fileversiron = 0;
	private DatabaseConnection dbc;
	/**
	 * The main method which is the central controller of the IMS created.
	 * This contains all commands used to initialise the programme along with the construction
	 * of the IMS.
	 * The main menu with the various commands are then accessed through the menuOptions method.
	 */
	
	//public void runthread() {
	//	System.out.println("Do you wish to simulate sales? ");
	//	Scanner in = new Scanner(System.in);
	//	String yes = in.next();
	//	if (yes.equalsIgnoreCase("yes")){
	//	calculations(numberGenerator());
	//	}
	//	else {
	//
	//	}
	//}
	
	public MainMenu(DatabaseConnection dbc) {
		this.dbc = dbc;
		dbc.readEntry();
		products = dbc.getProducts();
		System.out.print("Enter the files location: ");
		Scanner in = new Scanner(System.in);
		fileLocation = in.nextLine().trim().toLowerCase();
		System.out.print("What is the files name? ");
		Scanner user = new Scanner(System.in);
		nameOfFile = user.nextLine().toLowerCase();
		File file = new File(fileLocation + nameOfFile+"" + fileversiron + ".txt");
		displayHelp.displayMenuItems();
		
		menuOptions();
		fileWritingMethod();
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
		switch (command.toLowerCase()) {
		case "help": 
			displayHelp.displayMenuItems();
			menuOptions();
			break;
		case "add": 
			products = add.addProduct(products);
			fileWritingMethod();
			menuOptions();
			break;
		case "edit":
			products = edit.newEdit(products);
			fileWritingMethod();
			menuOptions();
			break;
		case "search":
			search.newSearch(products);
			menuOptions();
			break;
		case "Discontinue product":
			
			break;
		case "end": 
			System.out.println("I want to end");
			dbc.closeConnection();
			break;
			
		}
	}
	/**
	 *  This exports the data from the array list to a text file based on what the
	 *  user has called the file. At the end of the text file, will be a date when 
	 *  the list was created.
	 */
		
	private String fileLocation;
	public void fileWritingMethod() {
		Calendar rightNow = Calendar.getInstance();
		try {
		File file = new File(fileLocation + nameOfFile+"" + fileversiron + ".txt");
		DataOutputStream datawriting = new DataOutputStream(new FileOutputStream(file));
		datawriting.writeUTF("*** STOCK  REPORT *** \r\n\r\n");
		datawriting.writeUTF("Product   ID   Stock level \r\n");
		for (int i = 0; i < products.size(); ++i){
			datawriting.writeUTF(products.get(i).getName() + "     " + products.get(i).getproductid() + "       " + products.get(i).getStock() + "\r\n");
			}
		datawriting.writeUTF(rightNow.getTime().toLocaleString());
		datawriting.close();
		}
	catch(IOException e){
		}
	}
	
	/**
	 * This is a random number generator to simulate the decrement of the stock
	 * level. If at any point a products stock level gets below 15, the method
	 * then outputs a warning.
	 */
	public int numberGenerator (){
		Random generator = new Random();
		int randomDecrease = generator.nextInt(5)+1;
		// select random product based of random integer selected and take product id from that number
		int maxvalue = products.size();
		Random stockgenerator = new Random();
		if (maxvalue > 0){
			//System.out.println("test1");
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
				fileWritingMethod();
				int threshold = products.get(stocknumber).getStock();
				if (threshold >= 25 && threshold <50){
					System.out.println("product: " + products.get(stocknumber).getName() + " is low, reorder stock");
				} else if (threshold > 0 && threshold <25) {
					System.out.println("product: " + products.get(stocknumber).getName() + " is critical, reorder stock now");
				}  else if (threshold ==0) {
					System.out.println("product: " + products.get(stocknumber).getName() + " is out of stock, urgent attention required");	
				}
			}
		
		
		return 1;
	}
	// work in progress for decrement along side the main method.
	public void calculations(int numberGenerator) {
		for (int i = 0; i<1000000000; ++i){
			try {
				numberGenerator();
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	}
			public void run() {
			calculations(numberGenerator());
			//Runnable;
		}
	
}

