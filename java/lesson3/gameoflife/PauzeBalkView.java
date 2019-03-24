package lesson3.gameoflife;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PauzeBalkView extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer;
	
	public PauzeBalkView(Timer timer) {
		this.timer = timer; 
		JButton pauzeKnop = new JButton("Pauzeer");
		pauzeKnop.addActionListener(new TimerController(timer));
		add(pauzeKnop);
	}
}
