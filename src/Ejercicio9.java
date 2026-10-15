import java.io.IOException;
import java.util.Scanner;

public class Ejercicio9 {
	static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

    	int eleccion = 0;
    	Process p = null;
    	boolean lanzado = false;
    	
    	do {
    		
	    	System.out.println("===== CONTROL DE PROCESO ===== \n"
	    			+ "1. Lanzar Bloc de notas \n"
	    			+ "2. Comprobar estado \n"
	    			+ "3. Mostrar PID \n"
	    			+ "4. Salir");
	    	eleccion = scanner.nextInt();
	    	if(eleccion < 1 || eleccion > 4) {
	    		System.out.println("Escoge entre las opciones indicadas");
	    	}
	    	switch(eleccion) {
	    	
	    	case 1:
	    		if(lanzado == false) {
		    		ProcessBuilder bloc = new ProcessBuilder("notepad.exe");

		            p = bloc.start();
		            lanzado = true;
		            System.out.println("Bloc de notas lanzado");
	    		}else{
	    			System.out.println("El bloc de notas ya ha sido lanzado");
	    		}
	           

	    		break;
	    	case 2:
	    		if(p == null) {
	    			System.out.println("El proceso no ha sido iniciado todavia");
	    		}
	    		else if(p.isAlive()) {
	            	System.out.println("El bloc de notas esta iniciado");
	            }else{
	            	System.out.println("Bloc de notas se ha cerrado");
	            }
	    		break;
	    	case 3:
	    		if(p == null) {
    			System.out.println("El proceso no ha sido iniciado todavia");
    		}else {
    			System.out.println("El PID del bloc de notas es " + p.pid());
    		}
	    		
	    		break;
	    	case 4:
	    		System.out.println("Adios :D");
	    		p.destroy();
	    		break;
	    	}	
    	
	    	
	    }while(eleccion != 4);	
    	
    	
    	
    }
    

}
