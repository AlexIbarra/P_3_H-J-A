package combos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import carta.Carta;
import carta.Mano;

public class ParserCombos {
	
	
	private static Combos[] combos;
	private Carta[] baraja;
	private boolean[] estadoBaraja;
	private HashMap<Integer, String> valores;
	
	public ParserCombos (){
		baraja = new Carta[52];
		estadoBaraja = new boolean[52];
		combos = new Combos[3];
		combos[0] = new ComboOffSuited();
		combos[1] = new ComboSuited();
		combos[2] = new ComboPareja();		
	}
	
	/*private class Cartas{
		Carta carta;
		boolean usada;
		public Cartas(Carta c, boolean us){
			carta = c;
			usada = us;
			
		}
	}*/
	
	public void setBaraja(Carta carta) {
//		this.baraja.add(carta);
	}
	
	public void deleteCarta(Carta cartaBorrada) {
		int i=0;
		boolean eliminada=false;
		String carta = cartaBorrada.toString();
		while (i < baraja.length && !eliminada) {
			if(baraja[i].toString().equals(carta)) {
//				baraja.remove(i);
//				eliminada = true;
			}
			i++;
		}
	}
	
	public Carta[] getBaraja() {
		return this.baraja;
	}
	
	public Carta getCarta(int n) {
		return this.baraja[n];
	}
	
	public void setUsada(int i, boolean b) {
		baraja[i].setUsada(b);
		estadoBaraja[i] = b;
	}
	
	public void rellenarBaraja(){
		
		baraja[0]=  new Carta('A','d');
		estadoBaraja[0] = true;
		baraja[1]= new Carta('A','s');
		estadoBaraja[1] = true;
		baraja[2]= new Carta('A','h');
		estadoBaraja[2] = true;
		baraja[3]= new Carta('A','c');
		estadoBaraja[3] = true;
		baraja[4]= new Carta('2','d');
		estadoBaraja[4] = true;
		baraja[5]= new Carta('2','s');
		estadoBaraja[5] = true;
		baraja[6]= new Carta('2','h');
		estadoBaraja[6] = true;
		baraja[7]= new Carta('2','c');
		estadoBaraja[7] = true;
		baraja[8]= new Carta('3','d');
		estadoBaraja[8] = true;
		baraja[9]= new Carta('3','s');
		estadoBaraja[9] = true;
		baraja[10]= new Carta('3','h');
		estadoBaraja[10] = true;
		baraja[11]= new Carta('3','c');
		estadoBaraja[11] = true;
		baraja[12]= new Carta('4','d');
		estadoBaraja[12] = true;
		baraja[13]= new Carta('4','s');
		estadoBaraja[13] = true;
		baraja[14]= new Carta('4','h');
		estadoBaraja[14] = true;
		baraja[15]= new Carta('4','c');
		estadoBaraja[15] = true;
		baraja[16]= new Carta('5','d');
		estadoBaraja[16] = true;
		baraja[17]= new Carta('5','s');
		estadoBaraja[17] = true;
		baraja[18]= new Carta('5','h');
		estadoBaraja[18] = true;
		baraja[19]= new Carta('5','c');
		estadoBaraja[19] = true;
		baraja[20]= new Carta('6','d');
		estadoBaraja[20] = true;
		baraja[21]= new Carta('6','s');
		estadoBaraja[21] = true;
		baraja[22]= new Carta('6','h');
		estadoBaraja[22] = true;
		baraja[23]= new Carta('6','c');
		estadoBaraja[23] = true;
		baraja[24]= new Carta('7','d');
		estadoBaraja[24] = true;
		baraja[25]= new Carta('7','s');
		estadoBaraja[25] = true;
		baraja[26]= new Carta('7','h');
		estadoBaraja[26] = true;
		baraja[27]= new Carta('7','c');
		estadoBaraja[27] = true;
		baraja[28]= new Carta('8','d');
		estadoBaraja[28] = true;
		baraja[29]= new Carta('8','s');
		estadoBaraja[29] = true;
		baraja[30]= new Carta('8','h');
		estadoBaraja[30] = true;
		baraja[31]= new Carta('8','c');
		estadoBaraja[31] = true;		
		baraja[32]= new Carta('9','d');
		estadoBaraja[32] = true;
		baraja[33]= new Carta('9','s');
		estadoBaraja[33] = true;
		baraja[34]= new Carta('9','h');
		estadoBaraja[34] = true;
		baraja[35]= new Carta('9','c');
		estadoBaraja[35] = true;
		baraja[36]= new Carta('T','d');
		estadoBaraja[36] = true;
		baraja[37]= new Carta('T','s');
		estadoBaraja[37] = true;
		baraja[38]= new Carta('T','h');
		estadoBaraja[38] = true;
		baraja[39]= new Carta('T','c');
		estadoBaraja[39] = true;
		baraja[40]= new Carta('J','d');
		estadoBaraja[40] = true;
		baraja[41]= new Carta('J','s');
		estadoBaraja[41] = true;
		baraja[42]= new Carta('J','h');
		estadoBaraja[42] = true;
		baraja[43]= new Carta('J','c');
		estadoBaraja[43] = true;
		baraja[44]= new Carta('Q','d');
		estadoBaraja[44] = true;
		baraja[45]= new Carta('Q','s');
		estadoBaraja[45] = true;
		baraja[46]= new Carta('Q','h');
		estadoBaraja[46] = true;
		baraja[47]= new Carta('Q','c');
		estadoBaraja[47] = true;
		baraja[48]= new Carta('K','d');
		estadoBaraja[48] = true;
		baraja[49]= new Carta('K','s');
		estadoBaraja[49] = true;
		baraja[50]= new Carta('K','h');
		estadoBaraja[50] = true;
		baraja[51]= new Carta('K','c');
		estadoBaraja[51] = true;
	}
	
	
	public int calculaPosicionparaBorrar(int num, char p){
		int index = 0;
		if (num == 14 && p == 'd')
			index = 0;
		else if(num == 14 && p == 's')
			index = 1;
		else if (num == 14 && p == 'h')
			index = 2;
		else if (num == 14 && p == 'c')
			index = 3;
		else{
			if (p == 'd')
				index = (num-1)*4;
			else if(p == 's')
				index = (num-1)*4 + 1;
			else if (p == 'h')
				index = (num-1)*4 + 2;
			else if(p == 'c')
				index = (num-1)*4 +3 ;
		}
		return index;
	}
	
	public Combos parseaMano(String cadenas){
		
		int i=0;
		boolean salir=false;
        Combos c = null;
		char par [] = cadenas.toCharArray();
		while(i<combos.length && !salir){
        	
        	if((c = combos[i].parsea(par)) != null) 
        		salir =  true;
			i++;
		}		
		return c;
	}
	
	
	/* Metodo que se encarga de generar manos aleatorias de 5 cartas */
	public Mano generaCombinaciones(int n) {
		Random rand = new Random();
		int carta = 0;
		int i = 0;
		int posi[] = new int[n];
		Mano mano = new Mano();
		do {
			carta = rand.nextInt(baraja.length-1); //genero numero aleatorio
			if(estadoBaraja[carta] == true){
				mano.setMano(baraja[carta]); //añado a la mano la carta
				estadoBaraja[carta] = false;
				posi[i] = carta;
				i++;
			}
		}while(i != n);
		
		for(i=0; i<n; i++) {
			estadoBaraja[posi[i]] = true;
		}
		
		
		return mano;
	}

	public void vaciarBaraja() {
//		int tamaño = baraja.size();
//		for(int i = 0; i < tamaño; i++)
//		{
//			baraja.remove(i);
//		}
	}
	
	
}
