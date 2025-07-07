package managers;
import utilities.PrimeGenerator;
import utilities.PrimesList;
import utilities.PrimesList.*;

import java.util.Scanner;

public class InputOutputManager {
    Scanner scan = new Scanner (System.in);
    PrimesList primelist= new PrimesList();

    public void runMultipleThreads (PrimesList globalPrimes){
        System.out.println("Ingresa la cantidad de códigos a crear: (Se crearan este numero de sets con códigos validos para elegir)");
        int numberOfThreads = scan.nextInt();

        Thread [] threads = new Thread[numberOfThreads]; // crea un array con los números de threads que es fijo

        // recorrer el arreglo para agregar hilos generadores segun lo que pida el usuario
        for (int i=0; i<numberOfThreads; i++){
            // se creará un rango de 500 números automáticamente para buscar los primos en ese rango
            System.out.println("Ingrese el número de inicio del rango para generar el codigo " + (i+1) + " : (Se contemplará un rango de 20 números naturales)");
            int setNameNumber= i+1;
            int start= scan.nextInt();
            int end =start+10;

            // se genera el hilo

            PrimeGenerator generator = new PrimeGenerator(globalPrimes, start,end,setNameNumber);
            threads[i] = new Thread(generator, "Set de códigos: " + (i+1));
        }
        System.out.println("Generando códigos...");

        //iniciar hilos
        for(Thread t : threads){
            t.start();
        }

        //esperar que hilos terminen
        for (Thread t : threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Se han generado " + numberOfThreads + " rangos de códigos válidos" );
        System.out.println("Revisalos en la opción 2 del menú principal");
    }


    public void addToOfficialList(){
        System.out.println("Ingrese código para agregarlo a la lista de códigos oficiales en uso");
        int codigoAgregado = scan.nextInt();
        primelist.add(codigoAgregado);
    }
}
