
package ranking;

import java.util.Vector;

import main.PilaPosiciones;
import main.Posicion;
import observers.RankingObserver;

public class RankingChubukov implements Ranking {
	
	private Posicion[] vecPosicion;
	private PilaPosiciones pila;
	private int value;
	private Vector<RankingObserver> rObserver;
	
	

	public RankingChubukov(){
		this.pila = new PilaPosiciones();
		this.value = 0;
		this.rObserver = new Vector<RankingObserver>();
		this.vecPosicion = new Posicion[169];
		rellenaArray();
	}
	
	
	
	public PilaPosiciones getPosiciones(int posicion) {
//		this.value = (porcentaje * 169) / 100;
		
		if(posicion == 0) //UTG
		{
			this.value = 17; // 34
		}
		else if (posicion == 1) //MP
		{
			this.value = 32; // 43
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
			this.value = 100;
		}
		for (int i = 0; i < this.value; i++) {
			this.pila.addPosicion(this.vecPosicion[i].getColumna(), this.vecPosicion[i].getFila());
		}
		return this.pila;
	}
	
	public void rellenaArray(){
		
		vecPosicion[0] = new Posicion(0,0);
		vecPosicion[1] = new Posicion(1,1);
		vecPosicion[2] = new Posicion(0,1);
		vecPosicion[3] = new Posicion(2,2);
		vecPosicion[4] = new Posicion(1,0);
		vecPosicion[5] = new Posicion(3,3);
		vecPosicion[6] = new Posicion(0,2);
		vecPosicion[7] = new Posicion(4,4);
		vecPosicion[8] = new Posicion(2,0);
		vecPosicion[9] = new Posicion(5,5);
		vecPosicion[10] = new Posicion(0,3);
		vecPosicion[11] = new Posicion(6,6);
		vecPosicion[12] = new Posicion(0,4);
		vecPosicion[13] = new Posicion(3,0);
		vecPosicion[14] = new Posicion(7,7);
		vecPosicion[15] = new Posicion(8,8);
		vecPosicion[16] = new Posicion(4,0);
		vecPosicion[17] = new Posicion(5,0);
		vecPosicion[18] = new Posicion(9,9);
		vecPosicion[19] = new Posicion(0,6);
		vecPosicion[20] = new Posicion(1,2);
		vecPosicion[21] = new Posicion(10,10);
		vecPosicion[22] = new Posicion(0,5);
		vecPosicion[23] = new Posicion(0,7);
		vecPosicion[24] = new Posicion(1,3);
		vecPosicion[25] = new Posicion(0,9);
		vecPosicion[26] = new Posicion(6,0);
		vecPosicion[27] = new Posicion(0,8);
		vecPosicion[28] = new Posicion(0,10);
		vecPosicion[29] = new Posicion(11,11);
		vecPosicion[30] = new Posicion(1,4);
		vecPosicion[31] = new Posicion(7,0);
		vecPosicion[32] = new Posicion(0,11);
		vecPosicion[33] = new Posicion(2,1);
		vecPosicion[34] = new Posicion(0,12);
		vecPosicion[35] = new Posicion(9,0);
		vecPosicion[36] = new Posicion(8,0);
		vecPosicion[37] = new Posicion(10,0);
		vecPosicion[38] = new Posicion(3,1);
		vecPosicion[39] = new Posicion(2,3);
		vecPosicion[40] = new Posicion(11,0);
		vecPosicion[41] = new Posicion(12,12);
		vecPosicion[42] = new Posicion(1,5);
		vecPosicion[43] = new Posicion(12,0);
		vecPosicion[44] = new Posicion(4,1);
		vecPosicion[45] = new Posicion(2,4);	
		vecPosicion[46] = new Posicion(6,1);
		vecPosicion[47] = new Posicion(1,7);
		vecPosicion[48] = new Posicion(3,4);
		vecPosicion[49] = new Posicion(5,1);
		vecPosicion[50] = new Posicion(1,8);
		vecPosicion[51] = new Posicion(3,2);
		vecPosicion[52] = new Posicion(2,5);
		vecPosicion[53] = new Posicion(1,9);
		vecPosicion[54] = new Posicion(1,6);
		vecPosicion[55] = new Posicion(1,10);
		vecPosicion[56] = new Posicion(4,2);
		vecPosicion[57] = new Posicion(7,1);
		vecPosicion[58] = new Posicion(1,11);
		vecPosicion[59] = new Posicion(1,12);
		vecPosicion[60] = new Posicion(2,8);
		vecPosicion[61] = new Posicion(8,1);
		vecPosicion[62] = new Posicion(3,5);
		vecPosicion[63] = new Posicion(9,1);
		vecPosicion[64] = new Posicion(5,2);
		vecPosicion[65] = new Posicion(4,3);
		vecPosicion[66] = new Posicion(10,1);
		vecPosicion[67] = new Posicion(2,7);
		vecPosicion[68] = new Posicion(4,5);
		vecPosicion[69] = new Posicion(2,6);
		vecPosicion[70] = new Posicion(11,1);
		vecPosicion[71] = new Posicion(3,6);
		vecPosicion[72] = new Posicion(2,9);
		vecPosicion[73] = new Posicion(12,1);
		vecPosicion[74] = new Posicion(6,2);
		vecPosicion[75] = new Posicion(2,10);
		vecPosicion[76] = new Posicion(5,3);
		vecPosicion[77] = new Posicion(2,11);
		vecPosicion[78] = new Posicion(6,4);
		vecPosicion[79] = new Posicion(3,7);
		vecPosicion[80] = new Posicion(7,2);
		vecPosicion[81] = new Posicion(2,12);
		vecPosicion[82] = new Posicion(8,2);
		vecPosicion[83] = new Posicion(5,6);
		vecPosicion[84] = new Posicion(9,2);
		vecPosicion[85] = new Posicion(6,3);
		vecPosicion[86] = new Posicion(5,4);
		vecPosicion[87] = new Posicion(3,8);
		vecPosicion[88] = new Posicion(4,7);
		vecPosicion[89] = new Posicion(3,9);	
		vecPosicion[90] = new Posicion(10,2);
		vecPosicion[91] = new Posicion(3,10);
		vecPosicion[92] = new Posicion(7,3);
		vecPosicion[93] = new Posicion(11,2);
		vecPosicion[94] = new Posicion(5,7);
		vecPosicion[95] = new Posicion(4,6);
		vecPosicion[96] = new Posicion(3,11);
		vecPosicion[97] = new Posicion(4,8);
		vecPosicion[98] = new Posicion(12,2);
		vecPosicion[99] = new Posicion(3,12);
		vecPosicion[100] = new Posicion(6,7);
		vecPosicion[101] = new Posicion(8,3);
		vecPosicion[102] = new Posicion(6,5);
		vecPosicion[103] = new Posicion(7,4);
		vecPosicion[104] = new Posicion(5,8);
		vecPosicion[105] = new Posicion(9,3);
		vecPosicion[106] = new Posicion(4,9);
		vecPosicion[107] = new Posicion(4,10);
		vecPosicion[108] = new Posicion(6,8);
		vecPosicion[109] = new Posicion(10,3);
		vecPosicion[110] = new Posicion(8,4);
		vecPosicion[111] = new Posicion(7,5);
		vecPosicion[112] = new Posicion(4,11);
		vecPosicion[113] = new Posicion(7,8);
		vecPosicion[114] = new Posicion(5,9);
		vecPosicion[115] = new Posicion(11,3);
		vecPosicion[116] = new Posicion(4,12);
		vecPosicion[117] = new Posicion(7,6);
		vecPosicion[118] = new Posicion(6,9);
		vecPosicion[119] = new Posicion(8,5);
		vecPosicion[120] = new Posicion(9,4);
		vecPosicion[121] = new Posicion(12,3);
		vecPosicion[122] = new Posicion(7,9);
		vecPosicion[123] = new Posicion(5,10);
		vecPosicion[124] = new Posicion(10,4);
		vecPosicion[125] = new Posicion(8,9);
		vecPosicion[126] = new Posicion(8,6);
		vecPosicion[127] = new Posicion(5,11);
		vecPosicion[128] = new Posicion(6,10);
		vecPosicion[129] = new Posicion(9,5);
		vecPosicion[130] = new Posicion(11,4);
		vecPosicion[131] = new Posicion(8,7);
		vecPosicion[132] = new Posicion(5,12);
		vecPosicion[133] = new Posicion(7,10);	
		vecPosicion[134] = new Posicion(9,10);
		vecPosicion[135] = new Posicion(12,4);
		vecPosicion[136] = new Posicion(9,6);
		vecPosicion[137] = new Posicion(8,10);
		vecPosicion[138] = new Posicion(6,11);
		vecPosicion[139] = new Posicion(10,5);
		vecPosicion[140] = new Posicion(9,7);
		vecPosicion[141] = new Posicion(6,12);
		vecPosicion[142] = new Posicion(7,11);
		vecPosicion[143] = new Posicion(11,5);
		vecPosicion[144] = new Posicion(9,8);
		vecPosicion[145] = new Posicion(9,11);
		vecPosicion[146] = new Posicion(8,11);
		vecPosicion[147] = new Posicion(10,6);
		vecPosicion[148] = new Posicion(12,5);
		vecPosicion[149] = new Posicion(10,11);
		vecPosicion[150] = new Posicion(10,7);
		vecPosicion[151] = new Posicion(7,12);
		vecPosicion[152] = new Posicion(10,9);
		vecPosicion[153] = new Posicion(10,8);
		vecPosicion[154] = new Posicion(9,12);
		vecPosicion[155] = new Posicion(8,12);		
		vecPosicion[156] = new Posicion(11,6);
		vecPosicion[157] = new Posicion(10,12);
		vecPosicion[158] = new Posicion(12,6);
		vecPosicion[159] = new Posicion(11,7);
		vecPosicion[160] = new Posicion(11,9);
		vecPosicion[161] = new Posicion(11,8);
		vecPosicion[162] = new Posicion(11,12);
		vecPosicion[163] = new Posicion(11,10);
		vecPosicion[164] = new Posicion(12,7);
		vecPosicion[165] = new Posicion(12,9);
		vecPosicion[166] = new Posicion(12,8);
		vecPosicion[167] = new Posicion(12,10);
		vecPosicion[168] = new Posicion(12,11);
	}
	
	public void addObserver(RankingObserver obs) {
		this.rObserver.add(obs);
	}
	
	public void notifyNewRanking(PilaPosiciones pila) {
		for (RankingObserver o : this.rObserver){
			o.hayRanking(pila);
		}
	}
	
	public Vector<RankingObserver> getrObserver() {
		return rObserver;
	}

	public void setrObserver(Vector<RankingObserver> rObserver) {
		this.rObserver = rObserver;
	}
	
	public String toString() {
		return "Sklansky-Chubukov";
	}

	@Override
	public PilaPosiciones getPosicionesSlider(int porcentaje) {
		this.value = (porcentaje * 169) / 100;
		for (int i = 0; i < this.value; i++) {
			this.pila.addPosicion(this.vecPosicion[i].getColumna(), this.vecPosicion[i].getFila());
		}
		return this.pila;
	}
}
