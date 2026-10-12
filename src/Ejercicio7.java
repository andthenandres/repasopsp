import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio7 {
    public static void main(String[] args) throws IOException {
        ProcessBuilder cmd = new ProcessBuilder("cmd" ,"/c" ,"hostname");

        Process p = cmd.start();

        InputStream salidaP = p.getInputStream();

        InputStreamReader conversor = new InputStreamReader(salidaP);

        BufferedReader lector = new BufferedReader(conversor);
        String linea = lector.readLine();
        int cont = 0;
        while(linea != null) {

            System.out.println("Nombre del equipo: " + linea);
            linea = lector.readLine();
            for (int i = 0; i < linea.length(); i++) {
                cont++;
            }
            System.out.println("Numero de caracteres:  " + cont);
        }
        p.destroy();
    }
}
