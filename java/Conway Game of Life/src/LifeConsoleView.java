import java.util.Observable;
import java.util.Observer;

public class LifeConsoleView implements Observer{
	protected LifeModel model;
	
	public LifeConsoleView(LifeModel model) {
		this.model = model;
		model.addObserver(this);
	}
	
	public void displayCell(int row, int column) {
		boolean status = model.isAlive(row,column);
		if(status == true) {
			System.out.print(" 0 ");
		}else {
			System.out.print(" . ");
		}
	}
	
	private void refresh() {
		boolean[][] grid= model.getGrid();
		
		for(int w=0; w< grid.length ; w++) {
			for(int h=0; h< grid[w].length; h++) {
				displayCell(w, h);
			}
			System.out.println();
		}
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		refresh();
	}
}
