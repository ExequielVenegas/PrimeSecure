import managers.InputOutputManager;
import utilities.PrimeGenerator;
import utilities.PrimesList;

import java.util.Scanner;

import static utilities.ConsoleUtil.*;

public class Main {
    public static void main(String[] args) {

        PrimesList globalPrimes = new PrimesList();
        InputOutputManager inputOutputManager= new InputOutputManager();


        //Menu navegación
        Scanner scan = new Scanner(System.in);
        int choice=5;
        do{
            choice = welcomeMenu(scan);
            switch (choice){
                case 1: // generar codigos usando hilos
                    inputOutputManager.runMultipleThreads(globalPrimes);
                    break;
                case 2: // mostrar codigos
                    System.out.println("Códigos generados: ");
                    globalPrimes.printSets();
                    break;
                case 3: // agregar codigo a lista oficial de codigos usados
                    break;
                case 4: // eliminar codigo
                    break;
                case 5: // salir
                    System.out.println("Saliendo del programa. Gracias por visitar el gestor de códigos PrimeSecure.");
                    break;
            }


        }while(choice!=5);




        //System.out.println("\n\n--- PRUEBAS CON HILOS (Generación Concurrente de Primos) ---");
     //   PrimesList globalPrimes = new PrimesList();

        // Crear varias tareas para generar primos en paralelo
        // Cada hilo procesará un rango diferente de números

        //TODO: GENERAR METODO QUE PIDA VALORES
        //TODO: MEJORAR LOGICA
       // Thread generator1 = new Thread(new utilities.PrimeGenerator(globalPrimes, 1, 500), "Generador-1");
       // Thread generator2 = new Thread(new utilities.PrimeGenerator(globalPrimes, 501, 1000), "Generador-2");

        // Iniciar los hilos
       // generator1.start();
        //generator2.start();

        System.out.println("Hilos generadores de primos iniciados. Esperando que terminen...");

        //try {
            // Esperar a que todos los hilos terminen su ejecución
          //  generator1.join();
            //generator2.join();
        //} catch (InterruptedException e) {
        //    System.err.println("El hilo principal fue interrumpido mientras esperaba a los hilos generadores.");
            Thread.currentThread().interrupt(); // Restablece el estado de interrupción
        }

        //System.out.println("\nTodos los hilos generadores han terminado.");
        //System.out.println("Cantidad total de primos encontrados por todos los hilos: " + globalPrimes.getPrimesCount());
        //System.out.println("Primos encontrados: " + globalPrimes);
    //}
}