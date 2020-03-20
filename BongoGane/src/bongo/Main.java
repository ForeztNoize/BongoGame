package bongo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	public static JFrame frame = new JFrame("BongoGame");
	public static JPanel panel = new JPanel();

	public static void main(String[] args) {
		frame.setSize(800, 1000);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		panel.setLayout(new GridLayout(9,9));
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*JLabel playerlabel = new JLabel ("Your card: ");
		playerlabel.setBounds(320, 200, 140, 40);
		panel.add(playerlabel);
		
		JLabel computerlabel = new JLabel ("Ai card: ");
		computerlabel.setBounds(420, 200, 140, 40);
		panel.add(computerlabel);*/
		
		Hand.handgeneration(panel);
		frame.setVisible(true);
		
		
		

	}
	
}


