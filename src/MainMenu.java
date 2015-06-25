



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
		
	public MainMenu() {
		displayHelp.displayMenuItems();
		menuOptions();
		for(Product product : products) 
		{
			System.out.println(product.getName() + ", " + product.getproductid() + ", " + product.getStock());
			WriteToFile();
		}
	}
	/*WriteFile data = new WriteFile( "Test" , true );
	private String path;
	private boolean append_to_file = false;
	
	public void WriteFile(String file_path){
		path = file_path;
	}
	public void WriteFile(String file_path, boolean append_value){
		path = file_path;
		append_to_file =append_value;
	}
	public void WriteToFile(String TextLine) throws IOException {
		FileWriter write = new FileWriter(path, append_to_file);
	PrintWriter print_line =new PrintWriter(write);
	print_line.printf("%s " + "%n", TextLine);
	print_line.close();
	}
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
	public static void WriteToFile() {
		try {
			String content = "this is the content";
			String Filename = "testing";
			File file = new File("C:\\users\\lczornyj\\workspace\\Lee-Cz-Ims\\" +Filename );
			if (!file.exists() ) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
			System.out.println("done");
		} catch (IOException e) {
			e.printStackTrace();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		}
		
		
	}
