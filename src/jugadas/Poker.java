package jugadas;

import carta.Carta;
import carta.Mano;

public class Poker implements Jugadas {

	private int numPoker;
	private int valorJugada = 8;
	private Mano mano;
	private Carta kicker;
	

	
	public Poker(Mano mano, int numPoker) {
		this.mano = mano;
		this.numPoker = numPoker;
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
		cadena = "Poker de " + this.mano.getNombreCarta(this.numPoker) + " (" + this.mano.toString() + ")";
		return cadena;
	}

	@Override
	public int getNumJugada() {
		// TODO Auto-generated method stub
		return this.numPoker;
	}

	@Override
	public int numKickers() {
		// TODO Auto-generated method stub
		return 1;
	}

	
}
