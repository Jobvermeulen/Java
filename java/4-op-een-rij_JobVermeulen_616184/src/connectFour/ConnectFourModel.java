package connectFour;

import java.util.Observable;

/**
 * 
 * @author jobve
 *
 */
public class ConnectFourModel extends Observable {
	public enum celStatus {
		EMPTY,
		PLAYER1,
		PLAYER2
	}
	
	private final int rows = 6;
	private final int columns = 7;
	private celStatus[][] celGrid = new celStatus[rows][columns];
	protected celStatus player = celStatus.PLAYER1;
	public Boolean gewonnen = false;
	public int lastUpdatedRow = 0;
	public int lastUpdatedColumn = 0;
	private int rounds = 0;
	
	/**
	 * Wanneer deze classe wordt aangeroepen, zal er een grid geinitialiseerd worden.
	 */
	public ConnectFourModel() {		
		for(int h=0; h<this.rows ; h++) {
			for(int w=0; w<this.columns; w++) {
				this.celGrid[h][w] = celStatus.EMPTY;
			}
		}
	}
	
	/**
	 * InsertCel methode wordt aangeroepen, als er op een button van het speelveld geklikt is.
	 * Deze methode controleert welke rij in combinatie met de column nog vrij is. 
	 * Hierna kan er gekeken worden of het vrije plekje bij player1 of player2 hoort
	 * @param column
	 */
	protected void insertCel(int column) {
		if(column < columns) {
			int row = 0;
			for(row = rows-1; row >= 0; row--) {
				if(checkCelStatus(row, column) == celStatus.EMPTY) {
					rounds ++;
					if(player == celStatus.PLAYER1) {
						this.celGrid[row][column] = celStatus.PLAYER1;
					}
					else {
						this.celGrid[row][column] = celStatus.PLAYER2;
					}
					if(!checkWinnerRoutine(row, column)) 
						switchPlayer();		
					
					lastUpdatedRow = row;
					lastUpdatedColumn = column;
					break;
				}else {
					
				}
			}								
		}else {
			
		}
		setChanged();
		notifyObservers();
	}	
	
	/**
	 * Methode die de player switch (beurt switch player1->player2)
	 */
	private void switchPlayer() {
		if(player == celStatus.PLAYER1)
			player = celStatus.PLAYER2;
		else
			player = celStatus.PLAYER1;
	}
	
	/**
	 * Deze methode controleert of er een winnaar is. Daarnaast wordt er gekeken of er gelijkspel is.
	 * @param row
	 * @param column
	 * @return
	 */
	private Boolean checkWinnerRoutine(int row, int column) {
		if(checkHorizontal(row))
			return true;
		if(checkVertical(column))
			return true;
		if(checkDiagonalRight(row, column))
			return true;
		if(checkDiagonalLeft(row, column))
			return true;
		if(checkDraw())
			return true;	
		
		return false;
	}
	
	/**
	 * Controleert of er een winnaar zit in de horizontale rij
	 * @param row
	 * @return
	 */
	private Boolean checkHorizontal(int row) {
		int amount = 0;
		for(int column = 0; column < celGrid[row].length; column++) {
			if(celGrid[row][column] == player) {
				amount++;
				if(amount == 4) {
					gewonnen = true;
					return true;
				}
			}
			else {
				amount = 0;
			}			
		}		
		return false;
	}
	
	/**
	 * Controleert of er een winnaar zit in de verticale rij
	 * @param column
	 * @return
	 */
	private Boolean checkVertical(int column) {
		int amount = 0;
		
		for(int row = 0; row < celGrid.length; row++) {
			if(celGrid[row][column] == player) {
				amount++;
				if(amount == 4) {
					gewonnen = true;
					return true;
				}
			}
			else {
				amount = 0;
			}			
		}		
		return false;
	}
	
	/**
	 * Controleert of er een winnaar zit in de diagonale rij ( rechts)
	 * @param row
	 * @param column
	 * @return
	 */
	private Boolean checkDiagonalRight(int row, int column) {
		int amount = 0;		
		
		int[][] offsetRight = { {-3,3},{-2,2},{-1,1},{0,0},{1,-1},{2,-2},{3,-3} };
		
		for(int[] offset : offsetRight) {
			int r = row + offset[0];
			int c = column + offset[1];
			//System.out.println(row + " " + r + " | " + column + " " + c);
			if((r >=0 && r <= celGrid.length-1) && (c>=0 && c<=celGrid[row].length-1)) {

				if(celGrid[r][c] == player) {
					amount++;
					if(amount == 4) {
						gewonnen = true;
						return true;
					}
				}
				else {
					amount = 0;
				}
			}
			
		}
		return false;
	}
	
	/**
	 * Controleert of er een winnaar zit in de diagonale rij ( links)
	 * @param row
	 * @param column
	 * @return
	 */
	private Boolean checkDiagonalLeft(int row, int column) {
		int amount = 0;		
		
		int[][] offsetRight = { {-3,-3},{-2,-2},{-1,-1},{0,0},{1,1},{2,2},{3,3} };
		
		for(int[] offset : offsetRight) {
			int r = row + offset[0];
			int c = column + offset[1];
			//System.out.println(row + " " + r + " | " + column + " " + c);
			if((r >=0 && r <= celGrid.length-1) && (c>=0 && c<=celGrid[row].length-1)) {
				if(celGrid[r][c] == player) {
					amount++;
					if(amount == 4) {
						gewonnen = true;
						return true;
					}
				}
				else {
					amount = 0;
				}
			}
			
		}
		return false;
	}	
	
	/**
	 * Controleert of er een gelijk spel is.
	 * @return
	 */
	private Boolean checkDraw() {
		if(rounds == (rows*columns)) {
			player = celStatus.EMPTY;
			gewonnen = true;
			return true;
		}
		return false;
	}
	
	/**
	 * Returned het Grid
	 * @return
	 */
	public celStatus[][] getGrid() {
		return celGrid;
	}
	
	/**
	 * Returned de celstatus van een bepaalde cel
	 * @param row
	 * @param column
	 * @return
	 */
	public celStatus checkCelStatus(int row, int column) {
		celStatus celstate = celGrid[row][column];				
		return celstate;
	}	
	
	
}
