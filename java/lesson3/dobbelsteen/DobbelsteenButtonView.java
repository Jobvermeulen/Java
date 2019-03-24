package lesson3.dobbelsteen;

import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

public class DobbelsteenButtonView extends JButton implements Observer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dobbelsteen dobbelsteen;

	public DobbelsteenButtonView(Dobbelsteen dobbelsteen) {
		this.dobbelsteen = dobbelsteen;
		dobbelsteen.addObserver(this);
		
		addActionListener(new DobbelsteenController(dobbelsteen));
		setBackground(dobbelsteen.getKleur());
		setOpaque(true);
		setBorderPainted(false);
		setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		refresh();
	}

	public void refresh() {
		setText("" + dobbelsteen.getWaarde());
		
	}

	@Override
	public void update(Observable o, Object info) {
		refresh();

	}

}
