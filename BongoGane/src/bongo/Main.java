package bongo;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
		int x = 0;
		for (int i = 0; i < Deck.size(); i++) {
			String value = Deck.get(x).CardTotalValue();
			String Colors[] = deck.getColorArray();
			JLabel Values[] = new JLabel[100];
			for (int l = 0; l <= 3; l++) {
				Values[z]  = new JLabel(Colors[z] + value);
				Values[z].setBounds(30, y, 150, 14);
				y += 40;
				panel.add(Values[z]);
				z++;
			}
			x++;
			z = 0;
		}
		int partitionSize = 1000;
		List<List<Cards>> Deck2 = new LinkedList<List<Cards>>();
		for (int i = 0; i < Deck.size(); i += partitionSize) {
		    Deck2.add(Deck.subList(i,
		            Math.min(i + partitionSize, Deck.size())));
		}
		System.out.println(Deck2);
	}
	}


