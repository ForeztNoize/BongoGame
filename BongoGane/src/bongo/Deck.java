package bongo;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private String[] ColorArray = {"Red","Blue","Yellow","Green"};
	private String[] WildArray = {"FourWild","ColorWild"};
	private ArrayList<Cards> deck = new ArrayList<Cards>();

	public Deck() {
		int i = 0;
		int j = 0;
		
		for (int q = 0; q < 25; q++) {
			i++;
			j = 0;
			for(int w = 0; w < 4; w++) {
				deck.add(new Cards(i,ColorArray[j],""));
				j++;
			}
		}
		Collections.shuffle(deck);
	}
	
	public ArrayList<Cards> getDeck() {
		return deck;
	}

	public String[] getColorArray() {
		return ColorArray;
	}

}


