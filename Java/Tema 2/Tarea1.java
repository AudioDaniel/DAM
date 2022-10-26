// La tarea 1 consiste en escribir un programa en Java que cumpla las siguientes condiciones:
//
//      El programa le pedirá al usuario que introduzca por teclado una serie de palabras (sin
//      límite).
//      Las palabras se introducirán como una lista de palabras separadas por ",".
//      A continuación se le darán al usuario dos opciones:
//         1. Filtrar
//         2. Dividir y ordenar
//
// Si el usuario introduce alguna opción no válida se le pedirá que vuelva a elegir una opción
// válida.
//
// Filtrar
//
// Si el usuario elige Filtrar se le pedirá una palabra (puede ser una única letra). El programa
// mostrará una lista de las palabras que empiecen por la cadena de texto que facilitó el usuario.
// La lista de palabras seleccionadas habrá de mostrarse ordenada.

// Dividir
//
// Si el usuario elige Dividir el programa le pedirá una palabra y le mostrará los listas de palabras
// ordenadas: la primera lista estará compuesta por las palabras anteriores lexicográficamente a
// la palabra introducida por el usuario, la segunda lista constará de las palabras
// lexicográficamente iguales y posteriores.

import java.util.Arrays;
import java.util.List;

public class Tarea1{


    public static String solicitaInput(){
        System.out.println("...");
        String inputUsuario = System.console().readLine();
        return inputUsuario;
    }

    public static String[] conversorArray(){

        String inputUsuario = solicitaInput();
        inputUsuario.strip();

        // Este fragmento creo que es mejor realizarlo a la inversa para evitar posibles problemas 

        if ((inputUsuario == null || inputUsuario.isEmpty())) 
            {
                System.out.println("Introduce una oración válida.");
                conversorArray();
            }
        
        String[] arrayPalabras = inputUsuario.split(",");
        Arrays.sort(arrayPalabras);

        return arrayPalabras;
        
    }

















    public static String filtrar(String[] arrayPalabras){
        System.out.println("Introduce una palabra para filtrar resultados.");
        System.out.println("Se te mostrarán palabras que empiecen por esos caracteres o por esa palabra");

        String palComparada;
        String palabraFiltro = solicitaInput();
        int valorComp;
        String[] resultados;
        
        System.out.println(palComparada.compareToIgnoreCase(palabraFiltro));

        int i , x;

        for (i = 0; i < arrayPalabras.length; i++) {
            x = arrayPalabras[i];
        }


        // Temporal,borrar
        return palabraFiltro;
    }




















    public static void main(String[] args) {

        System.out.println("Escribe tu lista de palabras separadas por comas.");
        String []arrayPalabras = conversorArray();

        System.out.println("Escoge el siguiente procedimiento 1 Filtrar o 2 Dividir y ordenar (Escribe un número)");

        int respuestaUsuario;

        do {
            respuestaUsuario = Integer.parseInt(System.console().readLine());
            }while (respuestaUsuario > 3 && respuestaUsuario < 0);

            if (respuestaUsuario == 1) {
                filtrar(arrayPalabras);
            }
        


        

    }
}
