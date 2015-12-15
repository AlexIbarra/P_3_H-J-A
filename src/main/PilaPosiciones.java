package main;

import java.util.Vector;

public class PilaPosiciones {
	
	private Vector<Posicion> posiciones;
	private int contador;
	private int cont;
	


	public PilaPosiciones() {
		
		this.posiciones = new Vector<Posicion>();
		this.contador = 0;
		this.cont = 0;
	}
	
	
	public void addPosicion(int col, int fil) {
		this.posiciones.add(new Posicion(col, fil));
		this.contador++;
		this.cont++;
	}
	
	public Posicion extractPosition() {
		
		Posicion pos = this.posiciones.get(cont-1);
		this.posiciones.remove(cont-1);
		
		
		if(cont-1 < 0)
			System.out.println("Contador < 0");

		cont--;
		
		return pos;
	}
	
	public void resetContador() {
		this.contador=0;
	}
	
	public int getContador() {
		return contador;
	}

}
