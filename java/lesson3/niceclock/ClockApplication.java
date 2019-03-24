package lesson3.niceclock;

import java.awt.BorderLayout;
import java.time.LocalTime;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.Timer;

public class ClockApplication extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int hour;
	int minute;
	
	public ClockApplication(int hour, int minute) {
	this.hour = hour;
	this.minute = minute;

	initialize(hour, minute);
}


	private void initialize(int hour, int minute) {
		
		Clock clock = new Clock(hour, minute);
		Alarm alarm = new Alarm(0,0);
		ClockPanelView view = new ClockPanelView(clock, alarm);
		ButtonBarView barView = new ButtonBarView(alarm);
		add(view, BorderLayout.CENTER);
		add(barView, BorderLayout.SOUTH);
		
		
		
		Timer pulse = new Timer(60000, new TimeController(view));
	
		
		setBounds(100,100, 275, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Alarm clock");
		setVisible(true);
		
		pulse.setInitialDelay(getNumberOfSecondsLeftInMinute());
		pulse.start();
		
		waitForEnter();
	}


	private int getNumberOfSecondsLeftInMinute() {
		int topOfMinute = 60000 - (LocalTime.now().getSecond() * 1000); 
		return topOfMinute;
	}

	
	@SuppressWarnings("resource")
	private void waitForEnter() {
		new Scanner(System.in).nextLine();
		System.exit(0);
		
	}


	public static void main(String[] args) {
		new ClockApplication(0,0);

	}

}
