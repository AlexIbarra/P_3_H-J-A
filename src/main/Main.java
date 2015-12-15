package main;
import java.io.IOException;
import java.util.ArrayList;

import IO.FileIn;
import IO.FileOut;
import carta.Carta;
import carta.Mano;
import controlador.Controller;
import gui.Ventana;
import jugadas.Jugadas;
import jugadores.ComparadorJugadas;
import jugadores.Jugador;

public class Main {

	public static void main(String[] args) {

//		ParserJugadas parserJ = new ParserJugadas();
//		ParserDraws parserD = new ParserDraws();
//		int draws;
		
		
		
		Controller cntrl = new Controller();
		Ventana wind = new Ventana(cntrl);
		
		
//		try {
//			long time_start, time_end;
//			time_start = System.currentTimeMillis();
//			
//			
//			/* Los ficheros de entrada y salida son indicados como argumentos del programa */
//			FileIn filein = new FileIn(args[0]);
//			FileOut fileout = new FileOut(args[1]);
//			String partidaLeida;
//			String clasificacion;
//			
//			/* Miestras quede una partida por leer (linea de texto) */
//			while((partidaLeida=filein.readPartida()) != null){
//				
//				clasificacion = partidaLeida + "\n";
//				
//				/* Genero la partida (la/s mano/s) que se vaa jugar */
//				Partida partidaJugar = ParserManos.parse(partidaLeida, filein.getNumJugadores());
//				
//				/* Busco la mejor jugada para el/los mejor/es jugador/es */
//				for(int i=0; i < filein.getNumJugadores(); i++) {
//					
//					Jugadas mejorJugada = parserJ.parse(partidaJugar.getJugador(i).getMano());
//					partidaJugar.getJugador(i).setMejorJugada(mejorJugada);
//					
//					
//					if(filein.getNumJugadores() <= 1) {
//						clasificacion += "- Best hand: ";
//						clasificacion += mejorJugada.toString() + "\n";
//						
//						draws = parserD.Draw(partidaJugar.getJugador(i).getMano());
//						if(draws > 3)
//							clasificacion += "- Draw: Straight Flush" + "\n";
//						else
//						{
//							if((draws==3)||(draws==2))
//								clasificacion += "- Draw: Straight Gutshot" + "\n";
//
//							if((draws == 3)||(draws == 1))
//								clasificacion += "- Draw: Flush" + "\n";
//						}							
//					}
//					
//					
//				}
//				if(filein.getNumJugadores() > 1)
//					clasificacion += ComparadorJugadas.clasificacion(partidaJugar.getJugadores(), filein.getNumJugadores());
//				
//				/* Escribo en el fichero de salida los resultados de la partida ejecutada */
//				fileout.writePartida(clasificacion);
//			}
//			
//			fileout.closeFile();
//			
//			
//			time_end = System.currentTimeMillis();
//			System.out.println("Tiempo transcurrido: "+ ( time_end - time_start ) +" milisegundos");
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}