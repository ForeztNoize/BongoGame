package bongo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private Color[] ColorArray = {Color.RED,Color.BLUE,Color.YELLOW,Color.GREEN};
	private ArrayList<Cards> deck = new ArrayList<Cards>();

	//Constructor for the deck that the cards are initially put into
	public Deck() {
		int i = 0;
		int j = 0;
		
		for (int q = 0; q < 20; q++) {
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

	public Color[] getColorArray() {
		return ColorArray;
	}

}


