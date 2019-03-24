package lesson3.nicedobbelsteen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.Timer;

public class TimerController implements ActionListener {
	
	private Timer pulse;
	private boolean automatic = false;
	
	public TimerController(Timer pulse) {
		this.pulse = pulse;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		JComponent source = (JComponent) event.getSource();
		
		if (source instanceof JCheckBox) {
			JCheckBox checkBox = (JCheckBox) source;
			automatic = checkBox.isSelected();
		}
		
		if (pulse.isRunning()) {
			pulse.stop();
		} else if (automatic) {
			pulse.start();
		}
	}
	
	

}
