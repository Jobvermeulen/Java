import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.Timer;

public class TimerController implements ActionListener{
	private Timer timer;
	private boolean automatic = false;

	public TimerController(Timer timer) {
		this.timer = timer;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JComponent source = (JComponent) event.getSource();
		if (source instanceof JButton) {
			pauzeer();
		}
	}

	private void pauzeer() {
		if (timer.isRunning()) {
			timer.stop();
		} else {
			timer.start();
		}
		
	}
}
