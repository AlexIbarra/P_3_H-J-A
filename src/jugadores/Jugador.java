package jugadores;

import java.util.ArrayList;

import carta.Mano;
import jugadas.Jugadas;
import main.PilaManos;

public class Jugador {
	
	private Mano mano;
	private Jugadas mejorJugada;
	private ArrayList<String> pilaManos;
	private ArrayList<Jugadas> mejoresManos;
	private int valor;
	private int numJugador; // es la posicion del jugador en la mesa (0..9)
	private int contManos;

	
	
	
	// Constructores

	public Jugador(Mano mano) {
		this.mano = mano;
	}
	
	public Jugador(int n) {
		this.numJugador = n;
		this.pilaManos = new ArrayList<String>();
		this.mejoresManos = new ArrayList<Jugadas>();
		this.contManos=0;
	}
	
	
	// Metodos
	
	
	public void addMejorMano(Jugadas jugada) {
		this.mejoresManos.add(jugada);
	}
	
	public Jugadas getMejoresManos(int i) {
		return this.mejoresManos.get(i);
	}
	
	
	public void addManoPila(String mano) {
		this.pilaManos.add(mano);
		this.contManos++;
	}
	
	public int getContManos() {
		return this.contManos;
	}
	
	public String getManoPila(int i) {
		return this.pilaManos.get(i);
	}

	
	public ArrayList<String> getPilaManos() {
		return this.pilaManos;
	}
	
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
