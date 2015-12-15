package jugadas;

import carta.Carta;
import carta.Mano;

public class Escalera implements Jugadas{

	private int numEscalera;
	private int valorJugada = 5;
	private Mano mano;
	private Carta kicker;
	
	public Escalera(Mano mano, int num){
		this.numEscalera = num;
		this.mano = mano;
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
		cadena = "Escalera con kicker " + this.mano.getNombreCarta(this.numEscalera) + " (" + this.mano.toString() + ")";
		return cadena;
	}

	@Override
	public int getNumJugada() {
		// TODO Auto-generated method stub
		return this.numEscalera;
	}

	@Override
	public int numKickers() {
		// TODO Auto-generated method stub
		return 0;
	}

}
