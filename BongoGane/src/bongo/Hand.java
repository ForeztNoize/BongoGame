package bongo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hand {
	private static Deck deck = new Deck();
	private static ArrayList<Cards> originDeck = deck.getDeck();
	private static ArrayList<Cards> ppdeck = new ArrayList<Cards>();
	private static int handcards = 10;
	private static JButton[] hnds = new JButton[handcards];
	private static ArrayList<JButton> pushCard = new ArrayList<JButton>();
	private static int turn = 0;
	
	public static ArrayList<Cards> getOriginDeck() {
		return originDeck;
	}
	public static ArrayList<Cards> getPpdeck() {
		return ppdeck;
	}

	public static void handgeneration(JPanel panel) {
		//Iterates 9 times for 9 cards.
		for (int i = 0; i < 9; i++) {
			Hand Playerhands = new Hand(Hand.getPpdeck(), panel, i);
		}
		for (int i = 0; i < 9; i++) {
			AIHand AIhands = new AIHand(panel, i);
		}

	}
 
	//Constructor for creation of the players hand.
	public Hand(ArrayList<Cards> ppdeck, JPanel panel, int i) {
		String value = originDeck.get(0).CardTotalValue();
		//The cards should be pressable and still display som sats hence why they are made as buttons
		JButton card = new JButton(value);
		int id = i;
		Color currentColor = originDeck.get(0).getColor();
		card.setBackground(currentColor);
		ppdeck.add(originDeck.get(0));
		originDeck.remove(0);
		panel.add(card);
		hnds[id] = card;
		//ActionListener for when a card i pressed.
		card.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//A new button that is suppose to represent the card pressed is made.
				JButton middle = new JButton();
				pushCard.add(middle);
				//If there was a card in the middle already it gets hidden to make place for the new one.
				middle.setVisible(false);
				Color activeColor = Hand.getPpdeck().get(id).getColor();
				middle = new JButton(Hand.getPpdeck().get(id).CardTotalValue());
				middle.setBackground(activeColor);
				panel.add(middle);
				panel.remove(pushCard.get(0));
				pushCard.set(0, middle);
				panel.add(pushCard.get(0));
				//The card is hidden from where it was before creating the illusion that it was moved.
				hnds[id].setVisible(false);
				AIHand.ComputerTurn(panel, id, Hand.getPpdeck().get(id));
				//Make the turn number go up.
				turn++;
				//If-statement to end the game if all cards have been played.
				if(turn == 9) {
					JOptionPane.showMessageDialog(null, "Game Over");
					System.exit(0);
				}
			}	
		});
	}
}
