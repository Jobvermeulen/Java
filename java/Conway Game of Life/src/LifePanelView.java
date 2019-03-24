import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LifePanelView extends JPanel implements Observer{
	private LifeModel LifeModel;	
	JButton[][] JButton = new JButton[20][30];
	
	public LifePanelView(LifeModel LifeModel) {
		this.LifeModel = LifeModel;
		LifeModel.addObserver(this);
		setLayout(new GridLayout(20,30));
		for (int rij = 0; rij < 20; rij++) {
			for (int kolom = 0; kolom < 30; kolom ++) {
				JButton[rij][kolom] = new JButton();
				JButton[rij][kolom].setBackground(setColorCel(rij,kolom));
				JButton[rij][kolom].setOpaque(true);
				JButton[rij][kolom].setBorderPainted(false);
				JButton[rij][kolom].addActionListener(new CelController(LifeModel,rij, kolom));
				this.add(JButton[rij][kolom]);
			} 
		}
	}
	
	private void toonCel(int rij, int kolom) {
		JButton[rij][kolom].setBackground(setColorCel(rij,kolom));
	}

	private Color setColorCel(int rij, int kolom) {
		if (LifeModel.isAlive(rij, kolom)) {
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
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		refresh();
	}
}
