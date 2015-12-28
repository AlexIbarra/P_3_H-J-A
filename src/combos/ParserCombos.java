package combos;

import carta.Mano;

public class ParserCombos {
	
	
	private static Combos[] combos;
	
	
	
	public ParserCombos (){
		
		combos = new Combos[3];
		combos[0] = new ComboOffSuited();
		combos[1] = new ComboSuited();
		combos[2] = new ComboPareja();		
	}
	
	static public Combos parseaMano(String cadenas){
		
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
	
	public Mano generaCombinaciones() {
		
		
		return null;
	}
}
