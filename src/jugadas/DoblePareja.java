package jugadas;

import carta.Carta;
import carta.Mano;

public class DoblePareja implements Jugadas {

	private int numDoble1, numDoble2; // numDoble1 es la pareja alta
	private int valorJugada = 3;
	private Mano mano;
	private Carta kicker;
	

	
	public DoblePareja(Mano mano, int d1, int d2) {
		this.mano = mano;
		this.numDoble1 = d1;
		this.numDoble2 = d2;
	}
	
	
	@Override
	public int getValorJugada() {
		
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
		cadena = "Dobles Parejas de " +  this.mano.getNombreCarta(this.numDoble1) + " y " +  this.mano.getNombreCarta(this.numDoble2) + " (" + this.mano.toString() + ")";
		return cadena;
	}

	@Override
	public int getNumJugada() {
		// TODO Auto-generated method stub
		return this.numDoble1*100 + this.numDoble2;
	}

	@Override
	public int numKickers() {
		// TODO Auto-generated method stub
		return 1;
	}

}
