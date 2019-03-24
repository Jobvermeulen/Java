package lesson3.niceclock;

import java.awt.Color;

public class Alarm extends Clock {
	
	private boolean active;
	private Color color;
	
	public Alarm(int hour, int minute) {
		super(hour, minute);
		this.color = Color.BLACK;
		
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive() {
		active = true;
		setColor(Color.GREEN);
		change();
		
	}
	public void goOff() {
		setColor(Color.RED);
		change();
	}
	
	public void turnOff() {
		active = false;
		setColor(Color.BLACK);
		change();
	}
	
	private void change() {
		setChanged();
		notifyObservers();
	}
}
