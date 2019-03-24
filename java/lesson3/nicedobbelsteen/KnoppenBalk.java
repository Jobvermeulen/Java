package lesson3.nicedobbelsteen;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.Timer;

public class KnoppenBalk extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCheckBox autoCheckBox;
	private JButton pauzeButton, werpButton;
	
	public KnoppenBalk(Worp worp, Timer pulse) {
		TimerController controller = new TimerController(pulse);
		
		autoCheckBox = new JCheckBox("Automatisch werpen");
		autoCheckBox.addActionListener(controller);
		
		pauzeButton = new JButton("Continue");
		pauzeButton.addActionListener(controller);
		
		werpButton = new JButton("gooi");
		werpButton.addActionListener(new WorpController(worp));
		
		setLayout(new GridLayout(1,3));
		add(autoCheckBox);
		add(pauzeButton);
		add(werpButton);
				
	}

}
