package carta;

import java.util.ArrayList;
import java.util.HashMap;

public class Mano {
	
	private ArrayList<Carta> mano;
	private HashMap<Integer, String> valores;
	
	public Mano(){
		this.mano = new ArrayList<Carta>();
		this.valores = new HashMap<Integer, String>();
		setHashMap();
	}
	
	public void setMano(Carta carta) {
		this.mano.add(carta);
	}
	
	public void deleteCarta(String carta) {
		int i=0;
		boolean eliminada=false;
		while (i < mano.size() && !eliminada) {
			if(mano.get(i).toString().equals(carta)) {
				mano.remove(i);
				eliminada = true;
			}
			i++;
		}
	}
	
	public ArrayList<Carta> getMano() {
		return this.mano;
	}
	
	public Carta getCarta(int n) {
		return this.mano.get(n);
	}
	
	public void setUsada(int i, boolean b) {
		mano.get(i).setUsada(b);
	}
	
	
	public int getKicker() {
		return 0;
	}
	
	public boolean getUsada() {
		return true;
	}
	
	public void setKicker(int n) {
		int i= this.mano.size()-1;
		int j=1;
		while(n != 0) {
			/* Las cartas que no esten usadas las marco como kicker */
			if(this.mano.get(i).getUsada() != true) {
				n--;
				this.mano.get(i).setKicker(j);
				this.mano.get(i).setUsada(true);
				j++;
			}
			i--;
		}
	}
	
	
	public void deleteMano() {
		int n = mano.size();
		for (int i = n-1; i >= 0; i--) {
			this.mano.remove(i);
		}
	}
	
	private void setHashMap() {
		this.valores.put(new Integer(14), new String("As"));
		this.valores.put(new Integer(13), new String("Rey"));
		this.valores.put(new Integer(12), new String("Dama"));
		this.valores.put(new Integer(11), new String("Jota"));
		this.valores.put(new Integer(10), new String("Diez"));
		this.valores.put(new Integer(9), new String("Nueve"));
		this.valores.put(new Integer(8), new String("Ocho"));
		this.valores.put(new Integer(7), new String("Siete"));
		this.valores.put(new Integer(6), new String("Seis"));
		this.valores.put(new Integer(5), new String("Cinco"));
		this.valores.put(new Integer(4), new String("Cuatro"));
		this.valores.put(new Integer(3), new String("Tres"));
		this.valores.put(new Integer(2), new String("Dos"));
	}
	
	
	public String toString() {
		String cadena = new String();
		for(int i=0; i < this.mano.size(); i++) {
			/* Concateno Numero + Palo de cada carta de la mano que este usada */
//			if(this.mano.get(i).getUsada() == true)
				cadena += this.mano.get(i).toString();			
		}
		return cadena;
	}
	
	
	public String getNombreCarta(int n) {
		return this.valores.get(n);
	}
	
	
	public void ordenaMano(int lowerIndex, int higherIndex) {
		int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = this.mano.get(lowerIndex+(higherIndex-lowerIndex)/2).getCodigo();
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (this.mano.get(i).getCodigo() < pivot) {
                i++;
            }
            while (this.mano.get(j).getCodigo() > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call ordenaMano() method recursively
        if (lowerIndex < j)
        	ordenaMano(lowerIndex, j);
        if (i < higherIndex)
        	ordenaMano(i, higherIndex);
	}
	
	private void exchangeNumbers(int i, int j) {
        Carta temp = this.mano.get(i);
        this.mano.set(i, this.mano.get(j));
        this.mano.set(j, temp);
    }

}
