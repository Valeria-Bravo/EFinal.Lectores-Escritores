package pLectoresEscritores;

import java.util.*;
public class escritor extends Thread{
	private static Random r=new Random();
	private gestor gestor;//gestiona cuando puede abrir un lector o cuando un escritor
	private int identificador;//para poder  escribir su libro
	
	
	public escritor(gestor gestor,int identificador) {
		this.gestor=gestor;
		this.identificador=identificador;
	}
	
	public void run() {
		while(true) {//llama al gestor para que pueda escribir
			try {
				gestor.openEscritor (identificador);
				Thread.sleep(r.nextInt(1000));
				gestor.closeEscritor (identificador);
				Thread.sleep(r.nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//aquí se encuentra escribiendo 
		}
	}
	

}
