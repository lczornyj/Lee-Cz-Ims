




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
 * The inital 
 */
	private DisplayHelp displayHelp = new DisplayHelp();
	private AddProduct add = new AddProduct();
	private SearchForProduct search = new SearchForProduct();
	private EditProduct edit = new EditProduct();
	private ArrayList<Product> products = new ArrayList<Product>();
	private String nameOfFile;
	private String fileLocation;
	private int numberGenerator;
	
	public MainMenu() {
	displayHelp.displayMenuItems();
		menuOptions();
		

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
		//calculations(numberGenerator);
		numberGenerator();
	}
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
	
		
		Calendar rightNow = Calendar.getInstance();
	public void fileWritingMethod(File outputfile) {
	try {
		DataOutputStream da = new DataOutputStream(new FileOutputStream(outputfile));
		for (int i = 0; i < products.size(); ++i){
			da.writeUTF(products.get(i).getName() + " " + products.get(i).getproductid() + " " + products.get(i).getStock() + "\r\n");
			}
		da.writeUTF(rightNow.getTime().toLocaleString());
		da.close();
		}
	catch(IOException e){
		}
	}
	
	public void numberGenerator (){
		Random generator = new Random();
		int randomDecrease = generator.nextInt(10)+1;
		System.out.println(randomDecrease);
		
		// select random product based of integer
		
		
		int maxvalue = products.size();
		Random stockgenerator = new Random();
		int stocknumber = stockgenerator.nextInt(maxvalue);
		int adjustments = products.get(stocknumber).getStock();
		int testLimits = adjustments - randomDecrease;
		if(testLimits <= 0){
			adjustments = 0;
		}	
		else {
		// needs work to find the right value and decrease, as well as have it running during programme.
			adjustments = adjustments - randomDecrease;
		}
		products.get(stocknumber).setStock(adjustments);
		
		
		
	}
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
