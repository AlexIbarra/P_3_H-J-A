package main;

import carta.Mano;

public class ParserDraws {
	
	
	
	public int Draw(Mano mano)
	{
		int draw = 0;
		if(drawEscaleraColor(mano))
		{
			draw = 7;
		}
		else
		{
			if(drawEscalera(mano))
			{
				draw += 2;
				if(drawColor(mano))
				{
					draw++;
				}
			}
			else if(drawColor(mano))
			{
				draw = 1;
			}
		}
		
		return draw;
	}
	
	
	
	private boolean drawEscalera(Mano mano) {
		boolean encontrado = false;
		boolean saltoDos = false;
		int[] usados = new int [4];
		int i = mano.getMano().size()-1;
		int j;
		int cont = 0;
		if((i == 4)||(i==5))
		{
			j = 1;
			while(j <= i)
			{
				if(cont < 4 && (mano.getMano().get(i-(j-1)).getCodigo() == mano.getMano().get(i-j).getCodigo()+1))
				{
					usados[cont] = i-(j-1);
					cont++;
					if(cont < 4)
						usados[cont] = i-j;
				}
				else if(cont < 4 && (mano.getMano().get(i-(j-1)).getCodigo() == mano.getMano().get(i-j).getCodigo()+2)&&(!saltoDos))
				{
					usados[cont] = i-(j-1);
					cont++;
					if(cont < 4)
						usados[cont] = i-j;
					saltoDos = true;
				}
				j++;
			}
			if(cont == 3 && mano.getMano().get(usados[0]).getCodigo() == mano.getMano().get(usados[3]+3).getCodigo())
			{
				encontrado = true;
			}
		}
	return encontrado;
}	
	
	
	
	private boolean drawColor(Mano mano) {
		boolean encontrado = false;
		boolean cuatroEncontrado = false;
		int i = mano.getMano().size()-1;
		int j;
		int cont = 0;
		if((i == 4)||(i==5))
		{
			while (i >2 && !encontrado && !cuatroEncontrado)
			{
				j = 1;
				cont = 0;
				while(j <= i)
				{	
					if(mano.getMano().get(i).getPalo() == mano.getMano().get(i-j).getPalo())
					{
						cont++;
					}
					j++;
				}
				if(cont == 4)
				{
					cuatroEncontrado = true;
				}
				if(cont == 3)
				{
					encontrado = true;
				}
				i--;
			}
				
		}
		return encontrado;
	}
	
	
	
	private boolean drawEscaleraColor(Mano mano){
		boolean encontrado = false;
		boolean saltoDos = false;
		int i = mano.getMano().size()-1;
		int j;
		int cont = 0;
		if((i==4)||(i==5))
		{
			j = 1;
			while(j <= i)
			{
				if((mano.getMano().get(i-(j-1)).getCodigo() == mano.getMano().get(i-j).getCodigo()+1)&&(mano.getMano().get(i-(j-1)).getPalo() == (mano.getMano().get(i-j).getPalo())))
				{
					cont++;
				}
				else if((mano.getMano().get(i-(j-1)).getCodigo() == mano.getMano().get(i-j).getCodigo()+2)&&(!saltoDos)&&(mano.getMano().get(i-(j-1)).getPalo() == mano.getMano().get(i-j).getPalo()))
				{
					cont++;
					saltoDos = true;
				}
				j++;
			}
			if(cont == 3)
			{
				encontrado = true;
			}
		}
		return encontrado;
	}
}
	
	/*private boolean drawEscaleraColor(Mano mano) {
			
//		if(mano.getMano().get(0).getCodigo() < mano.getMano().get(1).getCodigo() && 
//		mano.getMano().get(1).getCodigo() < mano.getMano().get(2).getCodigo() &&
//		mano.getMano().get(2).getCodigo() < mano.getMano().get(3).getCodigo() &&
//		mano.getMano().get(3).getCodigo() < mano.getMano().get(4).getCodigo() && esColor(mano)) {
		 int i = mano.getMano().size() -1; 
		 boolean encontrado = false; 
		
		while ( i >= 4 && !encontrado){
		
			 if (mano.getMano().get(i).getCodigo() == mano.getMano().get(i-1).getCodigo() -1 && 
			 mano.getMano().get(i).getPalo() == mano.getMano().get(i-1).getPalo() && 
			 mano.getMano().get(i).getCodigo() == mano.getMano().get(i-2).getCodigo() -2 && 
			 mano.getMano().get(i).getPalo() == mano.getMano().get(i-2).getPalo() && 
			 mano.getMano().get(i).getCodigo() == mano.getMano().get(i-3).getCodigo() -3 && 
			 mano.getMano().get(i).getPalo() == mano.getMano().get(i-3).getPalo() && 
			 mano.getMano().get(i).getCodigo() == mano.getMano().get(i-4).getCodigo() -4 && 
			 mano.getMano().get(i).getPalo() == mano.getMano().get(i-4).getPalo()) {
				
				encontrado = true;
				this.mejorJugada = new EscaleraColor(mano, mano.getMano().get(i).getCodigo());
			}
			 i--;
		}
		return encontrado;
	}
	
	
	private boolean drawColor(Mano mano) {
		
		boolean encontrado = false;
		int i = mano.getMano().size()-1;
		while (i >3 && !encontrado){
			if(mano.getMano().get(i).getPalo() == mano.getMano().get(i-1).getPalo() && 
			mano.getMano().get(i-1).getPalo() == mano.getMano().get(i-2).getPalo() &&
			mano.getMano().get(i -2).getPalo() == mano.getMano().get(i-3).getPalo() &&
			mano.getMano().get(i-3).getPalo() == mano.getMano().get(i-4).getPalo()) {
				
				encontrado = true;
				this.mejorJugada = new Color(mano, mano.getMano().get(i).getCodigo());
			}
			i--;
		}
		/*tenemos que ver bien como hacer la codificacion del valor de las jugadas*/
		//return encontrado;
//}
