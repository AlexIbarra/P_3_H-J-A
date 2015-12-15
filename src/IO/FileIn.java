package IO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


public class FileIn {


private String cadena;
private char[] token;
private int numJugadores;
private FileReader fr;
private BufferedReader br;
	
	
	public FileIn(String param) throws IOException{
		
		try {			
			
			this.fr = new FileReader(param);
			this.br = new BufferedReader(this.fr);

		} catch(FileNotFoundException exc) {
			throw new IOException("Error al acceder al fichero de entrada ("+ param + ")");
		}

	}
	
	public FileIn() {}
	
	
	
	
	public void setFile(String file) throws IOException{
		try {			
			
			this.fr = new FileReader(file);
			this.br = new BufferedReader(this.fr);

		} catch(FileNotFoundException exc) {
			throw new IOException("Error al acceder al fichero de entrada ("+ file + ")");
		}
	}
	
	
	public String getCartas() {
		return this.cadena;
	}
	
	
	public String readJugadaRango() {
		try {
			this.cadena = br.readLine();
			this.token = this.cadena.toCharArray();
							
			if(this.cadena == null)
				this.fr.close();
			return cadena;
		} catch (Exception e) {
			return null;
		}
	}

	
	public String readPartida() {
		try {
			this.cadena = br.readLine();
			this.token = this.cadena.toCharArray();
			if(this.token[1] == ';')
				this.numJugadores = Character.getNumericValue(this.token[0]);
			else
				this.numJugadores = 1;
				
			if(this.cadena == null)
				this.fr.close();
			return cadena;
		} catch (Exception e) {
			return null;
		}
	}
	
	public int getNumJugadores() {
		return this.numJugadores;
	}

}
