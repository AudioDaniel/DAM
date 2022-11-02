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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tarea1{


    public static String solicitaInput(){
        System.out.println("...");
        String inputUsuario = (System.console().readLine()).toLowerCase();
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


    // Este metodo itera sobre el array de palabras e comprobando si comienzan por la palabra filtro. Si es así
    // imprime por pantalla el elemento del array.

    public static void filtrar(String[] arrayPalabras){
        System.out.println("Introduce una palabra para filtrar resultados.");
        System.out.println("Se te mostrarán palabras que empiecen por esos caracteres o por esa palabra");

        String palComparada;
        String palabraFiltro = solicitaInput();
                
        int contador ;

        for (contador = 0; contador < arrayPalabras.length; contador++) 
        {
            palComparada = arrayPalabras[contador];

            if (palComparada.startsWith(palabraFiltro)) {
                System.out.println(palComparada);
            }
        }
    }


    public static void dividir(String[] arrayPalabras){

        System.out.println("Introduce una palabra para comprobar las anteriores y posteriores lexicográficamente");
        String palDivisora = solicitaInput();
        List<String> palAnteriores = new ArrayList<>();
        List<String> palPosteriores = new ArrayList<>();
        int contador;

        for (contador = 0; contador < arrayPalabras.length; contador++) 
        {
            if ((arrayPalabras[contador].compareTo(palDivisora)) < 0) {
                palAnteriores.add(arrayPalabras[contador]);
            }
            if ((arrayPalabras[contador].compareTo(palDivisora)) >= 0) {
                palPosteriores.add(arrayPalabras[contador]);
            }
        }


        System.out.println("---------------------------------------------");
        System.out.println("<PALABRAS ANTERIORES>");
        System.out.println(palAnteriores.toString());
        System.out.println("---------------------------------------------");
        System.out.println("<TU PALABRA>");
        System.out.println(palDivisora);
        System.out.println("---------------------------------------------");
        System.out.println("<PALABRAS POSTERIORES>");
        System.out.println(palPosteriores.toString());
        System.out.println("---------------------------------------------");


    }





    public static void main(String[] args) {

        System.out.println("Escribe tu lista de palabras separadas por comas.");
        String []arrayPalabras = conversorArray();

        System.out.println("Escoge el siguiente procedimiento 1 Filtrar o 2 Dividir y ordenar (Escribe un número).");
        System.out.println("Introduce 3 para salir del programa");

        int respuestaUsuario;

        do {
            respuestaUsuario = Integer.parseInt(System.console().readLine());
            }while (respuestaUsuario > 3 && respuestaUsuario < 0);

            if (respuestaUsuario == 1) {
                filtrar(arrayPalabras);
            }
            if (respuestaUsuario == 2) {
                dividir(arrayPalabras);
            }
            if (respuestaUsuario == 3) {
                System.exit(0);
            }

    }
}
