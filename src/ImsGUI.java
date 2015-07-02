import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class ImsGUI extends JFrame implements ActionListener {
	
	
	
	public ImsGUI () {
		setTitle("Inventory Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setVisible(true);
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		
		
	}
		
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
