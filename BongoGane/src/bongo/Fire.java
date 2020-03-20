package bongo;

import java.awt.Color;

//Class for fire element
public class Fire extends Elements {

	//Force is ran to check if the opposing card is grass
	public int Force(Color enemy) {
		if(enemy == Color.GREEN) {
			//Sets the message to display as an indicator to extra damage being involved
			setElementEvent("Extra Burn (+1 damage)");
			return 1;
		}else {
			setElementEvent("");
			return 0;
		}
	}
}
