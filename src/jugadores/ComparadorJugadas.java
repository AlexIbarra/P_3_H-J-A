package jugadores;


import java.util.ArrayList;

import main.ParserDraws;
import carta.Mano;
import jugadas.Jugadas;

public class ComparadorJugadas {
	
	private static ArrayList<Jugador> jugadores;
	
	
	public ComparadorJugadas() {
		
	}
	
	public static String clasificacion(ArrayList<Jugador> jug, int n) {
		jugadores = jug;
		ParserDraws parserD = new ParserDraws();
		int draws;
		
		if(n>1)
			burbuja(n);
		
		String cadena = "";
		for(int i=n-1; i >= 0; i--) { 
			
			cadena += jugadores.get(i).toString() + "\n";
			
			draws = parserD.Draw(jugadores.get(i).getMano());
			if(draws > 3)
				cadena += "- Draw: Straight Flush" + "\n";
			else
			{
				if((draws==3)||(draws==2))
					cadena += "- Draw: Straight Gutshot" + "\n";

				if((draws == 3)||(draws == 1))
					cadena += "- Draw: Flush" + "\n";
			}		
		}

		return cadena;		
	}
	
	
 

	private static void burbuja(int n) {
		
		Jugador jugtmp;
		
		for(int i=0;i<n-1;i++)
			for(int j=0;j<n-i-1;j++)        
				// Distintas jugadas
				if(jugadores.get(j+1).getValorJugador() < jugadores.get(j).getValorJugador()){
					jugtmp = jugadores.get(j+1);
					jugadores.set(j+1, jugadores.get(j));
					jugadores.set(j, jugtmp);
				}
				// Misma jugada pero distintas cartas
				else if(jugadores.get(j+1).getValorJugador() == jugadores.get(j).getValorJugador() &&
				jugadores.get(j+1).getMejorJugada().getNumJugada() < jugadores.get(j).getMejorJugada().getNumJugada()) {
					jugtmp = jugadores.get(j+1);
					jugadores.set(j+1, jugadores.get(j));
					jugadores.set(j, jugtmp);
				}
				//Misma jugada y mismas cartas (se mira el kicker)
				else if(jugadores.get(j+1).getValorJugador() == jugadores.get(j).getValorJugador() &&
				jugadores.get(j+1).getMejorJugada().getNumJugada() == jugadores.get(j).getMejorJugada().getNumJugada() &&
				comparaKicker(jugadores.get(j+1).getMejorJugada(), jugadores.get(j).getMejorJugada())) {
					
					jugtmp = jugadores.get(j+1);
					jugadores.set(j+1, jugadores.get(j));
					jugadores.set(j, jugtmp);
				}
				
         			
	}

	private static boolean comparaKicker(Jugadas jug1, Jugadas jug2) {
		 int i = jug1.numKickers()-1;
		 boolean encontrado = false;
		 boolean encontradoJ2 = false;
		 
		 while(i >= 0 && !encontrado && !encontradoJ2) {
			 encontrado = jug1.getKicker(i) < jug2.getKicker(i);
			 encontradoJ2 = jug1.getKicker(i) > jug2.getKicker(i);
			 i--;
		 }
		
		return encontrado;
	}
}
