package main;

import java.util.Vector;

import carta.Carta;
import observers.RangoObserver;

public class ParserRangos {

	static int ancho = 14;
	private static Posicion[] paresDeCartas;
	private PilaPosiciones pila;
	

	//private String cadena;
	private static Carta carta1;
	private static Carta carta2;
	private static Carta carta3;
	
	private Vector<RangoObserver> rObserver;
	
	
	public ParserRangos() {
		this.rObserver = new Vector<RangoObserver>();
		this.pila = new PilaPosiciones();
	}
	

	
	public void damePosicoines(int opcion) {
		
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 13; j++) {
				
				if(opcion == 1 && j == i) { // Pares
					this.pila.addPosicion(j, i);
				}
				else if(opcion == 2 && j > i) { // Suited
					this.pila.addPosicion(j, i);
				}
				else if(opcion == 3 && i == 0){ // Broadway (Ases suites)
					this.pila.addPosicion(j, i);
				}
				if(opcion == 3 && j == 0) { // Broadway (Ases offsuited)
					this.pila.addPosicion(j, i);
				}
			}
		}
		
		notifyHayPosiciones();
	}
	
	
	
	
 	public PilaPosiciones parseRangos(String s) {
		
		int posArray = 0;
		String[] array = s.split(",");		
		int fila;
		int col;
		
		
		
		for(int i = 0; i < array.length;i++){
			char[] token = array[i].toCharArray();
			
			if(array[i].contains("+")){
				if (token[0] == token[1]){
					//Es pareja
					carta1 = new Carta(token[0]);
					carta2 = new Carta(token[1]);
					int j = carta1.getCodigo();
					while(j < 15){                
						this.pila.addPosicion(ancho - j, ancho - j); // col, fil
						j++;
						posArray++;
					}
					
				}
				else{
					//Que no sea una pareja
					if (array[i].contains("s")){
						//suited
						carta1 = new Carta(token[1]);//carta baja
						carta2 = new Carta(token[0]);//carta alta
						fila = carta2.getCodigo();
						int p = carta1.getCodigo();
						
						while(p <= fila){
							this.pila.addPosicion(ancho-p, ancho-fila); // col, fil
							p++;
							posArray++;
						}
					}
					else if (array[i].contains("o")){
						//offsuited
						carta1 = new Carta(token[1]);//carta baja
						carta2 = new Carta(token[0]);//carta alta
						col = carta2.getCodigo();
						int p = carta1.getCodigo();
						while(p <= col){
							this.pila.addPosicion(ancho-col, ancho-p);
							p++;
							posArray++;
						}
					}	
				}
				
			}
			else if(array[i].contains("-")){
				if (array[i].contains("s")){
					//suited
					carta1 = new Carta(token[1]);
					carta2 = new Carta(token[5]);
					carta3 = new Carta(token[0]);
					int j = carta1.getCodigo();
					int p = carta2.getCodigo();
					fila = carta3.getCodigo();
					while(p <= j){
						this.pila.addPosicion(ancho-p, ancho-fila); // col, fil
						p++;
						posArray++;
					}
				}
				else{
					//offsuited
					carta1 = new Carta(token[1]);
					carta2 = new Carta(token[5]);
					carta3 = new Carta(token[0]);
					int j = carta1.getCodigo();
					int p = carta2.getCodigo();
					col = carta3.getCodigo();
					while(p <= j){
						this.pila.addPosicion(ancho-col, ancho-p);
						p++;
						posArray++;
					}
				}
			}
			else{
				//Caso de un solo par de cartas.
				if(array[i].contains("s")){
					carta2 = new Carta(token[0]);
					carta1 = new Carta(token[1]);
					fila = carta1.getCodigo();
					col = carta2.getCodigo();
					this.pila.addPosicion(ancho-fila, ancho-col);
					posArray++;
				}else{
					carta2 = new Carta(token[0]);
					carta1 = new Carta(token[1]);
					fila = carta2.getCodigo();
					col = carta1.getCodigo();
					this.pila.addPosicion(ancho-fila, ancho-col);
					posArray++;
				}
					
								
			}
			
			
		}
		
		
		
		
		
		return this.pila;
	}
 	
 	
 	
 	public PilaPosiciones getPila() {
		return pila;
	}
 	
 	public boolean dimeBroadway(String cartas) {
 		
 		char[] token = cartas.toCharArray();
 		carta1 = new Carta(token[0]);
		carta2 = new Carta(token[1]);
		
		return (carta1.getCodigo() >= 10 && carta2.getCodigo() >= 10 || carta1.getCodigo() == carta2.getCodigo());
 	}
		
	
	
	
	// Metodos de los Observers
	
	public void addObserver(RangoObserver obs) {
		this.rObserver.add(obs);
	}
	
	public void notifyHayRango(String rango) {
		
		parseRangos(rango);
		
		for (RangoObserver o : this.rObserver){
			o.hayRangos(this.pila);
		}
		
	}
	
	public void notifyHayPosiciones() {
		
		for (RangoObserver o : this.rObserver){
			o.hayRangos(this.pila);
		}
	}
	
	
	public void notifyClean() {
		for (RangoObserver o : this.rObserver){
			o.cleanGrid();;
		}
	}
	
	
	public void notifyBroadways() {
		for (RangoObserver o : this.rObserver){
			o.pintaBroadways();
		}
	}
	
	
	
}