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
        int choice=6;
        do{
            choice = welcomeMenu(scan);
            switch (choice){
                case 1: // generar codigos usando hilos
                    inputOutputManager.runMultipleThreads(globalPrimes);
                    break;
                case 2: // mostrar codigos generados
                    System.out.println("Códigos generados: ");
                    globalPrimes.printSets();
                    break;
                case 3: // agregar codigo a lista oficial de codigos usados
                    inputOutputManager.addToOfficialList(globalPrimes);
                    break;
                case 4: // mostrar lista completa de codigos oficiales
                    System.out.println("Codigos oficiales ya registrados y en uso: " + globalPrimes);
                    break;
                case 5: // eliminar codigo
                    inputOutputManager.removeToOfficialList(globalPrimes);
                    break;
                case 6: // salir
                    System.out.println("Saliendo del programa. Gracias por visitar el gestor de códigos PrimeSecure.");
                    break;
            }


        }while(choice!=6);



        //TODO: GENERAR METODO QUE PIDA VALORES
        //TODO: MEJORAR LOGICA


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