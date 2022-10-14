import java.util.Arrays;

public class Ejercicio4 {

    public static void main(String[] args) {

        System.out.println("Introduce las palabras separadas por espacios");

        String palabras = System.console().readLine();

        String[] listapalabras = palabras.split(" ");
        
        Arrays.sort(listapalabras);

        System.out.println(Arrays.toString(listapalabras));

        


    }
}