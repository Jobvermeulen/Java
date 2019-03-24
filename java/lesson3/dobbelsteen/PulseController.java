package lesson3.dobbelsteen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PulseController implements ActionListener {
	
	private Worp worp;
	public PulseController(Worp worp) {
		this.worp = worp;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		worp.werp();

	}

}
