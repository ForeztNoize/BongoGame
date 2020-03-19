package bongo;

import java.awt.Color;

public class Cards {
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
	

	public Cards(int value, Color color, String CardTotalValue) {
		this.color = color;
		this.value = value;
		this.CardTotalValue = CardTotalValue;
		
		
		switch (value) {
		case 1, 2:
			this.CardTotalValue = "1";
			break;
		case 3, 4:
			this.CardTotalValue = "2";
			break;
		case 5, 6:
			this.CardTotalValue = "3";
			break;
		case 7, 8:
			this.CardTotalValue = "4";
			break;
		case 9, 10:
			this.CardTotalValue = "5";
			break;
		case 11, 12:
			this.CardTotalValue = "6";
			break;
		case 13, 14:
			this.CardTotalValue = "7";
			break;
		case 15, 16:
			this.CardTotalValue = "8";
			break;
		case 17, 18:
			this.CardTotalValue = "9";
			break;
		case 19, 20:
			this.CardTotalValue = "10";
			break;
			default:
				break;
	}
		
	}
}
	

