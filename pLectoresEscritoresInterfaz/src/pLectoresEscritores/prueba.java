package pLectoresEscritores;
import java.awt.TextArea;
public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gestor gestor=new gestor( null,null,null,null,null);
		escritor[] escritor=new escritor[10];
		lector[] lector=new lector[30];
		
		for (int i =0;i<escritor.length;i++) {
        	escritor[i]=new escritor(gestor, i, null);
        }
        for (int i =0;i<lector.length;i++) {
        	lector[i]=new lector(gestor,i,null);
        }
        for (int i =0;i<lector.length;i++) {
        	lector[i].start();
        }
        for (int i =0;i<escritor.length;i++) {
        	escritor[i].start();
        } 
	}


}
