package bongo;

import java.awt.Color;

public class Poison extends Elements {

	public int Force(Color enemy) {
		if(enemy == Color.BLUE) {
			setElementEvent("Extra Infect (+1 damage)");
			return 1;
		}else {
			return 0;
		}
	}
}
