import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio6 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        System.out.println("Introduce el nombre de un proceso:");
        String proceso = scanner.nextLine();
        lanzarP(proceso);


    }
    public static void lanzarP(String proceso) throws IOException {
        ProcessBuilder cmd = new ProcessBuilder("cmd" ,"/c" ,"tasklist");

        Process p = cmd.start();

        InputStream salidaP = p.getInputStream();

        InputStreamReader conversor = new InputStreamReader(salidaP);

        BufferedReader lector = new BufferedReader(conversor);
        String linea = lector.readLine();
        int cont = 0;
        boolean variasALaVez = false;
        while(linea != null){

            cont++;
            System.out.println(linea);
            linea = lector.readLine();
            if(linea.equalsIgnoreCase(proceso)){
                variasALaVez = true;
            }

        }

        System.out.println("Proceso buscado; " + proceso);
        System.out.println("Numero de instancias; " + cont);
        if(variasALaVez){
            System.out.println("Hay varias instancias; ");
        }



    }

}
