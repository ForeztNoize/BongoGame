package bongo;

import java.awt.Color;

//Class for grass element
public class Grass extends Elements {

	//Force is ran to check if the opposing card is poison
	public int Force(Color enemy) {
		if(enemy == Color.YELLOW) {
			//Sets the message to display as an indicator to extra damage being involved
			setElementEvent("Extra Grow (+1 damage)");
			return 1;
		}else {
			setElementEvent("");
			return 0;
		}
	}
}
