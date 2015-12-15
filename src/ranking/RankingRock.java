
package ranking;
import java.util.Vector;

import main.PilaPosiciones;
import main.Posicion;
import observers.RankingObserver;

public class RankingRock implements Ranking{
	private Posicion[] vecPosicion;
	private PilaPosiciones pila;
	private int value;
	private Vector<RankingObserver> rObserver;
	
	public PilaPosiciones getPosiciones(int posicion){
		this.value = 7;
		for (int i = 0; i < this.value; i++) {
			this.pila.addPosicion(this.vecPosicion[i].getColumna(), this.vecPosicion[i].getFila());
		}
		return this.pila;
	}
	
	public RankingRock(){
		this.pila = new PilaPosiciones();
		this.value = 0;
		this.rObserver = new Vector<RankingObserver>();
		this.vecPosicion = new Posicion[7];
		rellenaArray();
	}
	
	
	public void rellenaArray(){
		
		vecPosicion[0]= new Posicion(0,0);
		vecPosicion[1]= new Posicion(1,1);
		vecPosicion[2]= new Posicion(0,1);
		vecPosicion[3]= new Posicion(1,0);
		vecPosicion[4]= new Posicion(2,0);
		vecPosicion[5]= new Posicion(2,2);
		vecPosicion[6]= new Posicion(3,3);//Rango de apertura en todos
	}
	
	public void addObserver(RankingObserver obs) {
		this.rObserver.add(obs);
	}
	
	public void notifyNewRanking(PilaPosiciones pila) {
		for (RankingObserver o : this.rObserver){
			o.hayRanking(pila);
		}
	}

	@Override
	public Vector<RankingObserver> getrObserver() {
		// TODO Auto-generated method stub
		return this.rObserver;
	}

	@Override
	public void setrObserver(Vector<RankingObserver> rObserver) {
		// TODO Auto-generated method stub
		this.rObserver = rObserver;
	}

	@Override
	public PilaPosiciones getPosicionesSlider(int porcentaje) {
		// TODO Auto-generated method stub
		return this.pila;
	}
	
	public String toString() {
		return "Rock";
	}
	

}
