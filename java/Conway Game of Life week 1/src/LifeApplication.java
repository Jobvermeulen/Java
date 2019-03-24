import java.util.Timer;
import java.util.TimerTask;

public class LifeApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LifeModel model  = new LifeModel();
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				model.algorithm();
			}}, 0,100);	
		
	}

}
