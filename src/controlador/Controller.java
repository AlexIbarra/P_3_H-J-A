package controlador;

import gui.PanelOeste;

import java.util.ArrayList;

import javax.swing.JTextArea;

import carta.Carta;
import carta.Combo;
import carta.Mano;
import combos.Combos;
import combos.ParserCombos;
import jugadas.Jugadas;
import jugadores.ComparadorJugadas;
import jugadores.Jugador;
import main.ParserJugadas;
import main.ParserManos;
import main.ParserRangos;
import main.ParserRankings;
import main.PilaManos;
import main.PilaPosiciones;
import main.Posicion;
import observers.RangoObserver;
import observers.RankingObserver;
import ranking.*;

public class Controller {
	
	private ParserRangos pRangos;
	private ParserRankings pRankings;
	private ComparadorJugadas comJugadas;
	private ParserJugadas pJugadas;
	private ParserManos pManos;
	private ParserCombos pCombos;
	private PilaManos pilaManos;
	private Ranking rankings[];
	private Ranking rankingActivo;
	private RankingChubukov rChurukov;
	private String rango;
	private double ganadosJ1;
	private double ganadosJ2;
	private JTextArea panel;
	

	public Controller() {
		this.pilaManos = new PilaManos();
		this.pJugadas = new ParserJugadas();
		this.pManos = new ParserManos();
		this.pRangos = new ParserRangos();
		this.pRankings = new ParserRankings();
		this.pCombos = new ParserCombos();
		this.rankings  = new Ranking[5];
		this.rankings[0] = new RankingChubukov();
		this.rankings[1] = new RankingJanda();
		this.rankings[2] = new RankingMa();
		this.rankings[3] = new RankingRock();
		this.rankings[4] = new RankingTight();
		this.rankingActivo = this.rankings[0]; // set Churukov default
		this.comJugadas = new ComparadorJugadas();
		this.ganadosJ1 = 0;
		this.ganadosJ2 = 0;
		
	}
	

	
	
	public JTextArea getPanel() {
		return panel;
	}




	public void setPanel(JTextArea panel) {
		this.panel = panel;
	}
	
	public void setTextPanel(String cadena){
		this.panel.setText(cadena);
	}




	/* Metodo que se encarga de generar de forma aleatoria las posibles manos
	 * que habria sobre la mesa teninedo en cuenta las que tienen los jugadores */
	public void generaCombinaciones(ArrayList <String> manos, String board, String dead) {

		long time_start, time_end;
		time_start = System.currentTimeMillis();
		Combos combosJ1=null;
		Combos combosJ2=null;
		Combo comboJ1=null;
		Combo comboJ2=null;
		Carta carta;
		boolean condicion, condicion2, condicion3, condicion4, condicion5;
		ArrayList<Carta> cartasBoard = new ArrayList<Carta>();
		ArrayList<Carta> cartasQuemadas= new ArrayList<Carta>();
		int n=0, pos=0, k=0;
		int pos1J1=0, pos2J1=0, pos1J2=0, pos2J2=0;
		Mano manoAleatoria=null, manoJ1, manoJ2;
		Mano mAleatoriaJ1, mAleatoriaJ2;
		Jugador jug1, jug2;
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		
		ganadosJ1=0;
		ganadosJ2=0;
	
		
		/* Inicializamos la baraja */
		pCombos.rellenarBaraja();
		
		jug1 = new Jugador(0);
		jug2 = new Jugador(1);
		
		jugadores.add(jug1);
		jugadores.add(jug2);
		
		/* Si hay cartas en el board */
		if(!board.equals("")) {
			
			String[] array = board.split(",");
			n = array.length;
			for (int i = 0; i < array.length; i++) {
				char[] token = array[i].toCharArray();
				carta = new Carta(token[0], token[1]);
				cartasBoard.add(carta);
				pos = pCombos.calculaPosicionparaBorrar(carta.getCodigo(), carta.getPalo());
				pCombos.setUsada(pos, false);
			}		
			
		}
		
		if(!dead.equals("")) {
			String[] array = dead.split(",");
			n = array.length;
			for (int i = 0; i < array.length; i++) {
				char[] token = array[i].toCharArray();
				carta = new Carta(token[0], token[1]);
				cartasQuemadas.add(carta);
				pos = pCombos.calculaPosicionparaBorrar(carta.getCodigo(), carta.getPalo());
				pCombos.setUsada(pos, false);
			}	
		}
		
		
		
		/* Primero eliminamos de la baraja las cartas que tienen los jugadores */
//		for (int i = 0; i < manos.size(); i++) {
			int vueltas=0, vueltas2=0;
			if(manos.get(0).equalsIgnoreCase("random")){
				vueltas = 1;
			}
			else {
				combosJ1 = pCombos.parseaMano(manos.get(0));
				vueltas = combosJ1.size();
			}
			
			if(manos.get(1).equalsIgnoreCase("random")){
				vueltas2 = 1;
			}
			else {
				combosJ2 = pCombos.parseaMano(manos.get(1));
				vueltas2 = combosJ2.size();
			}
			
			for (int j = 0; j < vueltas; j++) {
				
				/* Calculamos el combo del jugador en base al
				 * string que nos pasen */
				if(!manos.get(0).equalsIgnoreCase("random")){
					comboJ1 = combosJ1.getCombo(j);
					
					pos1J1 = pCombos.calculaPosicionparaBorrar(comboJ1.getCarta1().getCodigo(), comboJ1.getCarta1().getPalo());
					pos2J1 = pCombos.calculaPosicionparaBorrar(comboJ1.getCarta2().getCodigo(), comboJ1.getCarta2().getPalo());
					
					pCombos.setUsada(pos1J1, false);
					pCombos.setUsada(pos2J1, false);
				}
				
				for (int i = 0; i < vueltas2; i++) {				
					
						
					if(!manos.get(1).equalsIgnoreCase("random")){
						comboJ2 = combosJ2.getCombo(i);
						
						pos1J2 = pCombos.calculaPosicionparaBorrar(comboJ2.getCarta1().getCodigo(), comboJ2.getCarta1().getPalo());
						pos2J2 = pCombos.calculaPosicionparaBorrar(comboJ2.getCarta2().getCodigo(), comboJ2.getCarta2().getPalo());
						
						pCombos.setUsada(pos1J2, false);
						pCombos.setUsada(pos2J2, false);
					}
					
					/* Comparar las cartas entre los combos */
					condicion = false;
					if(!manos.get(0).equalsIgnoreCase("random") && !manos.get(1).equalsIgnoreCase("random")){
						condicion = ((comboJ1.getCarta1().getCodigo() == comboJ2.getCarta1().getCodigo()) && (comboJ1.getCarta1().getPalo() == comboJ2.getCarta1().getPalo()))
								|| ((comboJ1.getCarta1().getCodigo() == comboJ2.getCarta2().getCodigo()) && (comboJ1.getCarta1().getPalo() == comboJ2.getCarta2().getPalo()))
								|| ((comboJ1.getCarta2().getCodigo() == comboJ2.getCarta1().getCodigo()) && (comboJ1.getCarta2().getPalo() == comboJ2.getCarta1().getPalo()))
								|| ((comboJ1.getCarta2().getCodigo() == comboJ2.getCarta2().getCodigo()) && (comboJ1.getCarta2().getPalo() == comboJ2.getCarta2().getPalo()));
					}
					
					/* Comparamos las cartas quemadas con las de los combos */
					k=0;
					condicion2 = false;
					condicion4 = false;
					while(k < cartasQuemadas.size() && !condicion2 && !condicion4) {
						
						/* Ninguna de las manos son random */
						if(!manos.get(0).equalsIgnoreCase("random") && !manos.get(1).equalsIgnoreCase("random")){
							condicion2 = ((cartasQuemadas.get(k).getCodigo() == comboJ1.getCarta1().getCodigo()) && (cartasQuemadas.get(k).getPalo() == comboJ1.getCarta1().getPalo()))
									|| ((cartasQuemadas.get(k).getCodigo() == comboJ1.getCarta2().getCodigo()) && (cartasQuemadas.get(k).getPalo() == comboJ1.getCarta2().getPalo()))
									|| ((cartasQuemadas.get(k).getCodigo() == comboJ2.getCarta1().getCodigo()) && (cartasQuemadas.get(k).getPalo() == comboJ2.getCarta1().getPalo()))
									|| ((cartasQuemadas.get(k).getCodigo() == comboJ2.getCarta2().getCodigo()) && (cartasQuemadas.get(k).getPalo() == comboJ2.getCarta2().getPalo()));
						}
						/* Mano 2 es random pero mano 1 no */
						else if(manos.get(1).equalsIgnoreCase("random") && !manos.get(0).equalsIgnoreCase("random")){
							condicion4 = ((cartasQuemadas.get(k).getCodigo() == comboJ1.getCarta1().getCodigo()) && (cartasQuemadas.get(k).getPalo() == comboJ1.getCarta1().getPalo()))
									|| ((cartasQuemadas.get(k).getCodigo() == comboJ1.getCarta2().getCodigo()) && (cartasQuemadas.get(k).getPalo() == comboJ1.getCarta2().getPalo())); 
						}
						/* Mano 1 es random pero mano 2 no */
						else if(manos.get(0).equalsIgnoreCase("random") && !manos.get(1).equalsIgnoreCase("random")) {
							condicion2 = ((cartasQuemadas.get(k).getCodigo() == comboJ2.getCarta1().getCodigo()) && (cartasQuemadas.get(k).getPalo() == comboJ2.getCarta1().getPalo()))
									|| ((cartasQuemadas.get(k).getCodigo() == comboJ2.getCarta2().getCodigo()) && (cartasQuemadas.get(k).getPalo() == comboJ2.getCarta2().getPalo()));
						}
						k++;
					}
					
					/* Comparamos las cartas del board con las de los combos */
					k=0;
					condicion3 = false;
					condicion5 = false;
					while(k < cartasBoard.size() && !condicion3) {
						
						/* Ninguna de las manos son random */
						if(!manos.get(0).equalsIgnoreCase("random") && !manos.get(1).equalsIgnoreCase("random")){
							condicion3 = ((cartasBoard.get(k).getCodigo() == comboJ1.getCarta1().getCodigo()) && (cartasBoard.get(k).getPalo() == comboJ1.getCarta1().getPalo()))
										|| ((cartasBoard.get(k).getCodigo() == comboJ1.getCarta2().getCodigo()) && (cartasBoard.get(k).getPalo() == comboJ1.getCarta2().getPalo()))
										|| ((cartasBoard.get(k).getCodigo() == comboJ2.getCarta1().getCodigo()) && (cartasBoard.get(k).getPalo() == comboJ2.getCarta1().getPalo()))
										|| ((cartasBoard.get(k).getCodigo() == comboJ2.getCarta2().getCodigo()) && (cartasBoard.get(k).getPalo() == comboJ2.getCarta2().getPalo()));
						}
						/* Mano 1 es random pero mano 2 no*/
						else if(manos.get(0).equalsIgnoreCase("random") && !manos.get(1).equalsIgnoreCase("random")){
							condicion5 = ((cartasBoard.get(k).getCodigo() == comboJ2.getCarta1().getCodigo()) && (cartasBoard.get(k).getPalo() == comboJ2.getCarta1().getPalo()))
									|| ((cartasBoard.get(k).getCodigo() == comboJ2.getCarta2().getCodigo()) && (cartasBoard.get(k).getPalo() == comboJ2.getCarta2().getPalo()));
						}
						/* Mano 2 es random pero mano 1 no */
						else if(manos.get(1).equalsIgnoreCase("random") && !manos.get(0).equalsIgnoreCase("random")){
							condicion3 = ((cartasBoard.get(k).getCodigo() == comboJ1.getCarta1().getCodigo()) && (cartasBoard.get(k).getPalo() == comboJ1.getCarta1().getPalo()))
									|| ((cartasBoard.get(k).getCodigo() == comboJ1.getCarta2().getCodigo()) && (cartasBoard.get(k).getPalo() == comboJ1.getCarta2().getPalo()));
						}
						
						k++;
					}
					
					if(!condicion && !condicion2 && !condicion3 && !condicion4 && !condicion5) {
					
						for (k = 0; k < 7000; k++) {
							/* Generar combinaciones aleatorias */
							manoAleatoria = this.pCombos.generaCombinaciones(5-n);
							
							/* Añadimos las cartas del board */
							if(cartasBoard.size() >= 1){
								for (int x = 0; x < cartasBoard.size(); x++) {
									manoAleatoria.setMano(cartasBoard.get(x));
								}
							}
							
							/* Generamos la mano para J1 */
							// si el string es random hay que generar 7-n cartaspara este jugador
							if(manos.get(0).equalsIgnoreCase("random")) {
								mAleatoriaJ1 = this.pCombos.generaCombinaciones(7-n);
								jug1.setJugada(mAleatoriaJ1.toString());
								jug1.parseJugada();
							}
							else{
								manoAleatoria.setMano(comboJ1.getCarta1());
								manoAleatoria.setMano(comboJ1.getCarta2());
								
								jug1.setJugada(manoAleatoria.toString());
								
								jug1.parseJugada();
								
								/* Eliminamos de la mano las cartas del J1 */
								manoAleatoria.deleteCarta(comboJ1.getCarta1().toString());
								manoAleatoria.deleteCarta(comboJ1.getCarta2().toString());
							}
							
							
							/* Generamos la mano para J2 */
							if(manos.get(1).equalsIgnoreCase("random")) {
								mAleatoriaJ2 = this.pCombos.generaCombinaciones(7-n);
								jug2.setJugada(mAleatoriaJ2.toString());
								jug2.parseJugada();
							}
							else{
								manoAleatoria.setMano(comboJ2.getCarta1());
								manoAleatoria.setMano(comboJ2.getCarta2());
								
								jug2.setJugada(manoAleatoria.toString());
								
								jug2.parseJugada();
								
								/* Eliminamos de la mano las cartas del J2 */
								manoAleatoria.deleteCarta(comboJ2.getCarta1().toString());
								manoAleatoria.deleteCarta(comboJ2.getCarta2().toString());
							}
							
							/* Calculamos las mejores jugadas de cada jugador */
							jug1.setMejorJugada(this.pJugadas.parse(jug1.getMano()));
							jug2.setMejorJugada(this.pJugadas.parse(jug2.getMano()));
							
							
							/* Ordenamos los jugadores de mejor a peor jugada */
							this.comJugadas.burbuja(jugadores, 2);
							
							/* Si ha ganado el jugador 1 */
							if(jugadores.get(0).getNumJugador() == 1) {
								this.ganadosJ1++;
							}
							else {
								this.ganadosJ2++;
							}
							
							
						}
					}
					
					if(!manos.get(1).equalsIgnoreCase("random")){
						pCombos.setUsada(pos1J2, true);
						pCombos.setUsada(pos2J2, true);
					}
							
				}
				if(!manos.get(0).equalsIgnoreCase("random")){
					pCombos.setUsada(pos1J1, true);
					pCombos.setUsada(pos2J1, true);
				}
			}	
//		}
		
		System.out.println("Ganador 1: " + ganadosJ1);
		System.out.println("Ganador 2: " + ganadosJ2);
		double m = ganadosJ1+ganadosJ2;
		time_end = System.currentTimeMillis();
		System.out.println("Tiempo transcurrido: "+ ( time_end - time_start ) +" milisegundos");
		System.out.println("Manos calculadas: " + m);
		StringBuilder cad = new StringBuilder();
		cad.append("Manos ganadas del J1: ");
		cad.append(Double.toString(ganadosJ1));
		cad.append("\n");
		cad.append("Manos ganadas del J2: ");
		cad.append(Double.toString(ganadosJ2));
		cad.append("\n");
		cad.append("Manos totales generadas: ");
		cad.append(Double.toString(m));
		cad.append("\n");
		cad.append("Tiempo transcurrido: ");
		long time = time_end -time_start;
		cad.append(Long.toString(time));
		cad.append(" milisegundos");
		cad.append("\n");
		
		
		
		
		
		//cad += "Ganador 1: " + ganadosJ1 + "\n";
		//cad += "Ganador 2: " + ganadosJ2 + "\n";
		//cad += "Manos calculadas: " + m + "\n";
		//panel.muestraResultados(ganadosJ1, ganadosJ2);
		setTextPanel("");
		setTextPanel(cad.toString());
	}
	
	
	public double calcularEquity(int n) {
		
		if(n == 0) {
			return (ganadosJ1/(ganadosJ1+ganadosJ2))*100;
		}
		else
			return (ganadosJ2/(ganadosJ1+ganadosJ2))*100;
		
	}
	
	
	
	
	public void parseaCombo(ArrayList <String> manos) {
		
		ArrayList <Combos> combos = new ArrayList <Combos>();
		ArrayList <Jugador> jugadores = new ArrayList <Jugador>();
		Combos tmpC;
		Mano tmpM;
		Combo combo;
		int cont=0;
		char[] token;
		
		/* Generamos los combos para todos los jugadores */
		for (int i = 0; i < manos.size(); i++) {
		
			if(!manos.get(i).equals("")) {
				combos.add(this.pCombos.parseaMano(manos.get(i)));
				jugadores.add(new Jugador(i));
			}
		}
		
		
		/* Para cada mano d ela pila */
		for (int j = 0; j < pilaManos.size(); j++) {
			
			/* Cogemos una mano de la pila */
			tmpM = this.pilaManos.getMano(j);
			
			/* Asigno la pila de jugadas a cada jugador */
			for (int k = 0; k < jugadores.size(); k++) {
				
				/* Combos correspondientes al jugador */
				tmpC = combos.get(k);
				
				/* Segun el numero de combos que tenga el cugador */
				for (int i = 0; i < tmpC.size(); i++) {
	
					/* Cojo el primer combo del array de combos del jugador */
					combo = tmpC.getCombo(i);
		
					/* A cada mano de la pila le añado las cartas del combo */									
					tmpM.setMano(combo.getCarta1());
					tmpM.setMano(combo.getCarta2());
					
					/* Ordeno la mano */
					tmpM.ordenaMano(0, tmpM.getMano().size()-1);
						
					
					/* Le asigno la mano a la pila de manos del jugador
					 * Tendra tantas manos como combos y manos en la pila haya (Total = combos x manos del a pila)
					 * */
					jugadores.get(k).addManoPila(tmpM.toString());
					
					
					/* Vuelvo a dejar la mano original leida de la pila */
					tmpM.deleteCarta(combo.getCarta1().toString());
					tmpM.deleteCarta(combo.getCarta2().toString());
					
					
//					System.out.println(tmpC.toString() + " " + jugadores.get(k).getManoPila(cont));
					
					cont++;
				}

			}
		}
		
		
		/* Calculamos las mejores manos para todas las manos de todos los jugadores */
		for (int i = 0; i < jugadores.size(); i++) {
			
			cont = 0;
			
			for (int j = 0; j < jugadores.get(i).getContManos(); j++) {
				
				Mano mano = new Mano();
				
				token = jugadores.get(i).getManoPila(j).toCharArray();
				
				mano.setMano(new Carta(token[0], token[1]));
				mano.setMano(new Carta(token[2], token[3]));
				mano.setMano(new Carta(token[4], token[5]));
				mano.setMano(new Carta(token[6], token[7]));
				mano.setMano(new Carta(token[8], token[9]));
				mano.setMano(new Carta(token[10], token[11]));
				mano.setMano(new Carta(token[12], token[13]));
								
				jugadores.get(i).addMejorMano(this.pJugadas.parse(mano));
				
				System.out.println(jugadores.get(i).getMejoresManos(cont).toString());
				
				cont++;
			}
			
		}
		
		/* Comparamos las mejores jugadas de todos los jugadores */

	}
	
	
	
	public void evaluaRango(String mano, String pos, String accion){
		// parsera el fichero y devolver los string con los datos
		String[] salida = new String[4];
		this.pRankings.setRango(this.rankingActivo.toString());
		salida[0] = this.rankingActivo.toString();
		this.pRankings.setManoJugada(mano);
		salida[1] = mano;
		this.pRankings.setPosicion(pos);
		salida[2] = pos;
		this.pRankings.setOR(accion);
		salida[3] = accion;
		this.pRankings.notifyJugadaEvaluada(salida, this.pRankings.Resultado());
	}
	
	
	public void setRanking(int opcion) {
		if(opcion == 1) {
			this.rankings[0].setrObserver(this.rankingActivo.getrObserver());
			this.rankingActivo = this.rankings[0];			
		}
		else if(opcion == 2) {
			this.rankings[1].setrObserver(this.rankingActivo.getrObserver());
			this.rankingActivo = this.rankings[1];
		}
		else if(opcion == 3) {
			this.rankings[2].setrObserver(this.rankingActivo.getrObserver());
			this.rankingActivo = this.rankings[2];
		}
		else if(opcion == 4) {
			this.rankings[3].setrObserver(this.rankingActivo.getrObserver());
			this.rankingActivo = this.rankings[3];
		}
		else if(opcion == 5) {
			this.rankings[4].setrObserver(this.rankingActivo.getrObserver());
			this.rankingActivo = this.rankings[4];
		}
			
	}
	
	public Ranking getRanking() {
		return rankingActivo;
	}
	
	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}
	
	public PilaPosiciones parse(String rango) {
		return this.pRangos.parseRangos(rango);
	}
	
	public boolean dimeBroadway(String cartas) {
		return this.pRangos.dimeBroadway(cartas);
	}

	
	
	// Metodos para los Observers
	public void addRangoObserver(RangoObserver obs){
		this.pRangos.addObserver(obs);
	}
	
	public void addRankingObserver(RankingObserver obs){
		this.pRankings.addObserver(obs);
		this.rankingActivo.addObserver(obs);
	}
	
	
	public void nuevoRango(String rango) {
		this.pRangos.notifyHayRango(rango);
	}
	
	public void nuevoranking(int porcentaje) {
		this.rankingActivo.notifyNewRanking(this.rankingActivo.getPosiciones(porcentaje));
	}
	
	public void pintaTodo(int porcentaje) {
		this.rankingActivo.notifyNewRanking(this.rankingActivo.getPosicionesSlider(porcentaje));
	}
	
	public void nuevorankingSlider(int porcentaje) {
		this.rankingActivo.notifyNewRanking(this.rankingActivo.getPosicionesSlider(porcentaje));
	}
	
	public void damePosiciones(int opcion) {
		this.pRangos.damePosicoines(opcion);
	}
	
	public void cleanGrid() {
		this.pRangos.notifyClean();
	}
	
	public void dameBroadways() {
		this.pRangos.notifyBroadways();
	}
	
	public void addSeleccionado(String selec) {
		this.pRankings.addSeleccionado(selec);
	}
	
}
