package bongo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	public static JFrame frame = new JFrame("BongoGame");
	public static JPanel panel = new JPanel();
	public static JLabel lblNewLabel = new JLabel("");
	public static Deck deck = new Deck();
	public static ArrayList<Cards> Dongle = deck.getDeck();
	public static ArrayList<Cards> ppdeck = new ArrayList<Cards>();
	public static ArrayList<Cards> p2deck = new ArrayList<Cards>();

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
		JButton logodeck = new JButton("Bongo");
		logodeck.setBounds(810,240,80,100);
		panel.add(logodeck);
		bonk();
		donk();
		ballong(ppdeck,p2deck);
	}
	public static ArrayList<Cards> bonk() {
		for (int i = 0; i < 8; i++) { 
		       Cards currentCard = Dongle.get(i);
		        ppdeck.add(currentCard);
		        Dongle.remove(i);
		}
		return ppdeck;
	}
	
	public static ArrayList<Cards> donk(){
		for (int i = 0; i < 8; i++) {
		       Cards currentCard = Dongle.get(i);
		        p2deck.add(currentCard);
		        Dongle.remove(i);
		}
		return p2deck;

	}
	
	public static void ballong(ArrayList<Cards> ppdeck, ArrayList<Cards> p2deck) {
		int y = 0;
		int z = 0;
		for (int i = 0; i < ppdeck.size(); i++) {
			String value = ppdeck.get(i).CardTotalValue();
			JButton Values[] = new JButton[100];
				Values[z]  = new JButton(value);
				Values[z].setBounds(y, 40, 80, 100);
				Color currentColor = ppdeck.get(i).getColor();
				Values[z].setBackground(currentColor);
				y += 90;
				panel.add(Values[z]);
				z++;
		}
		y = 0;
		z = 0;
		for (int i = 0; i < p2deck.size(); i++) {
			String value = p2deck.get(i).CardTotalValue();
			JButton Values[] = new JButton[100];
			Values[z]  = new JButton(value);
			Values[z].setBounds(y, 440, 80, 100);
			Color currentColor = p2deck.get(i).getColor();
			Values[z].setBackground(currentColor);
			
			Values[z].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gamer(Values[1]);
			}
				
			});
			y += 90;
			panel.add(Values[z]);
			z++;
		}
	}
	
	public static void gamer(JButton card) {
		Color activeColor = p2deck.get(1).getColor();
		card = new JButton(p2deck.get(1).CardTotalValue());
		card.setBounds(315,240,80,100);
		card.setBackground(activeColor);
		panel.add(card);
	}
}


