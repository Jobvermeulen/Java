package lesson3.niceclock;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class ClockPanelView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Clock clock;
	private Alarm alarm;
	public ClockPanelView(Clock clock, Alarm alarm) {
		this.clock = clock;
		this.alarm = alarm;
		
		PushButton clockMinusButton = new PushButton("-");
		clockMinusButton.setName("ClockMinus");
		clockMinusButton.addActionListener(new TimeController(this));
		
		PushButton clockPlusButton = new PushButton("+");
		clockPlusButton.setName("ClockPlus");
		clockPlusButton.addActionListener(new TimeController(this));
		
		PushButton alarmMinusButton = new PushButton("-");
		alarmMinusButton.setName("AlarmMinus");
		alarmMinusButton.addActionListener(new TimeController(this));
		
		PushButton alarmPlusButton = new PushButton("+");
		alarmPlusButton.setName("AlarmPlus");
		alarmPlusButton.addActionListener(new TimeController(this));	
		
		this.setLayout(new GridLayout(2,3));
		add(new ClockButtonView(clock));
		add(clockMinusButton);
		add(clockPlusButton);
		add(new ClockButtonView(alarm));
		add(alarmMinusButton);
		add(alarmPlusButton);

	}
	public Clock getClock() {
		return clock;
	}
	public Alarm getAlarm() {
		return alarm;
	}

	
	

}
