package lesson3.nicedobbelsteen;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBalk extends JPanel implements Observer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Worp worp;

	private JLabel aantalWorpenLabel = new JLabel();
	private JLabel aantalStenenLabel = new JLabel();
	private JLabel aantalOgenLabel = new JLabel();
	public StatusBalk(Worp worp) {
		this.worp = worp;
		worp.addObserver(this);
		
		setLayout(new GridLayout(1,3));
		
		add(aantalWorpenLabel);
		add(aantalStenenLabel);
		add(aantalOgenLabel);
		
		refresh();
		
	}

	private void refresh() {
		aantalWorpenLabel.setText("AantalWorpen: " + worp.getAantalWorpen());
		aantalStenenLabel.setText("aantalStenen: " + worp.getAantalStenen());
		aantalOgenLabel.setText("aantalOgen: " + worp.getWaarde());
		
	}

	@Override
	public void update(Observable o, Object arg) {
		refresh();

	}

}
