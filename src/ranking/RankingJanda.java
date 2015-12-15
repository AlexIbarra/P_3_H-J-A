
package ranking;
import java.util.Vector;

import main.PilaPosiciones;
import main.Posicion;
import observers.RankingObserver;

public class RankingJanda implements Ranking{
	private Posicion[] vecPosicion;
	private PilaPosiciones pila;
	private int value;
	private Vector<RankingObserver> rObserver;
	
	public PilaPosiciones getPosiciones(int posicion){
		
		if(posicion == 0) //UTG
		{
			this.value = 24; // 34
		}
		else if (posicion == 1) //MP
		{
			this.value = 30; // 43
		}
		else if (posicion == 2) //CO
		{
			this.value = 41; // 58
		}
		else if (posicion == 3)// BTN
		{
			this.value = 80; // 96
		}
		else if (posicion == 4) // SB
		{
			this.value = 62;
		}
		
		
		
		for (int i = 0; i < this.value; i++) {
			this.pila.addPosicion(this.vecPosicion[i].getColumna(), this.vecPosicion[i].getFila());
		}
		return this.pila;
	}
	
	public RankingJanda(){
		this.pila = new PilaPosiciones();
		this.value = 0;
		this.rObserver = new Vector<RankingObserver>();
		this.vecPosicion = new Posicion[96];
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
		vecPosicion[2]= new Posicion(1,0);
		vecPosicion[3]= new Posicion(2,2);
		vecPosicion[4]= new Posicion(0,1);
		vecPosicion[5]= new Posicion(3,3);
		vecPosicion[6]= new Posicion(2,0);
		vecPosicion[7]= new Posicion(4,4);
		vecPosicion[8]= new Posicion(0,2);
		vecPosicion[9]= new Posicion(5,5);
		vecPosicion[10]= new Posicion(3,0);
		vecPosicion[11]= new Posicion(6,6);
		vecPosicion[12]= new Posicion(4,0);
		vecPosicion[13]= new Posicion(0,3);
		vecPosicion[14]= new Posicion(7,7);
		vecPosicion[15]= new Posicion(8,8);
		vecPosicion[16]= new Posicion(1,2);;
		vecPosicion[17]= new Posicion(9,9);
		vecPosicion[18]= new Posicion(8,0);
		vecPosicion[19]= new Posicion(2,1);
		vecPosicion[20]= new Posicion(10,10);
		vecPosicion[21]= new Posicion(3,1);
		vecPosicion[22]= new Posicion(4,1);
		vecPosicion[23]= new Posicion(3,2);
		vecPosicion[24]= new Posicion(4,2);
		vecPosicion[25]= new Posicion(4,3);
		vecPosicion[26]= new Posicion(5,3);
		vecPosicion[27]= new Posicion(5,4);
		vecPosicion[28]= new Posicion(11,11);
		vecPosicion[29]= new Posicion(6,5);
		vecPosicion[30]= new Posicion(7,6);
		vecPosicion[31]= new Posicion(8,7);
		vecPosicion[32]= new Posicion(9,8);//Rango de apertura UTG
		vecPosicion[33]= new Posicion(0,4);
		vecPosicion[34]= new Posicion(6,0);
		vecPosicion[35]= new Posicion(7,0);
		vecPosicion[36]= new Posicion(9,0);
		vecPosicion[37]= new Posicion(12,12);
		vecPosicion[38]= new Posicion(6,4);
		vecPosicion[39]= new Posicion(7,5);
		vecPosicion[40]= new Posicion(8,6);
		vecPosicion[41]= new Posicion(9,7);
		vecPosicion[42]= new Posicion(10,9);//Rango de apertura MP
		vecPosicion[43]= new Posicion(0,3);
		vecPosicion[44]= new Posicion(0,4);
		vecPosicion[45]= new Posicion(5,1);	
		vecPosicion[46]= new Posicion(6,1);
		vecPosicion[47]= new Posicion(7,1);
		vecPosicion[48]= new Posicion(5,2);
		vecPosicion[49]= new Posicion(6,2);
		vecPosicion[50]= new Posicion(8,1);
		vecPosicion[51]= new Posicion(8,0);
		vecPosicion[52]= new Posicion(10,0);
		vecPosicion[53]= new Posicion(11,0);
		vecPosicion[54]= new Posicion(12,0);
		vecPosicion[55]= new Posicion(7,2);
		vecPosicion[56]= new Posicion(6,3);
		vecPosicion[57]= new Posicion(0,5);//Rango de Apertura CO
		vecPosicion[58]= new Posicion(0,6);
		vecPosicion[59]= new Posicion(0,7);
		vecPosicion[60]= new Posicion(1,4);
		vecPosicion[61]= new Posicion(1,5);
		vecPosicion[62]= new Posicion(2,4);
		vecPosicion[63]= new Posicion(2,5);
		vecPosicion[64]= new Posicion(1,11);
		vecPosicion[65]= new Posicion(3,4);
		vecPosicion[66]= new Posicion(3,5);
		vecPosicion[67]= new Posicion(4,5);
		vecPosicion[68]= new Posicion(5,6);
		vecPosicion[69]= new Posicion(6,7);
		vecPosicion[70]= new Posicion(9,1);
		vecPosicion[71]= new Posicion(10,1);
		vecPosicion[72]= new Posicion(11,1);
		vecPosicion[73]= new Posicion(12,1);
		vecPosicion[74]= new Posicion(8,2);
		vecPosicion[75]= new Posicion(9,2);
		vecPosicion[76]= new Posicion(10,2);
		vecPosicion[77]= new Posicion(7,3);
		vecPosicion[78]= new Posicion(7,4);//Rango de Apertura SB
		vecPosicion[79]= new Posicion(0,9);
		vecPosicion[80]= new Posicion(0,10);
		vecPosicion[81]= new Posicion(0,11);
		vecPosicion[82]= new Posicion(0,12);
		vecPosicion[83]= new Posicion(1,6);
		vecPosicion[84]= new Posicion(1,7);
		vecPosicion[85]= new Posicion(4,6);
		vecPosicion[86]= new Posicion(11,2);
		vecPosicion[87]= new Posicion(12,2);
		vecPosicion[88]= new Posicion(8,3);
		vecPosicion[89]= new Posicion(9,3);
		vecPosicion[90]= new Posicion(8,4);	
		vecPosicion[91]= new Posicion(8,5);
		vecPosicion[92]= new Posicion(9,6);
		vecPosicion[93]= new Posicion(10,7);
		vecPosicion[94]= new Posicion(11,10);
		vecPosicion[95]= new Posicion(11,10);//Rango de Apertura BTN
		}
	
	public String toString() {
		return "Janda";
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
//		this.value = (porcentaje * 169) / 100;
//		for (int i = 0; i < this.value; i++) {
//			this.pila.addPosicion(this.vecPosicion[i].getColumna(), this.vecPosicion[i].getFila());
//		}
		return this.pila;
	}

}
