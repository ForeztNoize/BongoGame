package bongo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {
	public static JFrame frame = new JFrame("BongoGame");
	public static JPanel panel = new JPanel();

	public static void main(String[] args) {
		frame.setSize(800, 1000);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(9,9));
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JOptionPane.showMessageDialog(null, "To play the game press on the coloured cards\nTo win your damage and any elemental extra damage has to be higher than the computer\nPlay until all cards are used");
		Hand.handgeneration(panel);
		frame.setVisible(true);
		
		
		

	}
	
}


