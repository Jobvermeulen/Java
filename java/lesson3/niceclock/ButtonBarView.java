package lesson3.niceclock;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonBarView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Alarm alarm;
	public ButtonBarView(Alarm alarm) {
		
		this.alarm = alarm;
		
		JLabel jLabel = new JLabel("Aan/uit");
		JButton start = new JButton("Start");
		start.setName("start");
		start.addActionListener(new AlarmController(this));;
		JButton stop = new JButton("Stop");
		stop.setName("stop");
		stop.addActionListener(new AlarmController(this));
		
		add(jLabel);
		add(start);
		add(stop);
		
	}
	
	public Alarm getAlarm() {
		return this.alarm;
	}
	 

}
