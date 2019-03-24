package lesson3.dobbelsteen;

public class DobbelsteenConsoleView {
	
	private Dobbelsteen dobbelsteen;
	
	public DobbelsteenConsoleView(Dobbelsteen dobbelsteen) {		
		this.dobbelsteen = dobbelsteen;
	}

	public void refresh() {
		System.out.print("[");
		System.out.print(dobbelsteen.getWaarde());
		System.out.print("]");
	}
}
