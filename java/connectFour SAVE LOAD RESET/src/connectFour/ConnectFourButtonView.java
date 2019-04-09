package connectFour;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *  
 * @author jobve
 */
public class ConnectFourButtonView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private ConnectFourModel model;
	
	/**
	 * Zet het model in een private property
	 * Roept een methode aan om de buttons te initialiseren
	 * @param model
	 */
	public ConnectFourButtonView(ConnectFourModel model) {
		this.model = model;
		setButtons();
	}
	
	/**
	 * Initialiseerd buttons
	 */
	private void setButtons() {
		JButton buttonleft = new JButton();
		buttonleft.setText("SAVE");
		this.add(buttonleft);
		buttonleft.addActionListener(new SaveController(model));
		
		JButton buttonMiddle = new JButton();
		buttonMiddle.setText("LOAD");
		this.add(buttonMiddle);
		buttonMiddle.addActionListener(new LoadController(model));
		
		JButton buttonRight = new JButton();
		buttonRight.setText("RESET");
		this.add(buttonRight);
		buttonRight.addActionListener(new ResetController(model));
	}	
}
