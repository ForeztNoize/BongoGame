package bongo;

import java.awt.Color;

public class Card {
	private int value;
	private Color color;
	private String CardTotalValue;
	
	public int getValue() {
		return value;
	}

	public Color getColor() {
		return color;
	}
	
	public String CardTotalValue() {
		return CardTotalValue;
	}
	
	//Constructor for the cards.
	public Card(int value, Color color, String CardTotalValue) {
		this.color = color;
		this.value = value;
		this.CardTotalValue = CardTotalValue;
		
		//The cards get their values in string format to make sure there are no problems displaying them on the buttons.
		switch (value) {
		case 1:
			this.CardTotalValue = "1";
			break;
		case 2:
			this.CardTotalValue = "2";
			break;
		case 3:
			this.CardTotalValue = "3";
			break;
		case 4:
			this.CardTotalValue = "4";
			break;
		case 5:
			this.CardTotalValue = "5";
			break;
		case 6:
			this.CardTotalValue = "6";
			break;
		case 7:
			this.CardTotalValue = "7";
			break;
		case 8:
			this.CardTotalValue = "8";
			break;
		case 9:
			this.CardTotalValue = "9";
			break;
		case 10:
			this.CardTotalValue = "10";
			break;
			default:
				break;
	}
		
	}
}
	

