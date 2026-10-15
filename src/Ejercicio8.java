import java.io.IOException;
import java.util.Scanner;

public class Ejercicio8 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        boolean acaba = false;
        while(acaba == false){
            int opcion = 0;
            System.out.println("¿Cuál es tu aplicación favorita? \n" +
                    "1. Paint\n" +
                    "2. Calculadora\n" +
                    "3. Bloc de notas");
            opcion = scanner.nextInt();

            int numAl = (int) (Math.random() * ((3 - 1) + 1) + 1);


            if (numAl == opcion) {
                switch (opcion) {
                    case 1:
                        abrirP("mspaint");
                        acaba = true;
                        break;
                    case 2:
                        abrirP("calc");
                        acaba = true;
                        break;
                    case 3:
                        abrirP("notepad");
                        acaba = true;
                        break;


                }

            } else {
                System.out.println("No has tenido suerte");
        }
    }

    }
    public static void abrirP(String p) throws IOException {
        ProcessBuilder pb = new ProcessBuilder(p);

        Process pr = pb.start();

    }
}
