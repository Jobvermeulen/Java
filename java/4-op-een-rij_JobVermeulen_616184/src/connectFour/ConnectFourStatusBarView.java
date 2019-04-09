package connectFour;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import connectFour.ConnectFourModel.celStatus;
/**
 *  
 * @author jobve
 * 
 */

public class ConnectFourStatusBarView extends JPanel implements Observer{
	private static final long serialVersionUID = 1L;
	private ConnectFourModel model;	
	private JLabel status;
	
	/**
	 * De constructor voor de Classe.
	 * Er wordt een model meegegeven zodat deze View ook een observer kan worden
	 * @param model
	 */
	public ConnectFourStatusBarView(ConnectFourModel model) {
		this.model = model;
		model.addObserver(this);
		status = new JLabel();
		this.add(status);
		updateStatusBar();
	}
	
	/**
	 * Updates de status bar 
	 * 
	 */
	private void updateStatusBar() {
		setUser();
		setBackground();
	}
	
	/**
	 * De achtergrond/voorgrond van de status bar wordt gekleurd in de bijpassende kleur van de speler
	 */
	private void setBackground() {
		if(model.player == celStatus.PLAYER1) {
			this.setBackground(new Color(213,208,62));
			status.setForeground(Color.black);
		}else {
			this.setBackground(new Color(213,62,62));
			status.setForeground(Color.white);
		}
	}
	
	
	/**
	 * Deze methode print de status van het spel;
	 * De player die aan de beurt is.
	 * of wanneer het spelletje door iemand gewonnen is.
	 */
	private void setUser() {
		if(!model.gewonnen) {
			if(model.player == celStatus.PLAYER1) {
				status.setText("Player 1 is aan de beurt!");
			}else {
				status.setText("Player 2 is aan de beurt!");
			}
		}else {
			if(model.player == celStatus.EMPTY) {
				status.setText("Gelijkspel!");

			}else {
				status.setText(model.player + " heeft gewonnen!");
			}
		}
		
	}

	/**
	 * Update methode wordt aangeroepen door het model.
	 * Op deze manier kan de statusbar geupdated worden
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		updateStatusBar();
	}
	
	
}
