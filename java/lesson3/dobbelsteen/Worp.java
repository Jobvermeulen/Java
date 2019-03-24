package lesson3.dobbelsteen;

public class Worp {

	private Dobbelsteen[] stenen;

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

}
