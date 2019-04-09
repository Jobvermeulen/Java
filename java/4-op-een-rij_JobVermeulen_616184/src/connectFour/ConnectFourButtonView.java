package connectFour;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *  
 * @author jobve
 */
public class ConnectFourButtonView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Zet het model in een private property
	 * Roept een methode aan om de buttons te initialiseren
	 * @param model
	 */
	public ConnectFourButtonView(ConnectFourModel model) {
		setButtons();
	}
	
	/**
	 * Initialiseerd buttons
	 */
	private void setButtons() {
		JButton buttonleft = new JButton();
		buttonleft.setText("...");
		this.add(buttonleft);
		//buttonleft.addActionListener(arg0);
		
		JButton buttonMiddle = new JButton();

		buttonMiddle.setText("...");
		this.add(buttonMiddle);
		//buttonMiddle.addActionListener(arg0);
		
		JButton buttonRight = new JButton();

		buttonRight.setText("...");
		this.add(buttonRight);
		//buttonRight.addActionListener(arg0);
	}	
}
