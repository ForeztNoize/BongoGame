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

	public static ArrayList<Cards> initial(ArrayList ppdeck) {
		Cards currentCard = Dongle.get(0);
		ppdeck.add(currentCard);
		Dongle.remove(0);
		return ppdeck;
	}
 
	public Hand(ArrayList<Cards> ppdeck, JPanel panel,int x, int y, int i) {
			String value = ppdeck.get(i).CardTotalValue();
			JButton card = new JButton(value);
			int id = i;
			card.setBounds(x, y, 80, 100);
			Color currentColor = ppdeck.get(i).getColor();
			card.setBackground(currentColor);
			panel.add(card);
			card.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton middle = new JButton();
					Color activeColor = Hand.getPpdeck().get(id).getColor();
					middle = new JButton(Hand.getPpdeck().get(id).CardTotalValue());
					middle.setBounds(315,240,80,100);
					middle.setBackground(activeColor);
					panel.add(middle);
					RemainingCards.setRemoved(id);
				}	
				});
	}
}
