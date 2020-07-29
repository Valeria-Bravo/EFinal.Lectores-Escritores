package pLectoresEscritores;
import java.awt.TextArea;

import java.util.*;

import javax.swing.JProgressBar;
public class escritor extends Thread{
	private static Random r=new Random();
	private gestor gestor;
	private int identificador;
	TextArea mensajes;
	
	public escritor(gestor gestor,int identificador, TextArea mensajes) {
		this.gestor=gestor;
		this.identificador=identificador;
		this.mensajes=mensajes;
	}
	
	public void run() {
		while(true) {
			try {
				gestor.openEscritor (identificador);
				Thread.sleep(r.nextInt(2000));
				gestor.closeEscritor (identificador);
				Thread.sleep(r.nextInt(2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	

}
