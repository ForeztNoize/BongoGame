package bongo;

import java.awt.Color;

public class Fire extends Elements {

	public int Force(Color enemy) {
		if(enemy == Color.GREEN) {
			System.out.println("Extra Burn (+1 damage)");
			return 1;
		}else {
			return 0;
		}
	}
}
