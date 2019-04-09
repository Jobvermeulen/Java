package connectFour;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * @author jobve
 *
 */
public class ConnectFourPanelView extends JPanel implements Observer{
	private static final long serialVersionUID = 1L;
	private ConnectFourModel model;
	private JButton[][] grid;
	
	private final int rows;
	private final int columns;
	private final int buttonHeight = 100;
	private final int buttonWidth = 100;
	
	private Image picEmpty;
	private Image picPlayer1;
	private Image picPlayer2;	
	
	/**
	 * Wanneer deze classe wordt aangemaakt wordt het model meegegeven, zodat de klasse zich kan aanmelden als observer
	 * 
	 * @param model
	 */
	public ConnectFourPanelView(ConnectFourModel model) {
		this.model = model;
		model.addObserver(this);
		
		rows = model.getGrid().length;
		columns = model.getGrid()[0].length;
		
		grid = new JButton[rows][columns];
		
		getImages();
		initPanel();
	}
	
	/**
	 * Deze methode initialiseerd het paneel (het speelveld)
	 */
	public void initPanel() {
		setLayout(new GridLayout(rows, columns));
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column ++) {
				grid[row][column] = new JButton();
				setBTNBackground(row, column);
		    	grid[row][column].addActionListener(new CoinListener(model, column));
				grid[row][column].setBorderPainted(false);
				grid[row][column].setOpaque(true);
				grid[row][column].setBackground(Color.lightGray);
				grid[row][column].setBorderPainted(false);
				this.add(grid[row][column]);
			} 
		}
	}
	
	/**
	 * setBTNBackground houdt zich bezig met de achtergrond van een button.
	 * Het speelveld bestaat uit losse buttons, deze buttons kunnen een plaatje krijgen zodat het lijkt alsof er een muntje in het speelveld zit. 
	 * @param row
	 * @param column
	 */
	private void setBTNBackground(int row, int column) {
		switch(model.checkCelStatus(row,column)){
		case EMPTY:
			if(picEmpty != null)
				grid[row][column].setIcon(new ImageIcon(picEmpty));
		break;
		case PLAYER1:
			if(picPlayer1 != null)
				grid[row][column].setIcon(new ImageIcon(picPlayer1));
		break;
		case PLAYER2:
			if(picPlayer2 != null)
				grid[row][column].setIcon(new ImageIcon(picPlayer2));
		break;
		}
	}
	
	/**
	 * Deze methode haalt alle bijbehorende plaatjes op. Deze plaatjes zijn allemaal te vinden in het assets mapje
	 */
	private void getImages() {
		try {
			Image empty = ImageIO.read(getClass().getResource("/assets/connectFourCoins_Empty.png"));
			Image player1 = ImageIO.read(getClass().getResource("/assets/connectFourCoins_Player1.png"));
			Image player2 = ImageIO.read(getClass().getResource("/assets/connectFourCoins_Player2.png"));
			
			picEmpty = empty.getScaledInstance(buttonWidth, buttonHeight,  java.awt.Image.SCALE_SMOOTH);
			picPlayer1 = player1.getScaledInstance(buttonWidth, buttonHeight,  java.awt.Image.SCALE_SMOOTH);
			picPlayer2 = player2.getScaledInstance(buttonWidth, buttonHeight,  java.awt.Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returned de hoogte van een knopje
	 */
	public int getButtonHeight() {
		return buttonHeight;
	}
	
	/**
	 *  Returned de breedte van een knopje
	 */
	public int getButtonWidth() {
		return buttonWidth;
	}

	/**
	 * Wanneer de update methode wordt aangeroepen, zal er een wijziging plaats vinden op het spelbord.
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		setBTNBackground(model.lastUpdatedRow, model.lastUpdatedColumn);
	}
}
