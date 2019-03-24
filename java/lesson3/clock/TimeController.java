package lesson3.clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

public class TimeController implements ActionListener {

	private Clock clock;
	private Alarm alarm;
	private ClockPanelView clockPanelView;

	public TimeController(ClockPanelView clockPanelView) {
		this.clockPanelView = clockPanelView;
		this.clock = clockPanelView.getClock();
		this.alarm = clockPanelView.getAlarm();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() instanceof PushButton) {
			PushButton p = (PushButton) e.getSource();
			switch (p.getName()) {
			case "ClockMinus":
				clock.previousMinute();
				break;
			case "ClockPlus":
				clock.nextMinute();
				break;
			case "AlarmMinus":
				alarm.previousMinute();
				break;
			case "AlarmPlus":
				alarm.nextMinute();
				break;
			}
		}
		
		if (e.getSource() instanceof JCheckBox) {

			if (alarm.isActive()) {
				alarm.turnOff();
			} else {
				alarm.setActive();

			}
		}
		if (e.getID() == 0) {
			clock.nextMinute();
		}
		

		if (alarm.toString().equals(clock.toString()) & alarm.isActive()) {
			alarm.goOff();
		}
		
	}

}
