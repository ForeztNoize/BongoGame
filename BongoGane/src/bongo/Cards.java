package bongo;

public class Cards {
	private int value;
	private int color;
	
	public int getValue() {
		return value;
	}

	public int getColor() {
		return color;
	}

	public Cards(int value, int color) {
		this.color = color;
		this.value = value;
	}
}
