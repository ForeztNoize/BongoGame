package bongo;

import java.awt.Color;

//Class for water element
public class Water extends Elements {
	
	//Force is ran to check if the opposing card is fire
	public int Force(Color enemy) {
		if(enemy == Color.RED) {
			//Sets the message to display as an indicator to extra damage being involved
			setElementEvent("Extra Splash (+1 damage)");
			return 1;
		}else {
			setElementEvent("");
			return 0;
		}
	}
	
}
