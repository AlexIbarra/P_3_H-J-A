package IO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileOut {
	
	private String file;
	private FileWriter fichero;
	private PrintWriter pw;
	
	public FileOut(String file) {
		this.file = file;
		
		try {
			this.fichero = new FileWriter(this.file);
			this.pw = new PrintWriter(this.fichero);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	
	
	public void writePartida(String msg) {

        pw.println(msg);

	}
	
	public void closeFile() {
		try {
			this.fichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
