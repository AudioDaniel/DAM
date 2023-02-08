import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;

// Se utiliza el fichero output.txt para almacenar en disco
public class Main {

    public static String userInput() {
        String input = System.console().readLine();
        return input;
    }

    public static void writeTextToFile(String fn, String txt) {
        try {
            FileWriter myWriter = new FileWriter(fn);

            String texto = txt;

            myWriter.write(texto + "\n");

            myWriter.close();
            System.out.println("Tu texto ha sido escrito.");
        } catch (IOException e) {
            System.out.println("Ha habido un problema");
            e.printStackTrace();
        }
    }

    static void mostrarFichero(String fichero) {

        try {
            BufferedReader myReader = new BufferedReader(new FileReader(fichero));

            String line = myReader.readLine();

            while (line != null) {
                System.out.println(line);
                // linea almacena la línea siguiente para poder iterar y que no se cree un
                // bucle infinito
                line = myReader.readLine();
            }
            myReader.close();
        }

        catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static void appendTextToFile(String fn, String txt) {
        try {
            BufferedWriter myWriter = new BufferedWriter(new FileWriter(fn, true));

            myWriter.write(txt + "\n");

            myWriter.close();
            System.out.println("Tu texto ha sido escrito.");
        } catch (IOException e) {
            System.out.println("Ha habido un error");
            e.printStackTrace();
        }
    }

    public static void appendLinesToFile(String fn, List<String> lines) {
        try {
            BufferedWriter myWriter = new BufferedWriter(new FileWriter(fn, true));

            for (int i = 0; i < lines.size(); i++) {
                myWriter.write(lines.get(i) + "\n");
            }

            myWriter.close();
            System.out.println("Tu texto ha sido escrito.");
        } catch (IOException e) {
            System.out.println("Ha habido un error");
            e.printStackTrace();
        }
    }

    public static List<String> readLinesFromFile(String fn) {
        try {
            BufferedReader myReader = new BufferedReader(new FileReader(fn));
            List<String> lines = new ArrayList<String>();

            String i;

            // Itera sobre el fichero añadiendo lineas hasta que readLine
            // de como resultado null (Fin del fichero)
            do {
                i = myReader.readLine();
                if (i != null) {
                    lines.add(i);
                }
            } while (i != null);

            myReader.close();
            return lines;
        } catch (IOException e) {
            System.out.println("Ha habido un error");
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        // Ejercicio 1 - //
        System.out.println("Introduce el nombre/ruta del fichero");
        String fn = userInput();
        System.out.println("Introduce la frase");
        String txt = userInput();
        writeTextToFile(fn, txt);

        mostrarFichero("output.txt");
        // - //

        // Ejercicio 2 - //
        System.out.println("Introduce el nombre/ruta del fichero");
        fn = userInput();
        System.out.println("Introduce la frase");
        txt = userInput();
        appendTextToFile(fn, txt);

        mostrarFichero("output.txt");
        // - //

        // Ejercicio 3 - //
        System.out.println("Introduce el nombre/ruta del fichero");
        fn = userInput();

        System.out.println("Introduce el número de oraciones que desees almacenar");
        int nFrases = Integer.parseInt(userInput());

        List<String> lines = new ArrayList<String>();
        System.out.println("Introduce tus oraciones para almacenarlas");
        while (nFrases > 0) {
            lines.add(userInput());
            nFrases--;
        }
        appendLinesToFile(fn, lines);

        mostrarFichero("output.txt");
        // - //

        // Ejercicio 4 - //
        System.out.println("Introduce el nombre/ruta del fichero");
        fn = userInput();
        readLinesFromFile(fn);
        mostrarFichero("output.txt");
        // - //

    }
}