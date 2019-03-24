package lesson3.dobbelsteen;

import java.awt.Color;
import java.util.Observable;
import java.util.Random;

public class Dobbelsteen extends Observable {

	private static final Random generator = new Random();
	
	private int waarde;
	private Color kleur;


	
	public Dobbelsteen() {
		kleur = new Color( 	generator.nextInt(256),
							generator.nextInt(256),
							generator.nextInt(256)
							);
		werp();
	}
	
	
	public Color getKleur() {
		return kleur;
	}

	
	public void werp() {
		waarde = generator.nextInt(6) +1;
		setChanged();
		notifyObservers();
	}
	
	public int getWaarde() {
		return waarde;
	}
}
