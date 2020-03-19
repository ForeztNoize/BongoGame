package bongo;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RemainingCards {
	private static int removed = 0;
	private static int i = 8;
	
	public static int getRemoved() {
		return removed;
	}

	public static void setRemoved(int removed) {
		RemainingCards.removed = removed;
	}

	public static void pull(ArrayList<Cards> ppdeck, JPanel panel) {
		int removedresult = 0;
		int id = 0;
		switch(removed) {
		case 0:
			id = 0;
			removedresult = 0;
			break;
		case 1:
			id = 1;
			removedresult = 90;
			break;
		case 2:
			id = 2;
			removedresult = 180;
			break;
		case 3:
			id = 3;
			removedresult = 270;
			break;
		case 4: 
			id = 4;
			removedresult = 360;
			break;
		case 5:
			id = 5;
			removedresult = 450;
			break;
		case 6:
			id = 6;
			removedresult = 540;
			break;
		case 7:
			id = 7;
			removedresult = 630;
			break;
		case 8:
			id = 8;
			removedresult = 720;
			break;
		case 9:
			id = 9;
			removedresult = 810;
			break;
		case 10:
			id = 10;
			removedresult = 900;
			break;
			default:
				break;
		}
		Hand newHand = new Hand(Hand.getPpdeck(), panel, removedresult, 440, id);
		/*ppdeck.remove(removed);
		Cards currentCard = Hand.getDongle().get(0);
		ppdeck.add(currentCard);
		String value = Hand.getDongle().get(0).CardTotalValue();
		JButton newCard = new JButton(value);
		newCard.setBounds(removedresult, 440, 80, 100);
		Color currentColor = Hand.getDongle().get(0).getColor();
		newCard.setBackground(currentColor);
		Hand.getDongle().remove(0);
		panel.add(newCard);
		return ppdeck;*/
	}
}
