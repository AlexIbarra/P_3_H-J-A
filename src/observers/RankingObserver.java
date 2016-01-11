package observers;

import java.util.Vector;

import main.PilaPosiciones;

public interface RankingObserver {
	
	public void hayRanking(PilaPosiciones pila);
	
	public void addObserver(RankingObserver obs);
	
	public void jugadaEvaluada(String[] salida, boolean res);
	
	public void haySeleccionado(Vector<String> select);
	


	public void muestraResultados(double ganadosJ1, double ganadosJ2);

}
