package bongo;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AIHand {
	
	private static ArrayList<Cards> p2deck = new ArrayList<Cards>();
	public static ArrayList<Cards> getP2deck() {
		return p2deck;
	}
	
	public AIHand(JPanel panel,int x, int y, int i) {
		String value = Hand.getDongle().get(0).CardTotalValue();
		JButton card = new JButton(value);
		int id = i;
		card.setBounds(x, y, 80, 100);
		Color currentColor = Hand.getDongle().get(0).getColor();
		card.setBackground(currentColor);
		Hand.getDongle().remove(0);
		panel.add(card);
	}
}

