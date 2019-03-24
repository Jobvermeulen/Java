package lesson3.gameoflife;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LifePanelView extends JPanel implements Observer {
	
	private static final long serialVersionUID = 1L;

	LifeModel lifeModel;
	
	JButton[][] jButtons = new JButton[20][30];
	public LifePanelView(LifeModel lifeModel) {
		this.lifeModel = lifeModel;
		lifeModel.addObserver(this);
		setLayout(new GridLayout(20,30));
		for (int rij = 0; rij < 20; rij++) {
			for (int kolom = 0; kolom < 30; kolom ++) {
				jButtons[rij][kolom] = new JButton();
				jButtons[rij][kolom].setBackground(setColorCel(rij,kolom));
				jButtons[rij][kolom].setOpaque(true);
				jButtons[rij][kolom].setBorderPainted(false);
				jButtons[rij][kolom].addActionListener(new CelController(lifeModel,rij, kolom));
				this.add(jButtons[rij][kolom]);
			} 
		}
	}
	
	private void toonCel(int rij, int kolom) {
			jButtons[rij][kolom].setBackground(setColorCel(rij,kolom));
	}

	private Color setColorCel(int rij, int kolom) {
		if (lifeModel.isLevend(rij, kolom)) {
			return Color.BLACK;
		} else {
			return Color.WHITE;
		}
		
	}
	private void refresh() {
		for (int rij = 0; rij < 20; rij++) {
			for (int kolom = 0; kolom < 30; kolom++) {
				toonCel(rij, kolom);
			}
		}
		
	}
	@Override
	public void update(Observable lifeModel, Object info) {
		refresh();
	}

}
