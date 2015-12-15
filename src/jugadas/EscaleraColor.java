package jugadas;

import java.util.ArrayList;

import carta.Carta;
import carta.Mano;

public class EscaleraColor implements Jugadas{
	
	private Mano mano;
	private int numEscaleraColor;
	private int valorJugada = 9;
	private Carta kicker;
	
	
	
	public EscaleraColor(Mano mano, int numEscalera) {
		this.mano = mano;
		this.numEscaleraColor = numEscalera;
	}

	
	@Override
	public int getValorJugada() {
		// TODO Auto-generated method stub
		return this.valorJugada;
	}

	@Override
	public int getKicker(int n) {
		// TODO Auto-generated method stub
		return this.kicker.getKicker();
	}

	@Override
	public void setValor() {
		// TODO Auto-generated method stub	
	}



	@Override
	public void setKicker(int carta) {
		int i= this.mano.getMano().size()-1;
		while(carta != 0) {
			
			if(this.mano.getCarta(i).getKicker() != -1) {
				carta--;
				this.kicker = this.mano.getCarta(i);
			}
			i--;
		}		
	}


	public String toString() {
		String cadena;
		cadena = "Escalera de Color con kicker " + this.mano.getNombreCarta(this.numEscaleraColor) + " (" + this.mano.toString() + ")";
		return cadena;
	}




	@Override
	public int getNumJugada() {
		// TODO Auto-generated method stub
		return this.numEscaleraColor;
	}


	@Override
	public int numKickers() {
		// TODO Auto-generated method stub
		return 0;
	}

}
