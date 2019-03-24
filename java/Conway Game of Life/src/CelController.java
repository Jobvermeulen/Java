import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CelController implements ActionListener{
	LifeModel LifeModel;
	int rij, kolom;
	
	public CelController(LifeModel LifeModel, int rij, int kolom) {
		this.LifeModel = LifeModel;
		this.rij = rij;
		this.kolom = kolom;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		LifeModel.toggle(rij,kolom);
	}
	
}
