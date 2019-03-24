//import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

public class LifeModel extends Observable{
	private int rows;
	private int columns;
	
	private boolean[][] grid;	
	private static final int[][] NEIGHBOURS = {
		    {-1, -1}, {-1, 0}, {-1, +1},
		    { 0, -1},          { 0, +1},
		    {+1, -1}, {+1, 0}, {+1, +1}};
	
	public LifeModel(int rows, int columns) {
		setRows(rows);
		setColumns(columns);
		this.grid = new boolean[getRows()][getColumns()];
		
		Random rnd = new Random();
				
		for(int h=1; h<grid.length-1 ; h++) {
			for(int w=1; w<grid[h].length-1; w++) {
				grid[h][w] = rnd.nextBoolean();
			}
		}
	}
		
	protected boolean isAlive(int row, int column) {
		if(row < 0 || row >= grid.length || column < 0 || column >= grid[row].length) {
			return false;
		}else {
			return grid[row][column];
		}
	}
		
	private int countNeighbours(int row, int column) {
		 int cnt = 0;
		    for (int[] offset : NEIGHBOURS) {
		        if (isAlive(row + offset[0], column + offset[1])) {
		           cnt++;
		        }
		    }
		    return cnt;
	}
	
	private boolean evolueer(int row, int column) {
		int neighbours = countNeighbours(row,column);
		if(isAlive(row, column)) {
			if(neighbours >= 2 && neighbours <= 3) {
				return true;
				
			}else {
				return false;
			}
		}else {
			if(neighbours == 3) {
				return true;
			}else {
				return false;
			}
		}
	}
		
	protected void nextGeneration() {
		boolean[][] newgrid = new boolean[getRows()][getColumns()];
		
		for(int w=0; w<grid.length ; w++) {
			for(int h=0; h<grid[w].length; h++) {
				newgrid[w][h] = evolueer(w,h);
			}
		}
		
		deepCopy(newgrid);
		setChanged();
		notifyObservers();
	}
	
	private void deepCopy(boolean[][] newgrid) {
		for(int w=0; w<grid.length ; w++) {
			for(int h=0; h<grid[w].length; h++) {
				grid[w][h] = newgrid[w][h];
			}
		}
    }

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	protected boolean[][] getGrid(){
		return grid;
	}

	public void toggle(int rij, int kolom) {
		if (isAlive(rij,kolom)) {
			grid[rij][kolom] = false;
		} else {
			grid[rij][kolom] = true;
		}
		
		CelPosition cel = new CelPosition(rij, kolom);
		setChanged();
		notifyObservers(cel);
		
	}
}
