package combos;

import java.util.ArrayList;

import carta.Carta;
import carta.Combo;

public class ComboPareja implements Combos{
	
	private ArrayList <Combo> combo = new ArrayList <Combo>();
	
	
	
	public ComboPareja(char num1, char num2)
	{
//		char[] palos = {'p','h','s','d'};
//		Carta carta1;
//		Carta carta2;
		
		combo.add(new Combo (new Carta (num1, 'h'), new Carta (num2, 's')));
		combo.add(new Combo (new Carta (num1, 'h'), new Carta (num2, 'c')));
		combo.add(new Combo (new Carta (num1, 'h'), new Carta (num2, 'd')));
		combo.add(new Combo (new Carta (num1, 's'), new Carta (num2, 'c')));
		combo.add(new Combo (new Carta (num1, 's'), new Carta (num2, 'd')));
		combo.add(new Combo (new Carta (num1, 'c'), new Carta (num2, 'd')));
		
//		
//		for(int i = 0; i < 4; i++)
//		{
//			carta1 = new Carta(num1,palos[i]);
//			for(int j = i+1; j < 4; j++)
//			{
//				if(i != j)
//				{
//					carta2 = new Carta (num2, palos[j]);
//					combo.add(new Combo (carta1, carta2)); 
//				}
//			}
//		}
	}

	public ComboPareja() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Combos parsea(char[] comboParsea) {
		Combos combo = null;
		if(comboParsea[0]==comboParsea[1])
		{
			combo = new ComboPareja(comboParsea[0], comboParsea[1]);
		}
			
		return combo;
	}
	
	public String toString() {
		return "ComboPareja";
	}

}
