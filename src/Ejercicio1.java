import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Ejercicio1 {
    public static void main(String[] args) throws IOException {

        //creo el proceso del cmd
        ProcessBuilder whoami = new ProcessBuilder("cmd" , "/c" , "whoami");
        ProcessBuilder systeminfo = new ProcessBuilder("cmd" , "/c" , "hostname");

        //Lanzo los procesos y los asigno
        Process pw = whoami.start();
        Process ps = systeminfo.start();

        //Recojo las salidas
        InputStream salida1 = pw.getInputStream();
        InputStream salida2 = ps.getInputStream();

        //Creo el traductor
        InputStreamReader conversor1 = new InputStreamReader(salida1);
        InputStreamReader conversor2 = new InputStreamReader(salida2);

        //Creo el lector
        BufferedReader lector1 = new BufferedReader(conversor1);
        BufferedReader lector2= new BufferedReader(conversor2);

        //Asigno cada salida a cada linea
        String linea1 = lector1.readLine();
        String linea2 = lector2.readLine();

        System.out.println("===== INFORMACIÓN DEL EQUIPO ===== \n" +
                "Usuario: " + linea1 + "\n" +
                "Equipo: " + linea2);

    }
}