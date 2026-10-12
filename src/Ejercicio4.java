import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
public class Ejercicio4 {
    public static void main(String[] args) throws IOException {

        int numero = (int) (Math.random() *((3 -1)+1)+1);

        System.out.println("Numero generado " + numero);

        switch (numero){
            case 1:
                lanzarProceso("hostname");
                break;
            case 2:
                lanzarProceso("whoami");
                break;
            case 3:
                lanzarProceso("ipconfig");
                break;
        }
    }
    public static void lanzarProceso(String comando) throws IOException {
        ProcessBuilder cmd = new ProcessBuilder("cmd" ,"/c" ,comando);

        Process p = cmd.start();

        InputStream salidaP = p.getInputStream();

        InputStreamReader conversor = new InputStreamReader(salidaP);

        BufferedReader lector = new BufferedReader(conversor);
        String linea = lector.readLine();
        while(linea != null){
            System.out.println(linea);
            linea = lector.readLine();
        }



    }

}
