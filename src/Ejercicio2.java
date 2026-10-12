import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio2 {
    public static void main(String[] args) throws IOException {
        //Variables
        int cont = 0;
        //Creo el proceso
        ProcessBuilder cmd = new ProcessBuilder("cmd" , "/c" ,"ipconfig && -all");
        //Lanzo y asigno
        Process p = cmd.start();
        //Creo la salida
        InputStream salidaProceso = p.getInputStream();
        //Creo el traductor
        InputStreamReader conversor = new InputStreamReader(salidaProceso);
        //Creo el lector
        BufferedReader lector = new BufferedReader(conversor);
        //Asigno la salida del lector a un string
        String linea = lector.readLine();
        while(linea != null) {
            if(linea.contains("IPv4") || linea.contains("Gateway")){
                System.out.println(linea);
                cont++;
            }
            linea = lector.readLine();
        }
        System.out.println("Numero de ipv4 encontradas "  + cont);

    }
}
