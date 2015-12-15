package jugadas;

import carta.Carta;
import carta.Mano;

public class Trio implements Jugadas {
	
	private int numTrio;
	private int valorJugada = 4;
	private Mano mano;
	private Carta[] kicker;
	
	public Trio(int num){
		
		num = numTrio;
	}
	
	public Trio(Mano mano, int numTrio) {
		this.numTrio = numTrio;
		this.mano = mano;
		this.kicker = new Carta[2];
	}
	

	

	@Override
	public int getValorJugada() {
		// TODO Auto-generated method stub
		return valorJugada;
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
	
	public String toString() {
		String cadena;
		cadena = "Trio de " + this.mano.getNombreCarta(this.numTrio) + " (" + this.mano.toString() + ")";
		return cadena;
	}

	@Override
	public int getNumJugada() {
		// TODO Auto-generated method stub
		return this.numTrio;
	}

	@Override
	public int numKickers() {
		// TODO Auto-generated method stub
		return 2;
	}

}
