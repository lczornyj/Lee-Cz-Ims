
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



public class ImsGUI extends JFrame implements ActionListener {
	

	private JMenuBar menu = new JMenuBar();
	
	public ImsGUI () {
		
		
		setLayout(new FlowLayout());
		JFrame frame = new JFrame("Inventory Management System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setJMenuBar(menu);
		createMainMenu();
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
	public void createMainMenu () {
		
		JMenu file = new JMenu("File");
		JMenu reports = new JMenu("Reports");
		menu.add(file);
		menu.add(reports);
		// add menu options for file 
		JMenuItem addProduct = new JMenuItem("Add new product");
		JMenu findProduct = new JMenu("Search for a product");
		JMenuItem findByName = new JMenuItem("By product name");
		JMenuItem findByID = new JMenuItem("By product ID number");
		JMenu editProduct = new JMenu("Edit an existing product");
		JMenuItem editProductName = new JMenuItem("Edit product name");
		JMenuItem editProductStock = new JMenuItem("Edit product stock level");
		JMenuItem timeSimulation = new JMenuItem("Simulate sales");
		findProduct.add(findByName);
		findProduct.add(findByID);
		editProduct.add(editProductName);
		editProduct.add(editProductStock);
		file.add(addProduct);
		file.add(findProduct);
		file.add(editProduct);
		file.add(timeSimulation);
		// add menu options for reports
		JMenuItem showStockReport = new JMenuItem("Show stock report");
		JMenuItem showPurchaseOrder = new JMenuItem("Show purchase order");
		reports.add(showStockReport);
		reports.add(showPurchaseOrder);
		
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);

		
		
		
	}
		
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
