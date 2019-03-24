
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class LifeApplication extends JFrame{	
	
	private LifeModel LifeModel;	
	public LifeApplication() {
		initialize();
	}
	
	private void initialize() {
		LifeModel = new LifeModel(20,30);
		
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

		Timer timer = new Timer(1000, new LifeController(LifeModel));

		LifePanelView view = new LifePanelView(LifeModel);
		PauzeBalkView balk = new PauzeBalkView(timer);

		setVisible(true);
		add(view, BorderLayout.CENTER);
		add(balk, BorderLayout.SOUTH);
		view.setVisible(true);

		timer.setInitialDelay(0);
		timer.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LifeApplication();
	}

}
