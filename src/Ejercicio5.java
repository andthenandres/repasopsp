import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio5 {

    public static void main(String[] args) throws IOException {
        int num;

        do {

            System.out.println("===== HERRAMIENTAS =====\n" +
                    "1. ¿Quién soy?\n" +
                    "2. ¿Cómo se llama este equipo?\n" +
                    "3. ¿Qué hora es?\n" +
                    "4. ¿Qué procesos están ejecutándose?\n" +
                    "5. Salir");

            num = Ejercicio3.scanner.nextInt();

            switch (num){
                case 1:
                    lanzarP("whoami");
                    break;
                case 2:
                    lanzarP("hostname");
                    break;
                case 3:
                    lanzarP("time /t");
                    break;
                case 4:
                    lanzarP("tasklist");
                    break;
                case 5:
                    System.out.println("Adios");
                    break;
            }

        }while(num != 5);
    }
    public static void lanzarP(String comando) throws IOException {
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
