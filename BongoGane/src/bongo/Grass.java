package bongo;

import java.awt.Color;

public class Grass extends Elements {
	public void Action() {
		System.out.println("Grow");
	}

	public int Force(Color enemy) {
		if(enemy == Color.YELLOW) {
			System.out.println("Extra Grow (+1 damage)");
			return 1;
		}else {
			return 0;
		}
	}
}
