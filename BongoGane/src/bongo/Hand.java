package bongo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Hand {
	private static Deck deck = new Deck();
	private static ArrayList<Cards> Dongle = deck.getDeck();
	private static ArrayList<Cards> ppdeck = new ArrayList<Cards>();
	private static ArrayList<Cards> p2deck = new ArrayList<Cards>();
	
	public static ArrayList<Cards> getDongle() {
		return Dongle;
	}
	public static ArrayList<Cards> getPpdeck() {
		return ppdeck;
	}

	public static ArrayList<Cards> getP2deck() {
		return p2deck;
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
 
	public Hand(ArrayList<Cards> ppdeck, JPanel panel,int x, int y, int i) {
			String value = ppdeck.get(i).CardTotalValue();
			JButton card = new JButton(value);
			int id = i;
			card.setBounds(x, y, 80, 100);
			Color currentColor = ppdeck.get(i).getColor();
			card.setBackground(currentColor);
			panel.add(card);
		/*
			String value = p2deck.get(i).CardTotalValue();
			JButton Values[] = new JButton[100];
			Values[z]  = new JButton(value);
			Values[z].setBounds(y, 440, 80, 100);
			Color currentColor = p2deck.get(i).getColor();
			Values[z].setBackground(currentColor);
			
			Values[z].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton card = new JButton();
				Color activeColor = p2deck.get(1).getColor();
				card = new JButton(p2deck.get(1).CardTotalValue());
				card.setBounds(315,240,80,100);
				card.setBackground(activeColor);
				panel.add(card);
			}
				
			});
			y += 90;
			panel.add(Values[z]);
			z++;*/
	}
}
