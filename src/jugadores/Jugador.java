package jugadores;

import carta.Mano;
import jugadas.Jugadas;

public class Jugador {
	
	private Mano mano;
	private Jugadas mejorJugada;
	private int valor;
	private int numJugador; // es la posicion del jugador en la mesa (0..9)

	
	
	
	// Constructores

	public Jugador(Mano mano) {
		this.mano = mano;
	}
	
	public Jugador(int n) {
		this.numJugador = n;
	}
	
	
	// Metodos

	
	public Mano getMano() {
		return this.mano;
	}
	
	public void setMejorJugada(Jugadas jugada) {
		this.mejorJugada = jugada;
		this.valor = this.mejorJugada.getValorJugada();
	}

	
	public int getValorJugador() {
		return this.valor;
	}
	
	public int getNumJugador() {
		return this.numJugador;
	}
	
	public void setMano(Mano mano) {
		this.mano = mano;
	}
	
	public Jugadas getMejorJugada() {
		return this.mejorJugada;
	}
	
	
	
	public String toString() {
		String cadena;
		cadena = "J"+this.numJugador+": "+this.mejorJugada.toString();
		return cadena;
	}

}
