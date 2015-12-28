package combos;

public class ParserCombos {
private static Combos[] combos;
	
	public ParserCombos (){
		
		combos = new Combos[3];
		combos[0] = new ComboOffSuited();
		combos[1] = new ComboSuited();
		combos[2] = new ComboPareja();		
	}
	
	static public Combos parseaComando(String cadenas){
		
        Combos c = null;
		char par [] = cadenas.toCharArray();
		for(int i=0;i<combos.length;i++){
        	
        	if(combos[i].parsea(par)!=null) c = combos[i].parsea(par);
			
		}		
		return c;
	}
}
