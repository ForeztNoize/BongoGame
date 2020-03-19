package bongo;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RemainingCards {
	private static int removed = 0;
	
	public static int getRemoved() {
		return removed;
	}

	public static void setRemoved(int removed) {
		RemainingCards.removed = removed;
	}

	public static ArrayList<Cards> pull(ArrayList<Cards> ppdeck, JPanel panel) {
		System.out.println("Starts");
		int removedresult = 0;
		switch(removed) {
		case 0:
			removedresult = 0;
			System.out.println("Första bort");
			break;
		case 1:
			System.out.println("andra bort");
			removedresult = 90;
			break;
		case 2:
			removedresult = 180;
			break;
		case 3:
			removedresult = 270;
			break;
		case 4: 
			removedresult = 360;
			break;
		case 5:
			removedresult = 450;
			break;
		case 6:
			removedresult = 540;
			break;
		case 7:
			removedresult = 630;
			break;
		case 8:
			removedresult = 720;
			break;
			default:
				break;
		}
		ppdeck.remove(removed);
		Cards currentCard = Hand.getDongle().get(0);
		ppdeck.add(currentCard);
		String value = Hand.getDongle().get(0).CardTotalValue();
		JButton newCard = new JButton(value);
		newCard.setBounds(removedresult, 440, 80, 100);
		Color currentColor = Hand.getDongle().get(0).getColor();
		newCard.setBackground(currentColor);
		Hand.getDongle().remove(0);
		panel.add(newCard);
		return ppdeck;
	}
}
