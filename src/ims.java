
public class ims {

	public static void main(String[] args) {

		//@SuppressWarnings("unused")		
		DatabaseConnection dbc = new DatabaseConnection();
		dbc.getProducts();
		new ImsGUI();
		
		MainMenu mainMenu = new MainMenu(dbc);
		
		//dbc.readEntry();
		//dbc.updateEntry();
		
		//dbc.closeConnection();
		
	}
	
}
