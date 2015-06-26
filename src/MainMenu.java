




import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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
		//String localTime = rightNow.toString();
	//System.out.println(rightNow.getTime().toLocaleString());
	
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

	/*	
	try { PrintWriter filewriter = new PrintWriter(new BufferedWriter( new FileWriter(fileLocation+nameOfFile+".txt", true)));
	//	File file = new File(fileLocation+nameOfFile+".txt");
		//file.createNewFile();
	for (int i = 0; i < products.size(); ++i) {
		filewriter.println(products.get(i).getName() + " " + products.get(i).getproductid() + " " + products.get(i).getStock());	
		}
	}
		catch (IOException e) {
		} */
	}
	
