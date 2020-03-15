package bongo;

import java.awt.BorderLayout;
import java.util.ArrayList;

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
		panel.setLayout(null);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		lblNewLabel.setBounds(30, 9, 150, 14);
		panel.add(lblNewLabel);	
		Deck deck = new Deck();
		ArrayList<Cards> Deck = deck.getDeck();
		int y = 0;
		int z = 0;
		for (int i = 0; i < Deck.size(); i++) {
			int color = Deck.get(z).getColor();
			int value = Deck.get(z).getValue();
			String colortransform = null;
			switch(color) {
			case 1:
				colortransform = "Red";
				break;
			case 2:
				colortransform = "Blue";
				break;
			case 3:
				colortransform = "Green";
				break;
			case 4:
				colortransform = "Yellow";
				break;
			default:
				break;
			}
			JLabel Values[] = new JLabel[36];
			Values[z]  = new JLabel(colortransform + value);
			Values[z].setBounds(30, y, 150, 14);
			y += 40;
			panel.add(Values[z]);
			z++;
		}
	}
}
