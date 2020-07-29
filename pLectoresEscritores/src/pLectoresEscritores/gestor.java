package pLectoresEscritores;

public class gestor {
	private int numeroLectores=0;
	private boolean h=false; //verifica si hay escrtiores, se inicializa con falso para poder comenzar el proceso
	private int numeroEscritor=0;
	long inicio1=System.currentTimeMillis();
	int sumaL=0;
	int sumaE=0;
	
	public synchronized void openLector(int identificador) throws InterruptedException {
	//un lector puede entrar siempre y cuando no haya un escritor 	
		while (h || numeroEscritor >0) {
			wait();//espera
		}
		numeroLectores++;
		String palabra = " " ;
        int codigoAscii = (int)Math.floor(Math.random()*(122 - 97)+97); 
    	palabra = palabra + (char)codigoAscii;
        System.out.println("El lector "+identificador+" entra en la sala con el libro "+palabra+"  para poder leer");
        
	}
	public synchronized void closeLector(int identificador) {
		long fin1=System.currentTimeMillis();
		double tiempo1=(double) ((fin1-inicio1)/1000)+1;
		String palabra = " " ;
        int codigoAscii = (int)Math.floor(Math.random()*(122 - 97)+97); 
    	palabra = palabra + (char)codigoAscii;
		System.out.println("El lector "+identificador+" sale de la sala con el libro "+palabra);
		System.out.println("Tiempo lector: "+tiempo1);
		 numeroLectores--;
		 if (numeroLectores==0) notifyAll();//deja entrar a los escritores que estan esperando 
	}
	
	public synchronized void openEscritor (int identificador) throws InterruptedException {
		numeroEscritor++;
		while (h || numeroLectores >0) {
			wait();
		}
		sumaE++;
		h=true;
		System.out.println("Escritor "+identificador+" entra en la sala para poder escribrir");
	}
	public synchronized void closeEscritor(int identificador) {
		long fin2=System.currentTimeMillis();
		double tiempo2=(double) ((fin2-inicio1)/1000);
		numeroEscritor--;
		System.out.println("Escritor "+identificador+" sale de la sala");
		System.out.println("Tiempo escritor: "+ tiempo2);
	    System.out.println("Total escritor: "+sumaE);
		h=false;
		notifyAll();
	}	
}
