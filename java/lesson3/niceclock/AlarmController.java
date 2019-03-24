package lesson3.niceclock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AlarmController implements ActionListener {
	
	private Alarm alarm;
	private ButtonBarView barView;
	
	public AlarmController(ButtonBarView barView) {
		this.barView = barView;
		this.alarm = barView.getAlarm();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton button = (JButton) event.getSource();
		switch (button.getName()) {
		case "start": alarm.setActive(); break;
		case "stop": alarm.turnOff(); break;
		}

	}

}
