package combos;

import java.util.ArrayList;

import carta.Carta;
import carta.Combo;

public class ComboPareja implements Combos{
	private ArrayList <Combo> combo = new ArrayList <Combo>();
	public ComboPareja(char num1, char num2)
	{
		char[] palos = {'p','h','s','d'};
		Carta carta1;
		Carta carta2;
		for(int i = 0; i < 4; i++)
		{
			carta1 = new Carta(num1,palos[i]);
			for(int j = i+1; j < 4; j++)
			{
				if(i != j)
				{
					carta2 = new Carta (num2, palos[j]);
					combo.add(new Combo (carta1, carta2)); 
				}
			}
		}
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

}
