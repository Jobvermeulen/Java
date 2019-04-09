package connectFour;

import java.util.Observable;
import java.util.Observer;

/**
 *  
 * @author jobve
 */
public class ConnectFourConsoleView implements Observer{
	protected ConnectFourModel model;
	
	/**
	 * Wanneer deze classe wordt aangeroepen wordt deze view een observer van het model
	 * @param model
	 */
	public ConnectFourConsoleView(ConnectFourModel model) {
		this.model = model;
		model.addObserver(this);
	}
	
	/**
	 * Displayed het speelveld in de Console
	 */
	public void display() {		
		for(int row = 0; row<model.getGrid().length;row++) {
			System.out.println();
			for(int column = 0; column<model.getGrid()[row].length; column++) {
				switch(model.checkCelStatus(row,column)){
					case EMPTY:
						System.out.print("| 0 |");
					break;
					case PLAYER1:
						System.out.print("| 1 |");
					break;
					case PLAYER2:
						System.out.print("| 2 |");
					break;
				}
			}
		}
		System.out.println();
	}
	
	/**
	 * Deze methode kijkt wanneer er wat ingevuld is (bepaalde kolom)
	 * Als deze waarde goed gekeurd is, dan wordt hij doorgestuurd naar het model
	 */
	public void Scanner() {
		System.out.print(" Geef een cijfer tussen 1 en de "+ (model.getGrid()[0].length)+ ": ");
		//Scanner in = new Scanner(System.in);
		
		//try {
		//	int input = in.nextInt() - 1;
		//	if(input >=0 && input <= model.getGrid()[0].length-1) {
		//		model.insertCel(input);
		//	}else {
		//		System.out.println("Voer alleen getallen tussen de 1 en de " + (model.getGrid()[0].length) + " in.");
		//		updateRoutine();
		//	}
		//}catch(Exception e) {
		//	System.out.println("Voer alleen getallen tussen de 1 en de " + (model.getGrid()[0].length) + " in.");
		//	updateRoutine();
		//}
	}
	
	/**
	 * Een routine die elke keer wordt uitgevoerd wanneer een update van het model binnen komt
	 */
	private void updateRoutine() {
		display();
		if(!model.gewonnen) {
			Scanner();
		}else {
			System.out.println(model.player + " heeft gewonnen!");
		}	
	}
	
	/**
	 * Stuurd de routine methode aan
	 */
	@Override
	public void update(Observable o, Object arg) {
		updateRoutine();
	}
	
}
