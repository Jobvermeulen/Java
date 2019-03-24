package lesson3.niceclock;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

public class ClockButtonView extends JButton implements Observer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Clock clock;
	private Color color;

	public ClockButtonView(Clock clock) {
		this.clock = clock;
		clock.addObserver(this);
		refresh();
	}
	
	public void refresh() {
		this.setText(clock.toString());
		this.setForeground(clock.getColor());
	}


	@Override
	public void update(Observable clock, Object info) {
		refresh();
		
	}
	

}
