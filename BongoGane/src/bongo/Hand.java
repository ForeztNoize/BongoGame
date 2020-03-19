package bongo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Hand {
	private static Deck deck = new Deck();
	private static ArrayList<Cards> Dongle = deck.getDeck();
	private static ArrayList<Cards> ppdeck = new ArrayList<Cards>();
	private static ArrayList<Cards> p2deck = new ArrayList<Cards>();
	private static int handcards = 8;
	private static JButton[] hnds = new JButton[handcards];
	private static ArrayList<JButton> knapp = new ArrayList<JButton>();
	
	public static ArrayList<Cards> getDongle() {
		return Dongle;
	}
	public static ArrayList<Cards> getPpdeck() {
		return ppdeck;
	}

	public static ArrayList<Cards> getP2deck() {
		return p2deck;
	}

	public static ArrayList<Cards> initial(ArrayList deck) {
		Cards currentCard = Dongle.get(0);
		deck.add(currentCard);
		Dongle.remove(0);
		return deck;
	}
	
	public static void handgeneration(JPanel panel) {
		for (int i = 0; i < 8; i++) { 
			Hand.initial(Hand.getPpdeck());
		}
		for (int i = 0; i < 8; i++) { 
			Hand.initial(Hand.getP2deck());
		}
		
		int x = 0;
		int y = 0;
		for (int i = 0; i < Hand.getP2deck().size(); i++) {
			y = 40;
			Hand AIhands = new Hand(Hand.getP2deck(), panel, x, y, i);
			x += 90;
		}
		int x2 = 0;
		for (int i = 0; i < hnds.length; i++) {
			y = 440;
			Hand Playerhands = new Hand(Hand.getPpdeck(), panel, x2, y, i);
			x2 += 90;
		}
	}

 
	public Hand(ArrayList<Cards> ppdeck, JPanel panel,int x, int y, int i) {
			String value = ppdeck.get(i).CardTotalValue();
			JButton card = new JButton(value);
			int id = i;
			card.setBounds(x, y, 80, 100);
			Color currentColor = ppdeck.get(i).getColor();
			card.setBackground(currentColor);
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
					middle.setBounds(315,240,80,100);
					middle.setBackground(activeColor);
					panel.remove(knapp.get(0));
					knapp.set(0, middle);
					panel.add(knapp.get(0));
					RemainingCards.setRemoved(id);
					hnds[id].setVisible(false);
				}	
				});
	}
}
