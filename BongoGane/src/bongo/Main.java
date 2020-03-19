package bongo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	public static JFrame frame = new JFrame("BongoGame");
	public static JPanel panel = new JPanel();
	public static JLabel lblNewLabel = new JLabel("");

	public static void main(String[] args) {
		
		panel.setBounds(0, 5, 571, 33);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setVisible(true);
		panel.setLayout(null);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		lblNewLabel.setBounds(30, 9, 150, 14);
		panel.add(lblNewLabel);
		JLabel playerlabel = new JLabel ("Your card");
		playerlabel.setBounds(300, 240, 40, 40);
		
		Hand.handgeneration(panel);
		
		
		

	}
	
}


