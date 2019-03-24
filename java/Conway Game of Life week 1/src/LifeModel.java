import java.util.Random;

public class LifeModel {
	private boolean[][] grid = new boolean[20][30];
	private static final int[][] NEIGHBOURS = {
		    {-1, -1}, {-1, 0}, {-1, +1},
		    { 0, -1},          { 0, +1},
		    {+1, -1}, {+1, 0}, {+1, +1}};
	
	public LifeModel() {
		Random rnd = new Random();
		
		for(int h=1; h<grid.length-1 ; h++) {
			for(int w=1; w<grid[h].length-1; w++) {
				grid[h][w] = rnd.nextBoolean();
			}
		}
	}
	
	public void algorithm() {
		show();
		nextGeneration();
	}
	
	private boolean isAlive(int row, int column) {
		if(row < 0 || row >= grid.length || column < 0 || column >= grid[row].length) {
			return false;
		}else {
			return grid[row][column];
		}
	}
	
	private void show() {
		for(int w=0; w<grid.length ; w++) {
			for(int h=0; h<grid[w].length; h++) {
				boolean status = isAlive(w,h);
				if(status == true) {
					System.out.print(" 0 ");
				}else {
					System.out.print(" . ");
				}
			}
			System.out.println();
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
	
	private int getWidth() {
		return grid.length;
	}
	
	private int getHeight() {
		return grid[0].length;
	}
	
	private void nextGeneration() {
		boolean[][] newgrid = new boolean[getWidth()][getHeight()];
		
		for(int w=0; w<grid.length ; w++) {
			for(int h=0; h<grid[w].length; h++) {
				newgrid[w][h] = evolueer(w,h);
			}
		}
		
		deepCopy(newgrid);
	}
	
	private void deepCopy(boolean[][] newgrid) {
		for(int w=0; w<grid.length ; w++) {
			for(int h=0; h<grid[w].length; h++) {
				grid[w][h] = newgrid[w][h];
			}
		}
    }
}
