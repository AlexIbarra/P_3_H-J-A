package gui;

import javax.swing.JButton;

public class Button {
	
	private JButton[][] pares;
	private boolean [][] valorPares;
	
	public Button() {
		
		this.pares = new JButton[13][13];
		this.valorPares = new boolean[13][13];
	}
	
	
	public void setText(int col, int fil, String text) {
		
		this.pares[col][fil].setText(text);
//		this.valorPares[col][fil] = true;
	}
	
	public JButton getPares(int col, int fil) {
		return this.pares[col][fil];
	}
	
	public void setPares(int col, int fil, JButton btn) {
		this.pares[col][fil] = btn;
	}

}
