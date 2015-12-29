package controlador;

import java.util.ArrayList;

import carta.Carta;
import carta.Combo;
import carta.Mano;
import combos.Combos;
import combos.ParserCombos;
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
	private ParserJugadas pJugadas;
	private ParserManos pManos;
	private ParserCombos pCombos;
	private PilaManos pilaManos;
	private Ranking rankings[];
	private Ranking rankingActivo;
	private RankingChubukov rChurukov;
	private String rango;
	
	

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
		
	}
	
	
	
	
	public void generaCombinaciones() {
		
		for (int i = 0; i < 3; i++) {
			this.pilaManos.addMano(this.pCombos.generaCombinaciones());
		}
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
			
			cont = jugadores.get(i).getContManos();
			
			for (int j = 0; j < cont; j++) {
				
				Mano mano = new Mano();
				
				token = jugadores.get(i).getManoPila(j).toCharArray();
				
				mano.setMano(new Carta(token[0], token[1]));
				mano.setMano(new Carta(token[2], token[3]));
				mano.setMano(new Carta(token[4], token[5]));
				mano.setMano(new Carta(token[6], token[7]));
				mano.setMano(new Carta(token[8], token[9]));
				mano.setMano(new Carta(token[10], token[11]));
				mano.setMano(new Carta(token[12], token[14]));
								
				jugadores.get(i).addMejorMano(this.pJugadas.parse(mano));
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
