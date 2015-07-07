
public class ims {

	public static void main(String[] args) {

		//@SuppressWarnings("unused")		
		DatabaseConnection dbc = new DatabaseConnection();
		dbc.getProducts();
		
		MainMenu mainMenu = new MainMenu(dbc);
		
		//new ImsGUI();
		//dbc.readEntry();
		//dbc.updateEntry();
		
		//dbc.closeConnection();
		
	}
	
}
