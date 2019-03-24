package lesson3.gameoflife;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CelController implements ActionListener {

	LifeModel lifeModel;
	int rij, kolom;

	public CelController(LifeModel lifeModel, int rij, int kolom) {
		this.lifeModel = lifeModel;
		this.rij = rij;
		this.kolom = kolom;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		lifeModel.toggle(rij, kolom);

	}

}
