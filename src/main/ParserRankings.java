package main;

import java.io.IOException;
import java.util.Vector;

import IO.FileIn;
import observers.RangoObserver;
import observers.RankingObserver;
import ranking.RankingJanda;
import ranking.RankingMa;
import ranking.RankingRock;
import ranking.RankingTight;

public class ParserRankings {
	
	private int rango;
	private Posicion manoJugada;
	private int posicion;
	private boolean OR;
	private FileIn filein;
	private Vector<String> seleccionados;
	private Vector<RankingObserver> rObserver;

	
	public ParserRankings() {
		this.rObserver = new Vector<RankingObserver>();
		this.seleccionados = new Vector<String>();
	}
	
	
	public void setFile(String file) {
		try {
			this.filein = new FileIn();
			this.filein.setFile(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addSeleccionado(String selec) {
		this.seleccionados.removeAllElements();
		this.seleccionados.addElement(selec);
		notifySeleccionado();
	}
	
	

	public void setRango(String ranking) {
		this.rango = convertirRango(ranking);
	}

	public void setManoJugada(String mano) {
		this.manoJugada = parserManoJugada(mano);
	}


	public void setPosicion(String posicion) {
		this.posicion = convertirPosicion(posicion);
	}

	public void setOR(String accion) {
		OR = isOR(accion);
	}
	
	
	

	private int convertirRango(String Rango)
	{
		int rango;
		if(Rango.equals("Ma"))
		{
			rango = 0;
		}
		else if(Rango.equals("Janda"))
		{
			rango = 1;
		}
		else if(Rango.equals("Rock"))
		{
			rango = 2;
		}
		else {
			rango = 3;
		}
		

		return rango;
	}
	
	
	private int convertirPosicion (String Posicion)
	{
		int pos;
		if(Posicion.equals("UTG"))
		{
			pos = 0;
		}
		else if (Posicion.equals("MP"))
		{
			pos = 1;
		}
		else if (Posicion.equals("CO"))
		{
			pos = 2;
		}
		else if (Posicion.equals("BTN"))
		{
			pos = 3;
		}
		else
		{
			pos = 4;
		}
		return pos;
	}
	
	
	public boolean isOR(String Accion)
	{
		if (Accion.equals("OR"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public boolean Resultado()
	{
		
		PilaPosiciones pila = new PilaPosiciones();
		RankingJanda janda = new RankingJanda();
		RankingMa ma = new RankingMa();
		RankingRock rock = new RankingRock();
		RankingTight tight = new RankingTight();
		int i = 0;
		boolean encontrado = false;
		if(rango == 0)
		{
			pila = ma.getPosiciones(posicion);
		}
		else if(rango == 1)
		{
			pila = janda.getPosiciones(posicion);
		}
		else if(rango == 2)
		{
			pila = rock.getPosiciones(posicion);
		}
		else
		{
			pila = tight.getPosiciones(posicion);
		}
		
		
		while((!encontrado)&&(i < pila.getContador()))
		{
			if(mismaPosicion(pila.extractPosition(), manoJugada))
			{
				encontrado = true;
			}
			i++;
		}
		
		if((encontrado)&&(this.OR))
		{
			return true;
		}
		else if((encontrado)&&(!this.OR))
		{
			return false;
		}
		else if((!encontrado)&&(this.OR))
		{
			return false;
		}
		else
		{
			return true;
		}
		//Falta rango inventado!!!
	}
	
	
	private Posicion parserManoJugada(String Mano)
	{
		int valor1;
		int valor2;
		boolean suited;
		char [] cadena;
		cadena = Mano.toCharArray();
		if((cadena[1]!= 'h')&&(cadena[1]!= 's')&&(cadena[1]!= 'd')&&(cadena[1]!= 'c'))
		{
			valor1 = convertirCarta(cadena[0]);
			valor2 = convertirCarta (cadena[1]);
			if(cadena[0] != cadena[1])
			{	
				if(cadena[2] == 'o')
				{
					suited = false;
					this.manoJugada = new Posicion (valor1, valor2);
				}
				else
				{
					suited = true;
					this.manoJugada = new Posicion (valor2,valor1);
				}
			}
			else
			{
				suited = false;
				this.manoJugada = new Posicion (valor1,valor2);
			}
		}
		else
		{
			valor1 = convertirCarta(cadena[0]);
			valor2 = convertirCarta(cadena[1]);
			suited = this.esSuited(cadena[1],cadena[3]);
			if(suited)
			{
				this.manoJugada = new Posicion (valor2,valor1);
			}
			else
			{
				this.manoJugada = new Posicion (valor1, valor2);
			}
		}
		
		return manoJugada;
	}
	
	
	private boolean esSuited (char palo1, char palo2)
	{
		if(palo1 == palo2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	private int convertirCarta (char caracter)
	{
		int carta = -1;
		switch (caracter) {
		
		case 'A':
			carta = 0;
			break;
		case 'K':
			carta = 1;
			break;
		case 'Q':
			carta = 2;
			break;
		case 'J':
			carta = 3;
			break;
		case 'T':
			carta = 4;
			break;
		case '9':
			carta = 5;
			break;
		case '8':
			carta = 6;
			break;
		case '7':
			carta = 7;
			break;
		case '6':
			carta = 8;
			break;
		case '5':
			carta = 9;
			break;
		case '4':
			carta = 10;
			break;
		case '3':
			carta = 11;
			break;
		case '2':
			carta = 12;
		}
		return carta;
	}
	
	
	private boolean mismaPosicion(Posicion a, Posicion b)
	{
		int filaa,filab,columnaa,columnab;
		filaa = a.getFila();
		filab = b.getFila();
		columnaa = a.getColumna();
		columnab = b.getColumna();
		if((filaa == filab)&&(columnaa == columnab))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	
	public void addObserver(RankingObserver obs) {
		this.rObserver.add(obs);
	}
	
	public void notifyJugadaEvaluada(String[] salida, boolean res) {
		
		for (RankingObserver o : this.rObserver){
			o.jugadaEvaluada(salida, res);
		}
		
	}
	
	public void notifySeleccionado() {
		
		for (RankingObserver o : this.rObserver){
			o.haySeleccionado(this.seleccionados);
		}
		
	}
	
	
}
