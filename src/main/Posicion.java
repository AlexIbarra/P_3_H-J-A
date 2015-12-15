package main;

public class Posicion {
	
	private int columna;
	private int fila;
	
	public Posicion() {}
	
	public Posicion(int c, int f){
		this.columna = c;
		this.fila = f;
	}
	
	
	public int getColumna() {
		return columna;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}

}
