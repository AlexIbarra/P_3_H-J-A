
package ranking;
import java.util.Vector;

import main.PilaPosiciones;
import main.Posicion;
import observers.RankingObserver;

public class RankingTight implements Ranking{
	private Posicion[] vecPosicion;
	private PilaPosiciones pila;
	private int value;
	private Vector<RankingObserver> rObserver;
	
	public PilaPosiciones getPosiciones(int posicion){
		
		if(posicion == 0)
		{
			this.value = 4;
		}
		else if (posicion == 1)
		{
			this.value = 8;
		}
		else if (posicion == 2)
		{
			this.value = 12;
		}
		else if (posicion == 3)
		{
			this.value = 27;
		}
		else if (posicion == 4)
		{
			this.value = 22;
		}
		for (int i = 0; i < this.value; i++) {
			this.pila.addPosicion(this.vecPosicion[i].getColumna(), this.vecPosicion[i].getFila());
		}
		return this.pila;
	}
	
	public RankingTight(){
		this.pila = new PilaPosiciones();
		this.value = 0;
		this.rObserver = new Vector<RankingObserver>();
		this.vecPosicion = new Posicion[28];
		rellenaArray();
	}
	public void addObserver(RankingObserver obs) {
		this.rObserver.add(obs);
	}
	public void notifyNewRanking(PilaPosiciones pila) {
		for (RankingObserver o : this.rObserver){
			o.hayRanking(pila);
		}
	}
	
	public void rellenaArray(){
		
		vecPosicion[0]= new Posicion(0,0);
		vecPosicion[1]= new Posicion(1,1);
		vecPosicion[2]= new Posicion(0,1);
		vecPosicion[3]= new Posicion(1,0);
		vecPosicion[4]= new Posicion(2,2);//Rango de apertura en UTG
		vecPosicion[5]= new Posicion(2,0);
		vecPosicion[6]= new Posicion(3,3);
		vecPosicion[7]= new Posicion(3,0);
		vecPosicion[8]= new Posicion(2,1);//Rango de apertura en MP
		vecPosicion[9]= new Posicion(0,2);
		vecPosicion[10]= new Posicion(4,0);
		vecPosicion[11]= new Posicion(4,4);
		vecPosicion[12]= new Posicion(5,5);//Rango de apertura CO
		vecPosicion[13]= new Posicion(3,1);
		vecPosicion[14]= new Posicion(4,1);
		vecPosicion[15]= new Posicion(6,6);
		vecPosicion[16]= new Posicion(0,3);
		vecPosicion[17]= new Posicion(0,4);
		vecPosicion[18]= new Posicion(3,2);
		vecPosicion[19]= new Posicion(4,2);
		vecPosicion[20]= new Posicion(1,2);
		vecPosicion[21]= new Posicion(7,7);
		vecPosicion[22]= new Posicion(8,8);//Rango de apertura SB
		vecPosicion[23]= new Posicion(4,3);
		vecPosicion[24]= new Posicion(9,9);
		vecPosicion[25]= new Posicion(10,10);
		vecPosicion[26]= new Posicion(11,11);
		vecPosicion[27]= new Posicion(12,12);//Rango desde BTN
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
		return "Tight";
	}

}
