package connectFour;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetController implements ActionListener{
	
	private ConnectFourModel model;
	
	public ResetController (ConnectFourModel model) {
		this.model = model;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		model.resetGrid();
	}
	
}
