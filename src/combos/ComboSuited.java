package combos;

import java.util.ArrayList;

import carta.Carta;
import carta.Combo;

public class ComboSuited implements Combos{
	private ArrayList <Combo> combo = new ArrayList <Combo>();
	public ComboSuited()
	{
		
	}
	public ComboSuited(char num1, char num2)
	{
		char[] palos = {'p','h','s','d'};
		Carta carta1;
		Carta carta2;
		for(int i = 0; i < 4; i++)
		{
			carta1 = new Carta(num1,palos[i]);
			carta2 = new Carta(num2, palos[i]);
			combo.add(new Combo (carta1, carta2)); 
		}
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
}
