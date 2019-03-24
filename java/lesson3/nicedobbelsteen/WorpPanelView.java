package lesson3.nicedobbelsteen;

import javax.swing.JPanel;

public class WorpPanelView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WorpPanelView(Worp worp) {
		int aantal = worp.getAantalStenen();
		for (int i=0; i < aantal; i++) {
			add( new DobbelsteenButtonView(worp.getDobbelsteen(i)));
		}
	}

}
