




import java.awt.Desktop;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

/**
 * This is the main menu for the user, it contains all the commands that are accessible to the user in the console.
 * @author lczornyj
 *
 */
public class MainMenu {
private ArrayList<Product> products = new ArrayList<Product>();
	private static String nameOfFile = "\\desktop\\Stock_Report.txt";
	private String programDirectory = System.getProperty("user.home");
	private File file = new File(programDirectory + nameOfFile);

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
		dbc.readEntry();
		products = DatabaseConnection.getProducts();
		fileWritingMethod();
	}
	

	/**
	 *  This exports the data from the array list to a text file based on what the
	 *  user has called the file. At the end of the text file, will be a date when 
	 *  the list was created.
	 */
		
	
	@SuppressWarnings("deprecation")
	public void fileWritingMethod() {
		Calendar rightNow = Calendar.getInstance();
		try {
		
		DataOutputStream datawriting = new DataOutputStream(new FileOutputStream(file));
		datawriting.writeUTF("*** STOCK  REPORT *** \r\n\r\n");
		datawriting.writeUTF("ID\t\t\tProduct\t\t\tStock level \r\n");
		for (int i = 0; i < products.size(); ++i){
			if(products.get(i).getName().length() > 15){
				datawriting.writeUTF(products.get(i).getproductid() + "\t\t\t" + products.get(i).getName() + "\t\t" + products.get(i).getStock() + "\r\n");
			} else if (products.get(i).getName().length() < 8) {
			datawriting.writeUTF(products.get(i).getproductid() + "\t\t\t" + products.get(i).getName() + "\t\t\t\t" + products.get(i).getStock() + "\r\n");
				} else {
					datawriting.writeUTF(products.get(i).getproductid() + "\t\t\t" + products.get(i).getName()+ "\t\t\t" + products.get(i).getStock() + "\r\n");
				}
			}
		datawriting.writeUTF(rightNow.getTime().toLocaleString());
		datawriting.close();
		}
	catch(IOException e){
		}
	}
	public void open(File document) throws IOException {
			Desktop dt = Desktop.getDesktop();
		dt.open(file);
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
		for (int i = 0; i<100; ++i){
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

