package connectFour;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  
 * @author jobve
 */
public class CoinListener implements ActionListener{
	
	private ConnectFourModel model;
	private int column;
	
	/**
	 * Als deze klasse wordt aangeroepen, worden de waardes in de velden gezet
	 * @param model
	 * @param column
	 */
	public CoinListener(ConnectFourModel model,int column) {
		this.model = model;
		this.column = column;
	}

	/**
	 * Als er op een button gedrukt wordt, wordt het model aangeroepen
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(!model.gewonnen) {
			model.insertCel(column);
		}		
	}
	
}
