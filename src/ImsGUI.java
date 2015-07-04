
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.*;
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
		frame.setLocation(300, 100);
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
				addProductWindow.setLocation(500,300);
				addProductWindow.setSize(300, 150);
				addProductWindow.setLayout(new GridLayout(3,2));
				addProductWindow.setTitle("Add new product");
				addProductWindow.add(new JLabel("Enter product name:"));
				addProductWindow.add(new JTextField());
				addProductWindow.add(new JLabel("Enter Initial stock:"));
				addProductWindow.add(new JTextField());
				JButton addProductButton = new JButton("Add Product");
				JButton cancelButton = new JButton("cancel");
				/* input here
				 * if (!exists)
				 * 		int dialogButton = JOptionPane.ERROR_MESSAGE;
		                JOptionPane.showConfirmDialog (null, "Do you want to add Product: ","Confirmation",dialogButton);
		                
				 */
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						addProductWindow.dispose();
					}	
				});
				addProductButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int dialogButton = JOptionPane.showConfirmDialog (null, "Do you want to add Product: ","Confirmation",JOptionPane.YES_NO_OPTION);
		               if (dialogButton == JOptionPane.YES_OPTION){
		            	   	addProductWindow.dispose();		                	
		                } 
					}	
				});
				addProductWindow.add(addProductButton);
				addProductWindow.add(cancelButton);
				addProductWindow.setVisible(true);
				}
		});
		
		findProduct.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame findProductWindow = new JFrame();
				findProductWindow.setLocation(500,300);
				findProductWindow.setSize(300, 150);
				findProductWindow.setLayout(new GridLayout(3,2,5,5));
				findProductWindow.setTitle("Search");
				findProductWindow.add(new JLabel("Enter product name: "));
				findProductWindow.add(new JTextField());
				findProductWindow.add(new JLabel("Enter product ID: "));
				findProductWindow.add(new JTextField());

				setPreferredSize( new Dimension( 200, 24 ) );
				JButton findProductButton = new JButton("Find product");
				JButton cancelButton = new JButton("Cancel");
				
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						findProductWindow.dispose();
					}	
				});
	
				findProductButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int dialogButton = JOptionPane.showConfirmDialog (null, "Product: ","Confirmation",JOptionPane.YES_NO_OPTION);
		                if (dialogButton == JOptionPane.YES_OPTION){
		                	findProductWindow.dispose();
		                }
		                //if()
					}
				});
				
				findProductWindow.add(findProductButton);
				findProductWindow.add(cancelButton);
				findProductWindow.setVisible(true);
				
			}
		});

		editProductName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame editNameWindow = new JFrame();
				
				editNameWindow.setLocation(500,300);
				editNameWindow.setSize(375, 150);
				editNameWindow.setLayout(new GridLayout(3,2,5,5));
				editNameWindow.setTitle("Enter product you wish to change");
				editNameWindow.add(new JLabel("           Enter product name: "));
				editNameWindow.add(new JTextField());
				editNameWindow.add(new JLabel("              Enter product ID: "));
				editNameWindow.add(new JTextField());
				setPreferredSize( new Dimension( 200, 24 ) );
				
				JButton editProductButton = new JButton("Edit product");
				JButton cancelButton = new JButton("Cancel");
				
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						editNameWindow.dispose();
					}	
				});
	
				editProductButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int dialogButton = JOptionPane.showConfirmDialog (null, "Product: ","Confirmation",JOptionPane.YES_NO_OPTION);
		                if (dialogButton == JOptionPane.YES_OPTION){
		                	editNameWindow.dispose();
		                	
		                	JFrame newNameWindow = new JFrame();
		                	newNameWindow.setTitle("Edit Product");
		                	newNameWindow.setLayout(new GridLayout (2,2));
		                	newNameWindow.add(new JLabel(" Enter new name: "));
		                	newNameWindow.add(new JTextField());
		                	newNameWindow.add(new JPanel());
		                	newNameWindow.setLocation(500,300);
		    				newNameWindow.setSize(300, 100);
		    				newNameWindow.setVisible(true);
		    			
		    				JButton confirmEditButton = new JButton("Confirm");
		    				
		    				confirmEditButton.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									int dialogButton = JOptionPane.showConfirmDialog (null, "Is this the name? ","Confirmation",JOptionPane.YES_NO_OPTION);
						               if (dialogButton == JOptionPane.YES_OPTION){
						            	   	newNameWindow.dispose();		                	
						                }
								}
							});
		    				newNameWindow.add(confirmEditButton);
		    				newNameWindow.setVisible(true);
		                }
					}
				});
				
				editNameWindow.add(editProductButton);
				editNameWindow.add(cancelButton);
				editNameWindow.setVisible(true);
			
				
			}
		});
		editProductStock.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame editStockWindow = new JFrame();
				editStockWindow.setLocation(500,300);
				editStockWindow.setSize(300, 150);
				editStockWindow.setLayout(new GridLayout(3,2,5,5));
				editStockWindow.setTitle("Search");
				editStockWindow.add(new JLabel("Enter product name: "));
				editStockWindow.add(new JTextField());
				editStockWindow.add(new JLabel("Enter product ID: "));
				editStockWindow.add(new JTextField());
				setPreferredSize( new Dimension( 200, 24 ) );
				
				JButton editStockButton = new JButton("Find product");
				JButton cancelButton = new JButton("Cancel");
	
				
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						editStockWindow.dispose();
					}	
				});
	
				editStockButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int dialogButton = JOptionPane.showConfirmDialog (null, "Is this the name? ","Confirmation",JOptionPane.YES_NO_OPTION);if (dialogButton == JOptionPane.YES_OPTION){
		                	editStockWindow.dispose();
		        
		                	JFrame newNameWindow = new JFrame();
		                	newNameWindow.setTitle("Edit Product");
		                	newNameWindow.setLayout(new GridLayout (2,2));
		                	newNameWindow.add(new JLabel(" Enter new stock ammount: "));
		                	newNameWindow.add(new JTextField());
		                	newNameWindow.add(new JPanel());
		                	newNameWindow.setLocation(500,300);
		    				newNameWindow.setSize(300, 100);
		    				newNameWindow.setVisible(true);
		    			
		    				JButton confirmEditButton = new JButton("Confirm");
		    				
		    				confirmEditButton.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									int dialogButton = JOptionPane.showConfirmDialog (null, "Is this the name? ","Confirmation",JOptionPane.YES_NO_OPTION);
						               if (dialogButton == JOptionPane.YES_OPTION){
						            	   	newNameWindow.dispose();		                	
						                }
								}
							});
		    				newNameWindow.add(confirmEditButton);
		    				newNameWindow.setVisible(true);
		                }
					}
				});
				
				editStockWindow.add(cancelButton);
				editStockWindow.add(editStockButton);
				editStockWindow.setVisible(true);
			
			}
		});
		timeSimulation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		discontinued.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFrame discontinuedWindow = new JFrame();
				discontinuedWindow.setLocation(500,300);
				discontinuedWindow.setSize(300, 150);
				discontinuedWindow.setLayout(new GridLayout(3,2,5,5));
				discontinuedWindow.setTitle("Search");
				discontinuedWindow.add(new JLabel("Enter product name: "));
				discontinuedWindow.add(new JTextField());
				discontinuedWindow.add(new JLabel("Enter product ID: "));
				discontinuedWindow.add(new JTextField());
				setPreferredSize( new Dimension( 200, 24 ) );
				
				JButton addProductButton = new JButton("Find product");
				addProductButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int dialogButton = JOptionPane.YES_NO_OPTION;
		                JOptionPane.showConfirmDialog (null, "Is this the product you were looking for?","Search",dialogButton);
		                if (dialogButton == JOptionPane.YES_OPTION){
		                	discontinuedWindow.dispose();
		                }
		                //if()
					}
				});
				
				discontinuedWindow.add(addProductButton);
				
				discontinuedWindow.setVisible(true);
				
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
