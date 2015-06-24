

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

	private DisplayHelp displayHelp = new DisplayHelp();
	private Add add = new Add();
	private Search search = new Search();
	private Edit edit = new Edit();
	private ArrayList<Product> products = new ArrayList<Product>();
		
	public MainMenu() {
		displayHelp.displayMenuItems();
		menuOptions();
	}
	
	private void menuOptions() {
		Scanner in = new Scanner(System.in);
		String command = in.next();
		switch (command) {
		case "Help": 
			displayHelp.displayMenuItems();
			break;
		case "Add": 
			add.addProduct(products);
			break;
		case "Edit":
			products = edit.newEdit(products);
			break;
		case "Search":
			search.newSearch(products);
			break;
		case "End": 
			System.out.println("I wanu end");
			break;
		}
	}
}