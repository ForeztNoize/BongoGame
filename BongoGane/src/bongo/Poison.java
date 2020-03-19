package bongo;

import java.awt.Color;

public class Poison extends Elements {
	public void Action() {
		System.out.println("Infect");
	}

	public int Force(Color enemy) {
		if(enemy == Color.BLUE) {
			setEvents("Extra Infect (+1 damage)");
			return 1;
		}else {
			setEvents("");
			return 0;
		}
	}
}
