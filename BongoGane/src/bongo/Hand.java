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
		
		for (int i = 0; i < 10; i++) {
			Hand Playerhands = new Hand(Hand.getPpdeck(), panel, i);
		}
		for (int i = 0; i < 10; i++) {
			AIHand AIhands = new AIHand(panel, i);
		}

	}
 
	public Hand(ArrayList<Cards> ppdeck, JPanel panel, int i) {
			String value = Dongle.get(0).CardTotalValue();
			JButton card = new JButton(value);
			int id = i;
			Color currentColor = Dongle.get(0).getColor();
			card.setBackground(currentColor);
			ppdeck.add(Dongle.get(0));
			Dongle.remove(0);
			panel.add(card);
			hnds[id] = card;
			card.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton middle = new JButton();
					knapp.add(middle);
					middle.setVisible(false);
					Color activeColor = Hand.getPpdeck().get(id).getColor();
					middle = new JButton(Hand.getPpdeck().get(id).CardTotalValue());
					middle.setBackground(activeColor);
					panel.add(middle);
					panel.remove(knapp.get(0));
					knapp.set(0, middle);
					panel.add(knapp.get(0));
					hnds[id].setVisible(false);
					AIHand.ComputerTurn(panel, id, Hand.getPpdeck().get(id));
				}	
				});
	}
}
