package ranking;

import java.util.Vector;

import main.PilaPosiciones;
import observers.RankingObserver;

public interface Ranking {
	public PilaPosiciones getPosiciones(int posicion);
	
	public PilaPosiciones getPosicionesSlider(int porcentaje);
	
	public void addObserver(RankingObserver obs);
	
	public void notifyNewRanking(PilaPosiciones pila);
	
	public void rellenaArray();
	
	public Vector<RankingObserver> getrObserver();
	
	public void setrObserver(Vector<RankingObserver> rObserver);
}
