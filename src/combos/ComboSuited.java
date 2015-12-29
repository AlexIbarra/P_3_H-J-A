package combos;

import java.util.ArrayList;

import carta.Carta;
import carta.Combo;

public class ComboSuited implements Combos{
	
	
	private ArrayList <Combo> combo = new ArrayList <Combo>();
	private int contador;
	
	
	public ComboSuited()
	{
		
	}
	public ComboSuited(char num1, char num2)
	{
//		char[] palos = {'p','h','s','d'};
//		Carta carta1;
//		Carta carta2;
//		for(int i = 0; i < 4; i++)
//		{
//			carta1 = new Carta(num1,palos[i]);
//			carta2 = new Carta(num2, palos[i]);
//			combo.add(new Combo (carta1, carta2)); 
//		}
		
		this.contador = 4;
		
		combo.add(new Combo (new Carta (num1, 'h'), new Carta (num2, 'h')));
		combo.add(new Combo (new Carta (num1, 'c'), new Carta (num2, 'c')));
		combo.add(new Combo (new Carta (num1, 'd'), new Carta (num2, 'd')));
		combo.add(new Combo (new Carta (num1, 's'), new Carta (num2, 's')));
	}

	@Override
	public Combos parsea(char[] comboParsea) {
		Combos combo = null;
		if(comboParsea.length == 3)
		{
			if(comboParsea[2]=='s')
			{
				combo = new ComboSuited(comboParsea[0],comboParsea[1]);
			}
		}
			
		return combo;
	}
	
	public Combo getCombo(int i) {
		Combo combo;
		
		combo = this.combo.get(i);
//		this.combo.remove(this.contador-1);
//		this.contador--;
		
		return combo;
	}
	
	
	public String toString() {
		return "ComboSuited";
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.contador;
	}
}
