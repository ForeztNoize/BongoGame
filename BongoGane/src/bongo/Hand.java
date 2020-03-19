package bongo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Hand {
	private static Deck deck = new Deck();
	private static ArrayList<Cards> Dongle = deck.getDeck();
	private static ArrayList<Cards> ppdeck = new ArrayList<Cards>();
	private static int handcards = 10;
	private static JButton[] hnds = new JButton[handcards];
	private static ArrayList<JButton> knapp = new ArrayList<JButton>();
	
	public static ArrayList<Cards> getDongle() {
		return Dongle;
	}
	public static ArrayList<Cards> getPpdeck() {
		return ppdeck;
	}

	public static void handgeneration(JPanel panel) {
		
		int x = 0;
		int y = 0;
		for (int i = 0; i < 10; i++) {
			y = 40;
			AIHand AIhands = new AIHand(panel, x, y, i);
			x += 90;
		}
		int x2 = 0;
		for (int i = 0; i < 10; i++) {
			y = 440;
			Hand Playerhands = new Hand(Hand.getPpdeck(), panel, x2, y, i);
			x2 += 90;
		}
	}
 
	public Hand(ArrayList<Cards> ppdeck, JPanel panel,int x, int y, int i) {
			String value = Dongle.get(0).CardTotalValue();
			JButton card = new JButton(value);
			int id = i;
			card.setBounds(x, y, 80, 100);
			Color currentColor = Dongle.get(0).getColor();
			card.setBackground(currentColor);
			ppdeck.add(Dongle.get(0));
			Dongle.remove(0);
			panel.add(card);
			hnds[id] = card;
			card.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton middle = hnds[id];
					middle.setBounds(315,240,80,100);
					knapp.add(middle);
					knapp.set(0, middle);
					panel.add(knapp.get(0));
					panel.add(middle);
					RemainingCards.setRemoved(id);
					panel.remove(hnds[id]);
					hnds[id].setVisible(false);
					middle.setVisible(true);
					ppdeck.remove(id);
					/*
					middle.setVisible(false);
					Color activeColor = ppdeck.get(id).getColor();
					middle = new JButton(ppdeck.get(id).CardTotalValue());
					middle.setBounds(315,240,80,100);
					middle.setBackground(activeColor);
					panel.remove(knapp.get(0));*/
					
				}	
				});
	}
}
