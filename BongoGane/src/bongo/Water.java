package bongo;

import java.awt.Color;

public class Water extends Elements {
	public int Force(Color enemy) {
		if(enemy == Color.RED) {
			setElementEvent("Extra Splash (+1 damage)");
			return 1;
		}else {
			setElementEvent("");
			return 0;
		}
	}
	
}
