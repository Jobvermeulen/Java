package lesson3.gameoflife;

public class CelPosition {
	
	private int rij, kolom;

	public CelPosition(int rij, int kolom) {
		this.rij = rij;
		this.kolom = kolom;
	}

	public int getRij() {
		return rij;
	}

	public int getKolom() {
		return kolom;
	}

}
