package bongo;

import java.awt.Color;

public class Elements {
	
	private static String events;
	
	public int Force(Color enemy) {
		return 0;
	}
	public void Action() {
		System.out.println("Elemental Attack");
	}
	public static String getEvents() {
		return events;
	}
	public void setEvents(String events) {
		Elements.events = events;
	}
}


