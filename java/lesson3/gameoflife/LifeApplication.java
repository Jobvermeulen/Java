package lesson3.gameoflife;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class LifeApplication extends JFrame {

	private static final long serialVersionUID = 1L;

	private LifeModel lifeModel;
	public LifeApplication() {
		initialize();
	}

	private void initialize() {
		
		lifeModel = new LifeModel();
		SwingUtilities.invokeLater(new Runnable() {
	
			@Override
			public void run() {
				createAndShowGUI();	
			}
		});			
	}


	private void createAndShowGUI() {
		setBounds(100, 100, 350, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Game of Life");

		Timer timer = new Timer(2000, new LifeController(lifeModel));

		LifePanelView view = new LifePanelView(lifeModel);
		PauzeBalkView balk = new PauzeBalkView(timer);

		setVisible(true);
		add(view, BorderLayout.CENTER);
		add(balk, BorderLayout.SOUTH);
		view.setVisible(true);

		timer.setInitialDelay(0);
		timer.start();
	}

	public static void main(String[] args) {
		new LifeApplication();
		
	}
}
