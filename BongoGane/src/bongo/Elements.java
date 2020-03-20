package bongo;

import java.awt.Color;

public abstract class Elements {
	
	private String ElementEvent;
	
	public String getElementEvent() {
		return ElementEvent;
	}

	public void setElementEvent(String elementEvent) {
		ElementEvent = elementEvent;
	}

	public abstract int Force(Color enemy);
}


