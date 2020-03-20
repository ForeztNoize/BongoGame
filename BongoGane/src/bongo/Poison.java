package bongo;

import java.awt.Color;

//Class for poison element
public class Poison extends Elements {

	//Force is ran to check if the opposing card is water
	public int Force(Color enemy) {
		if(enemy == Color.BLUE) {
			//Sets the message to display as an indicator to extra damage being involved
			setElementEvent("Extra Infect (+1 damage)");
			return 1;
		}else {
			setElementEvent("");
			return 0;
		}
	}
}
