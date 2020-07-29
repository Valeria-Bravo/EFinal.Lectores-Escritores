package pLectoresEscritores;

import java.util.*;
public class lector extends Thread {
	private static Random r=new Random();
	private gestor gestor;
	private int identificador;
	
	
	public lector(gestor gestor,int identificador) {
		this.gestor=gestor;
		this.identificador=identificador;
	}
	
	public void run() {
		long TInicio, TFin, tiempo;
		TInicio= System.currentTimeMillis();
		while(true) { 
			try {
				gestor.openLector(identificador);
				Thread.sleep(r.nextInt(3000));
				gestor.closeLector(identificador);
				Thread.sleep(r.nextInt(3000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			TFin=System.currentTimeMillis();
			tiempo=TFin-TInicio;
		}
	}
	

}
