package pLectoresEscritores;
import java.awt.TextArea;

import javax.swing.JLabel;

public class gestor {
	private int numeroLectores=0;
	private boolean h=false;
	private int numeroEscritor=0;
	TextArea mensajes;
	long inicio1=System.currentTimeMillis();
	JLabel j1;
	JLabel j2;
	JLabel j3;
	JLabel j4;
	int sumaL=0;
	int sumaE=0;
	public gestor ( TextArea mensajes, JLabel j1,JLabel j2,JLabel j3,JLabel j4) {
		this.mensajes=mensajes;
		this.j1=j1;
		this.j2=j2;
		this.j3=j3;
		this.j4=j4;
	}
	public synchronized void openLector(int identificador) throws InterruptedException {
	
		while (h || numeroEscritor >0) {
			wait();
		}
		sumaL++;
		numeroLectores++;
		String palabra = " " ;
        int codigoAscii = (int)Math.floor(Math.random()*(122 - 97)+97); 
    	palabra = palabra + (char)codigoAscii;
    	mensajes.append("El lector "+identificador+" entra en la sala con el libro "+palabra+"  para poder leer"+"\n");
        
        
	}
	public synchronized void closeLector(int identificador) {
		long fin1=System.currentTimeMillis();
		double tiempo1=(double) ((fin1-inicio1)/1000)+1;
		String palabra = " " ;
        int codigoAscii = (int)Math.floor(Math.random()*(122 - 97)+97); 
    	palabra = palabra + (char)codigoAscii;
    	mensajes.append("El lector "+identificador+" sale de la sala con el libro "+palabra+"\n");
    	j1.setText(String.valueOf("Tiempo lector: "+tiempo1));
    	j4.setText(String.valueOf("Total lector: "+sumaL));
		 numeroLectores--;
		 if (numeroLectores==0) notifyAll();
	}
	
	public synchronized void openEscritor (int identificador) throws InterruptedException {
		numeroEscritor++;
		while (h || numeroLectores >0) {
			wait();
		}
		sumaE++;
		h=true;
		mensajes.append("Escritor "+identificador+" entra en la sala para poder escribrir"+"\n");
	}
	public synchronized void closeEscritor(int identificador) {
		long fin2=System.currentTimeMillis();
		double tiempo2=(double) ((fin2-inicio1)/1000);
		numeroEscritor--;
		mensajes.append("Escritor "+identificador+" sale de la sala"+"\n");
		j2.setText(String.valueOf("Tiempo escritor: "+ tiempo2));
		j3.setText(String.valueOf("Total escritor: "+sumaE));
		h=false;
		notifyAll();
	}
	
}
