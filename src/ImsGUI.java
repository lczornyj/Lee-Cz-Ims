
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;

import javax.swing.*;



public class ImsGUI extends JFrame implements ActionListener {
	private JMenuBar menu = new JMenuBar();
	private JLabel statusLabel;
	private JFrame frame;
	
		
	public ImsGUI () {
		
		
		setLayout(new FlowLayout());
		frame = new JFrame("Inventory Management System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setJMenuBar(menu);
		createMainMenu();
		frame.setLayout(new GridLayout());
		frame.setSize(700, 600);
		frame.setVisible(true);
		
	}
	
	public void createMainMenu () {
		
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		JMenu reports = new JMenu("Reports");
		reports.setMnemonic(KeyEvent.VK_R);
		menu.add(file);
		menu.add(reports);
		// add menu options for file 
		JMenuItem addProduct = new JMenuItem("Add new product");
		JMenuItem findProduct = new JMenuItem("Search for a product");
		
		JMenu editProduct = new JMenu("Edit an existing product");
		JMenuItem editProductName = new JMenuItem("Edit product name");
		JMenuItem editProductStock = new JMenuItem("Edit product stock level");
		JMenuItem timeSimulation = new JMenuItem("Simulate sales");
		JMenuItem discontinued = new JMenuItem("Discontinue product");
		
		editProduct.add(editProductName);
		editProduct.add(editProductStock);
		file.add(addProduct);
		file.add(findProduct);
		file.add(editProduct);
		file.add(timeSimulation);
		file.add(discontinued);
		
		//add buttons
		//add(addProduct); add(findByName); add(findByID); add(editProductName); add(editProductStock); add(timeSimulation); add(discontinued);
		
		// create actionlisteners for file
		
		addProduct.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame addProductWindow = new JFrame();
				addProductWindow.setLocation(300,300);
				addProductWindow.setSize(300, 150);
				addProductWindow.setLayout(new GridLayout(3,2));
				addProductWindow.setTitle("Add new product");
				addProductWindow.add(new JLabel("Enter product name:"));
				addProductWindow.add(new JTextField());
				addProductWindow.add(new JLabel("Enter Initial stock:"));
				addProductWindow.add(new JTextField());
				
				JButton addProductButton = new JButton("Add Product");
				addProductButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int dialogButton = JOptionPane.YES_NO_OPTION;
		                JOptionPane.showConfirmDialog (null, "Do you want to add Product: ","Confirmation",dialogButton);
					}
				});
				
				addProductWindow.add(addProductButton);
				
				addProductWindow.setVisible(true);
			}
				
				// Attempt at getting confirmation before accepting the product
			
		});

	
		
		findProduct.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame addProductWindow = new JFrame();
				addProductWindow.setLocation(300,300);
				addProductWindow.setSize(450, 100);
				addProductWindow.setLayout(new GridLayout(2,2,5,5));
				addProductWindow.setTitle("Search");
				addProductWindow.add(new JLabel("Enter product name or product ID:"));
				
				addProductWindow.add(new JTextField());
				setPreferredSize( new Dimension( 200, 24 ) );
				
				JButton addProductButton = new JButton("Add Product");
				addProductButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int dialogButton = JOptionPane.YES_NO_OPTION;
		                JOptionPane.showConfirmDialog (null, "Would You Like to Save your Previous Note First?","Warning",dialogButton);
					}
				});
				
				addProductWindow.add(addProductButton);
				
				addProductWindow.setVisible(true);
				
			}
		});

		editProductName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				statusLabel = new JLabel();
				frame.add(statusLabel);
					
				statusLabel.setText("are");
				
			}
		});
		editProductStock.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				statusLabel = new JLabel();
				frame.add(statusLabel);
					
				statusLabel.setText("you");
				
			}
		});
		timeSimulation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				statusLabel = new JLabel();
				frame.add(statusLabel);
					
				statusLabel.setText("today");
				
			}
		});
		discontinued.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				statusLabel = new JLabel();
				frame.add(statusLabel);
					
				statusLabel.setText("buddy?");
				
			}
		});
		
		// add menu options for reports
		JMenuItem showStockReport = new JMenuItem("Show stock report");
		JMenuItem showPurchaseOrder = new JMenuItem("Show purchase order");
		reports.add(showStockReport);
		reports.add(showPurchaseOrder);
		
		//create actionlisteners for reports
		showStockReport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				statusLabel = new JLabel();
				frame.add(statusLabel);
					
				statusLabel.setText("true");
				
			}
		});
		showPurchaseOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				statusLabel = new JLabel();
				frame.add(statusLabel);
					
				statusLabel.setText("story");
				
			}
		});	
	}
	public void paint(Graphics g) {
		super.paint(g);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub		
	}
}
