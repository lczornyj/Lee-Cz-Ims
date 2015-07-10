
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;
import java.io.File;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class ImsGUI extends JFrame implements ActionListener {
	private JMenuBar menu = new JMenuBar();
	private JLabel statusLabel;
	private static JFrame frame;
	static JTextField textField_productName = new JTextField();
	static JTextField textField_productStock = new JTextField();
	static JTextField textField_findProductByName = new JTextField();
	static JTextField textField_findProductById = new JTextField();
	private static DefaultTableModel tableModel;
	static String [] columnNames = {"Product ID","Product Name","Stock Level" };
	static String[][] table = new String[0][3];
	
	
	public ImsGUI () {
		
		
		setLayout(new FlowLayout());
		frame = new JFrame("Inventory Management System");
		
		
		
		
		
		refreshTable();	
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setJMenuBar(menu);
		createMainMenu();
		frame.setLayout(new GridLayout());
		frame.setSize(700, 400);
		frame.setLocation(300, 100);
		frame.setVisible(true);
		
	}
	
	public static void refreshTable(){
		tableModel = new DefaultTableModel(table, columnNames);
		JTable table1 = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table1);
		
		Container tempContainer = frame.getContentPane();
		tempContainer.removeAll();
		tempContainer.add(scrollPane,BorderLayout.CENTER);
		frame.setContentPane(tempContainer);
		DatabaseConnection dbc = new DatabaseConnection();
		dbc.readEntry();
		MainMenu menu = new MainMenu(dbc);
		//menu.fileWritingMethod();
		//tableModel = new DefaultTableModel(table, columnNames);
		for(Product product : DatabaseConnection.getProducts())
		 {
			tableModel.addRow(product.ObjectArray()); 
		 }

		frame.setVisible(true);
	}
	
	public void createMainMenu () {
		
		JMenu menufile = new JMenu("File");
		menufile.setMnemonic(KeyEvent.VK_F);
		JMenu reports = new JMenu("Reports");
		reports.setMnemonic(KeyEvent.VK_R);
		menu.add(menufile);
		menu.add(reports);
		// add menu options for file 
		JMenuItem addProduct = new JMenuItem("Add new product");
		JMenuItem findProduct = new JMenuItem("Search for a product");
		
		JMenu editProduct = new JMenu("Edit an existing product");
		JMenuItem editProductName = new JMenuItem("Edit product name");
		JMenuItem editProductStock = new JMenuItem("Edit product stock level");
		JMenuItem timeSimulation = new JMenuItem("Simulate sales");
		
		editProduct.add(editProductName);
		editProduct.add(editProductStock);
		menufile.add(addProduct);
		menufile.add(findProduct);
		menufile.add(editProduct);
		menufile.add(timeSimulation);
		
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
				addProductWindow.setLayout(new GridLayout(3,2, 5, 5));
				addProductWindow.setTitle("Add new product");
				addProductWindow.add(new JLabel("Enter product name:"));
				addProductWindow.add(textField_productName);				
				textField_productName.getText();
				addProductWindow.add(new JLabel("Enter Initial stock:"));
				addProductWindow.add(textField_productStock);
				textField_productStock.getText();
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
						int dialogButton = JOptionPane.showConfirmDialog (null, "Do you want to add Product: " + textField_productName.getText(),"Confirmation",JOptionPane.YES_NO_OPTION);
		               if (dialogButton == JOptionPane.YES_OPTION){
		            	   	AddProduct ap = new AddProduct();
		            	   	ArrayList<Product> alp = new ArrayList<Product>();
		            	   	
		            	   	alp.add(new Product(DatabaseConnection.getProducts().size(),textField_productName.getText(),Integer.parseInt(textField_productStock.getText())));
		            	   	
		            	   	ap.addProduct(alp);
		            	   	refreshTable();
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
				findProductWindow.add(textField_findProductByName);				
				textField_findProductByName.getText();
				findProductWindow.add(new JLabel("Enter product ID: "));
				findProductWindow.add(textField_findProductById);				
				textField_findProductById.getText();

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
						
						
						
						int dialogButton = JOptionPane.showConfirmDialog (null, "Is this the product?" , "Confirmation",JOptionPane.YES_NO_OPTION);
		                if (dialogButton == JOptionPane.YES_OPTION){
		                	
		                	findProductWindow.dispose();
		                }
		                
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
									int dialogButton = JOptionPane.showConfirmDialog (null, "Is this the product? ","Confirmation",JOptionPane.YES_NO_OPTION);
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
						int dialogButton = JOptionPane.showConfirmDialog (null, "Is this the product? ","Confirmation",JOptionPane.YES_NO_OPTION);
						if (dialogButton == JOptionPane.YES_OPTION){
		                	editStockWindow.dispose();
		        
		                	JFrame newStockWindow = new JFrame();
		                	newStockWindow.setTitle("Edit Product");
		                	newStockWindow.setLayout(new GridLayout (2,2));
		                	newStockWindow.add(new JLabel(" Enter new stock ammount: "));
		                	newStockWindow.add(new JTextField());
		                	newStockWindow.add(new JPanel());
		                	newStockWindow.setLocation(500,300);
		    				newStockWindow.setSize(300, 100);
		    				newStockWindow.setVisible(true);
		    			
		    				JButton confirmEditButton = new JButton("Confirm");
		    				
		    				confirmEditButton.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									int dialogButton = JOptionPane.showConfirmDialog (null, "New stock amount: ","Confirmation",JOptionPane.PLAIN_MESSAGE);
						               if (dialogButton == JOptionPane.YES_OPTION){
						            	   	newStockWindow.dispose();		                	
						                }
								}
							});
		    				newStockWindow.add(confirmEditButton);
		    				newStockWindow.setVisible(true);
		                }
					}
				});
				
				editStockWindow.add(editStockButton);
				editStockWindow.add(cancelButton);
				editStockWindow.setVisible(true);
			
			}
		});
		timeSimulation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.showConfirmDialog (null, "Do you want to run simulation? ","Confirmation",JOptionPane.YES_NO_OPTION);
	               if (dialogButton == JOptionPane.YES_OPTION){
	            	  /* DatabaseConnection dbc = new DatabaseConnection();
	            	   MainMenu menu = new MainMenu(dbc);
	            	   menu.calculations(numberGenerator);*/
	                }
				
				
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
				try
				{
				File localfile = new File("\\desktop\\Stock_Report.txt");
				DatabaseConnection dbc = new DatabaseConnection();
				MainMenu menu = new MainMenu(dbc);
				dbc.readEntry();
				menu.fileWritingMethod();
				menu.open(localfile);
				}
				catch (Exception ea)
				{
					ea.printStackTrace();
				}
				
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
/**
asd
asd
asd
asd
asd
a
sda
asd
asd
*/