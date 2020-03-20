package bongo;

import java.awt.Color;

public class Grass extends Elements {

	public int Force(Color enemy) {
		if(enemy == Color.YELLOW) {
			setElementEvent("Extra Grow (+1 damage)");
			return 1;
		}else {
			return 0;
		}
	}
}
