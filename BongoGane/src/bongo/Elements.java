package bongo;

import java.awt.Color;

public abstract class Elements {
	
	private static String ElementEvent = "";
	
	public static String getElementEvent() {
		return ElementEvent;
	}

	public void setElementEvent(String elementEvent) {
		Elements.ElementEvent = elementEvent;
	}

	public abstract int Force(Color enemy);
}


