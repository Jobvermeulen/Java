package lesson3.nicedobbelsteen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorpController implements ActionListener {

	private Worp worp;
	
	public WorpController(Worp worp) {
		this.worp = worp;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		worp.werp();

	}

}
