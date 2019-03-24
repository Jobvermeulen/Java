package lesson3.nicedobbelsteen;

import java.util.Observable;

public class Worp extends Observable {

	private Dobbelsteen[] stenen;
	private static int aantalWorpen = 0;

	public Worp(int aantal) {
		stenen = new Dobbelsteen[aantal];

		for (int i = 0; i < aantal; i++) {
			stenen[i] = new Dobbelsteen();
		}
		werp();

	}

	public void werp() {
		for (Dobbelsteen steen : stenen) {
			steen.werp();
		}
		aantalWorpen += 1;
		
		setChanged();
		notifyObservers();
	}

	public int getWaarde() {
		int waarde = 0;
		for (Dobbelsteen steen : stenen) {
			waarde += steen.getWaarde();
		}
		return waarde;
	}

	public int getAantalStenen() {
		return stenen.length;
	}

	public Dobbelsteen getDobbelsteen(int nummer) {
		return stenen[nummer];
	}
	
	public int getAantalWorpen() {
		return aantalWorpen;
	}

}
