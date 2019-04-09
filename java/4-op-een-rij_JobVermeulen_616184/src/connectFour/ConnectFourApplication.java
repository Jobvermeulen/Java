package connectFour;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *  
 * @author jobve
 */
public class ConnectFourApplication extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private ConnectFourModel connectFourModel;

	/**
	 * Wanneer deze klasse wordt aangeroepen, wordt het spel geinitialiseerd
	 */
	public ConnectFourApplication(){
		initialize();
	}
	
	/**
	 * Initialiseerd het model en de GUI
	 */
	private void initialize() {
		connectFourModel = new ConnectFourModel();
		
		/**
		 * Voor de ConsoleView \/ (moet dan uitgecommand worden )
		 */
		//ConnectFourConsoleView ConnectFourConsoleView = new ConnectFourConsoleView(connectFourModel);
		//ConnectFourConsoleView.display();
		//ConnectFourConsoleView.Scanner();		
		
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
				createAndShowGUI();	
			}
		});
	}
	
	/**
	 * Maakt de GUI aan
	 */
	private void createAndShowGUI() {
		ConnectFourPanelView view = new ConnectFourPanelView(connectFourModel);
		ConnectFourStatusBarView statusView = new ConnectFourStatusBarView(connectFourModel);
		ConnectFourButtonView buttonView = new ConnectFourButtonView(connectFourModel);		
		
		setSize(view.getButtonWidth() * connectFourModel.getGrid()[0].length, (view.getButtonHeight() * connectFourModel.getGrid().length)+100);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Connect four game");

		add(buttonView, BorderLayout.PAGE_START);
		add(view, BorderLayout.CENTER);
		add(statusView, BorderLayout.PAGE_END);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ConnectFourApplication();
	}

}
