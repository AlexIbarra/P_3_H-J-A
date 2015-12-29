package main;

import java.util.ArrayList;
import carta.Mano;

public class PilaManos {
	
	private ArrayList <Mano> pila;
	private ArrayList <Mano> pilaAux;
	private int contador;
	
	

	public PilaManos() {
		this.pila = new ArrayList <Mano>();
		this.pilaAux = new ArrayList <Mano>();
		this.contador = 0;
	}
	
	
	public Mano getMano(int i) {
		Mano mano=null;

		mano = this.pilaAux.get(i);
//		this.pilaAux.remove(this.contador-1);
//		this.contador--;
		
		return 	mano;
	}

	public void addMano(Mano mano) {
		this.pila.add(mano);
		this.pilaAux.add(mano);
		this.contador++;
	}
	
	public int size() {
		return this.contador;	
	}
	
	public void resetPila() {
		this.pilaAux = this.pila;
		this.contador = this.pila.size();
	}
	

}
