package bongo;

import java.awt.Color;

public class Water extends Elements {
	public void Action() {
		System.out.println("Splash");
	}

	public int Force(Color enemy) {
		if(enemy == Color.RED) {
			setEvents("Extra Splash (+1 damage)");
			return 1;
		}else {
			setEvents("");
			return 0;
		}
	}
	
}
