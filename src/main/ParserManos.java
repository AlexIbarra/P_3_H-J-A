package main;
import carta.Carta;
import carta.Mano;
import jugadores.Jugador;

public class ParserManos {
	
	
	public static Partida parse(String s, int numjug) {
		
		Partida partida = new Partida();
		int i=0, limit;
			
		String[] array = s.split("\n");		
		char[] token = array[0].toCharArray();
		
		/* Caso 3 */
		if(token[1] == ';') {
			
			i=4;
			for(int k=0; k < numjug; k++) {
				
				Jugador jugador = new Jugador(k+1);
				Mano manoJugador = new Mano();
				
				/* Primero leo las cartas de la mesa */
				
				/* RIVER */
				if(token[token.length-11] == ';') {
					manoJugador.setMano(new Carta(token[token.length-2], token[token.length-1]));
					manoJugador.setMano(new Carta(token[token.length-4], token[token.length-3]));
					manoJugador.setMano(new Carta(token[token.length-6], token[token.length-5]));
					manoJugador.setMano(new Carta(token[token.length-8], token[token.length-7]));
					manoJugador.setMano(new Carta(token[token.length-10], token[token.length-9]));
				}
				/* TURN */
				else if(token[token.length-9] == ';') {
					manoJugador.setMano(new Carta(token[token.length-2], token[token.length-1]));
					manoJugador.setMano(new Carta(token[token.length-4], token[token.length-3]));
					manoJugador.setMano(new Carta(token[token.length-6], token[token.length-5]));
					manoJugador.setMano(new Carta(token[token.length-8], token[token.length-7]));
				}
				/* FLOP */
				else {
					manoJugador.setMano(new Carta(token[token.length-2], token[token.length-1]));
					manoJugador.setMano(new Carta(token[token.length-4], token[token.length-3]));
					manoJugador.setMano(new Carta(token[token.length-6], token[token.length-5]));
				}
				
				/* Ahora leo las cartas de cada jugador */
				manoJugador.setMano(new Carta(token[i], token[i+1]));
				manoJugador.setMano(new Carta(token[i+2], token[i+3]));
				
				limit = manoJugador.getMano().size() -1;
				
				/* Ordenamos la mano pasandole los rangos del array de manos */
				manoJugador.ordenaMano(0, limit);
				
				
				/* Añado los jugadores de cada partida */
				jugador.setMano(manoJugador);
				partida.addJugador(jugador);
				
				
				/* Incremento el iterador para saltarme el ; */
				i+=7;
			}
			
			
		}
		/* Caso 2 */
		else if(token[4] == ';') {
			i=7;
				
			Jugador jugador = new Jugador(null);
			Mano manoJugador = new Mano();
			
			manoJugador.setMano(new Carta(token[0], token[1]));
			manoJugador.setMano(new Carta(token[2], token[3]));
			
			/* Leo las cartas que hay en la mesa (flop, turn o river) */
			int mesa = Character.getNumericValue(token[5]);
			for(int j=0; j < mesa; j++) {
				manoJugador.setMano(new Carta(token[i], token[i+1]));
				i+=2;
			}
			
			limit = manoJugador.getMano().size() -1;
			
			/* Ordenamos la mano pasandole los rangos del array de manos */
			manoJugador.ordenaMano(0, limit);
			
			
			/* Añado los jugadores de cada partida */
			jugador.setMano(manoJugador);
			partida.addJugador(jugador);				
			
		}
		/* Caso 1*/
		else {
			Jugador jugador = new Jugador(null);
			Mano manoJugador = new Mano();
			
			manoJugador.setMano(new Carta(token[0], token[1]));
			manoJugador.setMano(new Carta(token[2], token[3]));
			manoJugador.setMano(new Carta(token[4], token[5]));
			manoJugador.setMano(new Carta(token[6], token[7]));
			manoJugador.setMano(new Carta(token[8], token[9]));
			
			limit = manoJugador.getMano().size() -1;
			
			/* Ordenamos la mano pasandole los rangos del array de manos */
			manoJugador.ordenaMano(0, limit);
			
			
			/* Añado los jugadores de cada partida */
			jugador.setMano(manoJugador);
			partida.addJugador(jugador);
			
		}
		
		return partida;
		
	}

}
