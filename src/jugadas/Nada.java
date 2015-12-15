package jugadas;

import carta.Carta;
import carta.Mano;

public class Nada implements Jugadas {
	
	private int valorJugada = 1;
	private int numNada;
	private Mano mano;
	private Carta[] kicker;
	
	
	public Nada(Mano mano, int n) {
		this.numNada = n;
		this.mano = mano;
		this.kicker = new Carta[5];
	}
	
	
	@Override
	public int getValorJugada() {
		// TODO Auto-generated method stub
		return this.valorJugada;
	}

	@Override
	public void setKicker(int carta) {
		int i= this.mano.getMano().size()-1;
		while(carta != 0) {
			
			if(this.mano.getCarta(i).getKicker() != -1) {
				carta--;
				this.kicker[carta] = this.mano.getCarta(i);
			}
			i--;
		}
		
	}

	@Override
	public int getKicker(int n) {
		// TODO Auto-generated method stub
		return this.kicker[n].getKicker();
	}

	@Override
	public void setValor() {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		String cadena;
		cadena = "Carta mas alta " + this.mano.getNombreCarta(this.numNada) + " (" + this.mano.toString() + ")";
		return cadena;
	}


	@Override
	public int getNumJugada() {
		// TODO Auto-generated method stub
		return this.numNada;
	}


	@Override
	public int numKickers() {
		// TODO Auto-generated method stub
		return 5;
	}

}
