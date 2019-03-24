package lesson3.dobbelsteen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DobbelsteenController implements ActionListener {
	
	private Dobbelsteen dobbelsteen;
	
	public DobbelsteenController(Dobbelsteen dobbelsteen) {
		this.dobbelsteen = dobbelsteen;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		dobbelsteen.werp();

	}



}
