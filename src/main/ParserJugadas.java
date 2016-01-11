package main;
import carta.Mano;
import jugadas.Color;
import jugadas.DoblePareja;
import jugadas.Escalera;
import jugadas.EscaleraColor;
import jugadas.FullHouse;
import jugadas.Jugadas;
import jugadas.Nada;
import jugadas.Pareja;
import jugadas.Poker;
import jugadas.Trio;

public class ParserJugadas {
	
	private Jugadas mejorJugada;
	private  boolean encontradoPareja = false;
	private boolean encontrdoTrio = false;
	private int Pareja;
	private int Trio;
	private int[] codigo;
	private char[] palo;
	
	private Mano mano5;
	private int posTrio;
	private int posPareja;

	
	public ParserJugadas() {
		
	}
	
	private void initMano(Mano mano) {
		int n = mano.getMano().size();
		this.codigo = new int[n];
		this.palo = new char[n];
		
		for(int i=0; i < n; i++) {
			this.codigo[i] = mano.getMano().get(i).getCodigo();
			this.palo[i] = mano.getMano().get(i).getPalo();
		}
	}
	
	
	
	
	public Jugadas parse(Mano mano) {
		
		initMano(mano);
		
		boolean encontrado = false;
		this.encontradoPareja = false;
		this.encontrdoTrio = false;
		this.Trio = -1;
		this.Pareja = -1;
		
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		
		
		/* Comprobamos el poker */
//		if(!esPoker(mano)) { // si no es poker
//			esParejasTrio(mano);
//			if(this.encontradoPareja && this.encontrdoTrio && (this.Trio != this.Pareja)){
//				this.mejorJugada = new FullHouse(mano, this.Trio, this.Pareja);
//			}else if(!esEscaleraColor(mano)){
//				if(!esColor(mano)){
//					
//					if(!esEscalera(mano)){
//						if(encontrdoTrio){
//							this.mejorJugada = new Trio(mano, this.Trio);
//						}else if(!esDoblesParejas(mano)){
//							if(encontradoPareja){
//								this.mejorJugada = new Pareja(mano, this.Pareja);
//							}else{
//								this.mejorJugada = new Nada(0);
//							}
//						}
//							
//					}
//				}
//			}
//			
//		}
		
		
		
		
		
		if(!esPoker(mano)) { // si no es poker
			esParejasTrio(mano);
			if(this.encontradoPareja && this.encontrdoTrio && (this.Trio != this.Pareja)){
				mano.setUsada(posTrio-2, true);
				mano.setUsada(posTrio-1, true);
				mano.setUsada(posTrio, true);
				mano.setUsada(posPareja-1, true);
				mano.setUsada(posPareja, true);			
				this.mejorJugada = new FullHouse(mano, this.Trio, this.Pareja);
			}else if(!esEscaleraColor(mano)){
				if(!esColor(mano)){
					if(!esEscalera(mano) && !esEscaleraAs(mano)){
						if(encontrdoTrio){
							mano.setUsada(posTrio-2, true);
							mano.setUsada(posTrio-1, true);
							mano.setUsada(posTrio, true);
							mano.setKicker(2);							
							this.mejorJugada = new Trio(mano, this.Trio);
							this.mejorJugada.setKicker(2);
						}else if(!esDoblesParejas(mano)){
							if(encontradoPareja){	
								mano.setUsada(posPareja-1, true);
								mano.setUsada(posPareja, true);
								mano.setKicker(3);								
								this.mejorJugada = new Pareja(mano, this.Pareja);
								this.mejorJugada.setKicker(3);
							}else {
								mano.setKicker(5);				
								this.mejorJugada = new Nada(mano, this.codigo[this.codigo.length-1]);
								this.mejorJugada.setKicker(5);
							}
						}
							
					}
				}
			}
			
		}
	
		return mejorJugada;
	}
	
	
	
	
	
	
///////////////////////////////////////////////////////////////////////////////////////	
////////////////////////                                      /////////////////////////	
//////////////////////// FUNCIONES PARA COMPROBAR LAS JUGADAS /////////////////////////
////////////////////////                                      /////////////////////////
///////////////////////////////////////////////////////////////////////////////////////	
	
	
	
	private boolean esEscaleraAs(Mano mano) {
		boolean encontrado = false;
		int i = mano.getMano().size()-1;

		if(this.codigo[i] == 14)
			while ( i > 3 && !encontrado) {
				if(this.codigo[i-1] == 5 || this.codigo[i-2] == 5 || this.codigo[i-3] == 5) 
						if(this.codigo[i-2] == 4)
							if(this.codigo[i-3] == 3)
								if(this.codigo[i-4] == 2) {
			
									encontrado = true;
									mano.setUsada(i-4, true);
									mano.setUsada(i-3, true);
									mano.setUsada(i-2, true);
									mano.setUsada(i-1, true);
									mano.setUsada(i, true);
									this.mejorJugada = new Escalera(mano, this.codigo[i]);
								}
								i--;
			}
		return encontrado;
	}
	
	
	
	
	
	private boolean esParejasTrio(Mano mano) {

		int i = mano.getMano().size()-1;
		boolean encontrado = false;
		
		while (i > 0) {
			
			if(this.codigo[i] == this.codigo[i-1] && this.Trio != this.codigo[i]) {
				if((i-2 >= 0) && this.codigo[i] ==  this.codigo[i-2]){
					encontrado = true;
					this.encontrdoTrio = true;
					this.Trio = this.codigo[i];
					this.posTrio = i;
					i--;
				}else{
					encontrado = true;;
					this.encontradoPareja = true;
					this.Pareja = this.codigo[i];
					this.posPareja = i;
				}
			}			
			i--;
			
		}
		return encontrado;
	}
	
	
	
	private boolean esDoblesParejas(Mano mano) {
		
		int i= mano.getMano().size()-1;
		boolean encontrado = false;
		boolean encontrado2 = false;
		int pareja = 0;
		
		while (i > 2 && !encontrado2) {
			
			if(this.codigo[i] == this.codigo[i-1] && !encontrado){
				encontrado = true;
				pareja = this.codigo[i];
				mano.setUsada(i-1, true);
				mano.setUsada(i, true);
			}
			i--;
			if((this.codigo[i-1] == this.codigo[i-2]) && encontrado){
				encontrado2 = true;
				mano.setUsada(i-2, true);
				mano.setUsada(i-1, true);
				mano.setKicker(1);
				this.mejorJugada= new DoblePareja(mano, pareja, this.codigo[i-1]);
				this.mejorJugada.setKicker(1);
			}
		}	
		return encontrado2;
	}

	
	
	
	
	private boolean esEscalera(Mano mano) {
		boolean encontrado = false;
		int i = mano.getMano().size()-1;
		int j = 1;
		int[] usados = new int [5];
		int cont = 0;
		while(j <= i)
		{
			if(cont < 5 && (this.codigo[i-(j-1)] == this.codigo[i-j]+1))
			{
				usados[cont] = i-(j-1);
				cont++;
				if(cont < 5)
					usados[cont] = i-j;
			}
			j++;
		}
		if(cont == 4 && this.codigo[usados[0]] == this.codigo[usados[4]+4])
		{
			for(int k = cont; k >= 0; k--)
			{
				mano.setUsada(usados[k],true);
			}
			encontrado = true;
		}	
		this.mejorJugada = new Escalera(mano, this.codigo[i]);
		return encontrado;
	}
	
	
	
	private boolean esEscaleraColor(Mano mano) {
			
		 int i = mano.getMano().size() -1; 
		 boolean encontrado = false;
		
		while ( i >= 4 && !encontrado){
		
			 if (this.codigo[i] == this.codigo[i-1] +1 && 
					 this.palo[i] == this.palo[i-1] && 
					 this.codigo[i] == this.codigo[i-2] +2 && 
							 this.palo[i] == this.palo[i-2] && 
					 this.codigo[i] == this.codigo[i-3] +3 && 
							 this.palo[i] == this.palo[i-3] && 
					 this.codigo[i] == this.codigo[i-4] +4 && 
							 this.palo[i] == this.palo[i-4]) {
				
				encontrado = true;
				mano.setUsada(i-4, true);
				mano.setUsada(i-3, true);
				mano.setUsada(i-2, true);
				mano.setUsada(i-1, true);
				mano.setUsada(i, true);
				this.mejorJugada = new EscaleraColor(mano, this.codigo[i]);
			}
			 i--;
		}
		return encontrado;
	}
	
	
	private boolean esPoker(Mano mano) {
		
		int i = mano.getMano().size()-1;
		boolean encontrado = false;
		
		while (i >= 3 && !encontrado) {
			
			if(this.codigo[i] == this.codigo[i-3] ){
				
				encontrado = true;
				mano.setUsada(i-3, true);
				mano.setUsada(i-2, true);
				mano.setUsada(i-1, true);
				mano.setUsada(i, true);
				mano.setKicker(1);
				this.mejorJugada = new Poker(mano, this.codigo[i]);
				this.mejorJugada.setKicker(1);
			}			
			i--;
			
		}
		return encontrado;
	}
	
	
	
	private boolean esColor(Mano mano) {
		
		boolean encontrado = false;
		int i = mano.getMano().size()-1;
		while (i >3 && !encontrado){
			if(this.palo[i] == this.palo[i-1] && 
					this.palo[i-1] == this.palo[i-2] &&
							this.palo[i-2] == this.palo[i-3] &&
									this.palo[i-3] == this.palo[i-4]) {
				
				encontrado = true;
				mano.setKicker(5);
				this.mejorJugada = new Color(mano, this.codigo[i]);
				this.mejorJugada.setKicker(5);
			}
			i--;
		}

		return encontrado;
	}




}
