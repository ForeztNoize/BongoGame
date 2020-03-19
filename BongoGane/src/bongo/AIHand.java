package bongo;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AIHand {
	
	private static ArrayList<Cards> p2deck = new ArrayList<Cards>();
	private static ArrayList<JButton> kno = new ArrayList<JButton>();
	private static int aicards = 10;
	private static JButton[] crds = new JButton[aicards];
	
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
		p2deck.add(Hand.getDongle().get(0));
		Hand.getDongle().remove(0);
		panel.add(card);
		crds[id] = card;
	}

	public static void ComputerTurn(JPanel panel, int id) {
		JButton computerChoice = new JButton();
		kno.add(computerChoice);
		computerChoice.setVisible(false);
		Color activeColor = getP2deck().get(id).getColor();
		computerChoice = new JButton(getP2deck().get(id).CardTotalValue());
		computerChoice.setBounds(415,240,80,100);
		computerChoice.setBackground(activeColor);
		panel.add(computerChoice);
		panel.remove(kno.get(0));
		kno.set(0, computerChoice);
		crds[id].setVisible(false);
		panel.add(kno.get(0));
	}
}

