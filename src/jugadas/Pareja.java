package jugadas;

import carta.Carta;
import carta.Mano;

public class Pareja implements Jugadas {
		
	private Mano mano;
	private int valorJugada = 2;
	private int numPareja;
	private Carta[] kicker;
	

	
	public Pareja(Mano mano, int numPareja) {
		this.mano = mano;
		this.numPareja = numPareja;
		this.kicker = new Carta[3];
	}
	

	@Override
	public int getValorJugada() {
		return valorJugada;
	}
	
	@Override
	public int getKicker(int n) {
		/*Mirar la carta mas alta de la mano y si no pertenece a la pareja devolverla?*/
		return this.kicker[n].getKicker();
	}

	@Override
	public void setValor() {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		return "Pareja de " + this.mano.getNombreCarta(this.numPareja) + " (" + this.mano.toString() + ")";	
	}

	/* Metodo encargado de buscar y asignar el kicker */
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
	public int getNumJugada() {
		// TODO Auto-generated method stub
		return this.numPareja;
	}

	@Override
	public int numKickers() {
		// TODO Auto-generated method stub
		return 3;
	}
}
