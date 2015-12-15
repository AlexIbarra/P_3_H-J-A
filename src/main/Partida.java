package main;
import java.util.ArrayList;

import jugadores.Jugador;

public class Partida {
	
	private ArrayList<Jugador> jugadores;
	private int numJugadores;
	
	
	public Partida() {
		this.jugadores = new ArrayList<Jugador>();
		this.numJugadores = 0;
	}
	
	public void addJugador(Jugador jugador) {
		this.jugadores.add(jugador);
		this.numJugadores++;
	}
	
	public Jugador getJugador(int i) {
		return this.jugadores.get(i);
	}
	
	public int getNumJugadores() {
		return this.numJugadores;
	}
	
	public ArrayList<Jugador> getJugadores() {
		return this.jugadores;
	}

}
