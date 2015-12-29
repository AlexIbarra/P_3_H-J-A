package combos;

import carta.Carta;
import carta.Mano;

public class ParserCombos {
	
	
	private static Combos[] combos;
	
	
	
	public ParserCombos (){
		
		combos = new Combos[3];
		combos[0] = new ComboOffSuited();
		combos[1] = new ComboSuited();
		combos[2] = new ComboPareja();		
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
	public Mano generaCombinaciones() {
		
		Mano mano = new Mano();
		mano.setMano(new Carta('2','h'));
		mano.setMano(new Carta('3','c'));
		mano.setMano(new Carta('4','s'));
		mano.setMano(new Carta('5','h'));
		mano.setMano(new Carta('6','d'));
		
		return mano;
	}
}
