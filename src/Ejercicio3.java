import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio3 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        int cont = 0;
        String eleccion = "";
        // Creamos una lista para almacenar las líneas y no perderlas
        List<String> lineasProcesos = new ArrayList<>();

        ProcessBuilder tasklist = new ProcessBuilder("cmd", "/c", "tasklist");
        Process p = tasklist.start();

        InputStream salidaProceso = p.getInputStream();
        InputStreamReader conversor = new InputStreamReader(salidaProceso);
        BufferedReader lector = new BufferedReader(conversor);

        String linea;
        // Leemos, contamos y GUARDAMOS las líneas al mismo tiempo
        while((linea = lector.readLine()) != null) {
            lineasProcesos.add(linea);
            cont++;
        }

        System.out.println("Se han encontrado "  + cont + " procesos");

        do {
            try {
                System.out.println("¿Quieres mostrar la lista completa? (s/n).");
                eleccion = scanner.nextLine().trim(); // .trim() elimina espacios accidentales
            }catch (Exception e){
                System.out.println("error");
            }
            // Cambio clave: && en lugar de ||
        } while(!eleccion.equalsIgnoreCase("S") && !eleccion.equalsIgnoreCase("N") );

        // Convertimos a mayúscula para que coincida con los 'case'
        switch (eleccion.toUpperCase()){
            case "S":
                // Imprimimos el contenido almacenado en la lista
                for(String l : lineasProcesos) {
                    System.out.println(l);
                }
                break;
            case "N":
                System.out.println("Adios :D");
                break;
        }
    }
}