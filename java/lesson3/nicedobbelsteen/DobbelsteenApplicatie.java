package lesson3.nicedobbelsteen;

import java.awt.BorderLayout;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.Timer;

public class DobbelsteenApplicatie extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int AANTAL = 10;

	public DobbelsteenApplicatie() {

		Worp worp = new Worp(AANTAL);
		add(new WorpPanelView(worp), BorderLayout.CENTER);

		Timer pulse = new Timer(1000, new PulseController(worp));
		pulse.start();

		add(new KnoppenBalk(worp, pulse), BorderLayout.SOUTH);
		add(new StatusBalk(worp), BorderLayout.NORTH);
		setBounds(100, 100, AANTAL * 110, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Dobbelstenen");
		setVisible(true);
		waitForEnter();

	}

	private void waitForEnter() {

		new Scanner(System.in).nextLine();
		System.exit(0);

	}

	public static void main(String[] args) {
		new DobbelsteenApplicatie();

	}

}
