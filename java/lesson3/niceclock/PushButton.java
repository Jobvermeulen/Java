package lesson3.niceclock;

import javax.swing.JButton;

public class PushButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String sign;

	public PushButton(String sign) {
		this.sign = sign;
		setText(sign);
	}

}
