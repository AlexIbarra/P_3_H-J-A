package jugadas;

import carta.Mano;

public class FullHouse implements Jugadas {
	
	private int numTrio, numPareja;
	private Mano mano;
	private int valorJugada = 7;
	
	
	public FullHouse(Mano mano, int numTrio, int numPareja) {
		this.mano = mano;
		this.numTrio = numTrio;
		this.numPareja = numPareja;
	}

	@Override
	public int getValorJugada() {
		// TODO Auto-generated method stub
		return this.valorJugada;
	}

	@Override
	public int getKicker(int n) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setValor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setKicker(int carta) {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		String cadena;
		cadena = "Full House de " + this.mano.getNombreCarta(this.numTrio) + " y " + this.mano.getNombreCarta(this.numPareja) + " (" + this.mano.toString() + ")";
		return cadena;
	}

	@Override
	public int getNumJugada() {
		// TODO Auto-generated method stub
		return this.numPareja + this.numTrio*100;
	}

	@Override
	public int numKickers() {
		// TODO Auto-generated method stub
		return 0;
	}

}
