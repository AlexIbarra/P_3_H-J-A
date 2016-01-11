package jugadores;

import java.util.ArrayList;

import carta.Carta;
import carta.Mano;
import jugadas.Jugadas;
import main.PilaManos;

public class Jugador {
	
	private Mano mano;
	private Jugadas mejorJugada;
	private String jugada;
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
		this.jugada = new String();
		this.contManos=0;
		this.mano = new Mano();
	}
	
	
	// Metodos
	
	public void setJugada(String cad) {
		this.jugada = cad;
	}
	
	public String getJugada() {
		return this.jugada;
	}
	
	
	public void parseJugada() {
		
		String[] array = jugada.split("");
		String cadena = new String();
		
		mano.deleteMano();
		
//		for (int i = 1; i < array.length-1; i+=2) {
		for (int i = 0; i < array.length; i+=2) {
			
			cadena += array[i];
			cadena += array[i+1];
			
			char[] token = cadena.toCharArray();
			
			mano.setMano(new Carta(token[0], token[1]));
			
			cadena = "";
			
		}
		
		mano.ordenaMano(0, mano.getMano().size() -1);
		
	}
	
	
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
