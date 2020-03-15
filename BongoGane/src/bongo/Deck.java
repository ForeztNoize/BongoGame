package bongo;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private ArrayList<Cards> deck = new ArrayList<Cards>();

	public Deck() {
		int i = 0;
		int j = 0;
		
		for (int q = 0; q < 9; q++) {
			j = 0;
			i++;
			for(int w = 0; w < 4; w++) {
				j++;
				deck.add(new Cards(i,j));
			}
		}
		Collections.shuffle(deck);
	}
	
	public ArrayList<Cards> getDeck() {
		return deck;
	}

}
