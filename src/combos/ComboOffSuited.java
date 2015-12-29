package combos;

import java.util.ArrayList;

import carta.Carta;
import carta.Combo;

public class ComboOffSuited implements Combos{
	
	
	private ArrayList <Combo> combo = new ArrayList <Combo>();
	private int contador;
	
	
	public ComboOffSuited(char num1, char num2)
	{
		this.contador = 12;
		char[] palos = {'c','h','s','d'};
		Carta carta1;
		Carta carta2;
		for(int i = 0; i < 4; i++)
		{
			carta1 = new Carta(num1,palos[i]);
			for(int j = 0; j < 4; j++)
			{
				if(j != i)
				{
					carta2 = new Carta(num2, palos[j]);
					combo.add(new Combo (carta1, carta2)); 
				}
			}
		}
	}
	
	public ComboOffSuited() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public Combos parsea(char[] comboParsea) {
		Combos combo = null;
		if(comboParsea.length == 3)
		{
			if(comboParsea[2]=='o')
			{
				combo = new ComboOffSuited(comboParsea[0],comboParsea[1]);
			}
		}
		else if(comboParsea.length == 2)
		{
			if(comboParsea[0] != comboParsea[1])
			{
				combo = new ComboOffSuited(comboParsea[0],comboParsea[1]);
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
		return "ComboOffSuited";
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.contador;
	}

}
