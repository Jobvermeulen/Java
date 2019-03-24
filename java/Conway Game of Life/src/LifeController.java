import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LifeController implements ActionListener{
	private LifeModel model;
	
	public LifeController(LifeModel model) {
		this.model = model;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		model.nextGeneration();
	}
}
