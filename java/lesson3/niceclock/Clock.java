package lesson3.niceclock;

import java.awt.Color;
import java.util.Observable;

public class Clock extends Observable {

	private int hour;
	private int minute;
	private Color color;

	public Clock(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
		color = Color.BLACK;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void nextMinute() {

		++minute;

		if (minute > 59) {
			minute = 0;
			nextHour();
		}

		setChanged();
		notifyObservers();
	}

	private void nextHour() {

		++hour;

		if (hour > 23) {
			hour = 0;
		}
	}

	public void previousMinute() {
		--minute;
		if (minute < 0) {
			minute = 59;
			previousHour();
		}
		setChanged();
		notifyObservers();
	}

	private void previousHour() {
		--hour;
		if (hour < 0) {
			hour = 23;

		}
	}

	@Override
	public String toString() {
		return String.format("%02d : %02d", this.hour, this.minute);
	}
}
