package utilities;
import java.sql.SQLOutput;
import java.util.Scanner;
public class ConsoleUtil {

    public static int welcomeMenu (Scanner scan){
        System.out.println("-------------------------------------------------");
        System.out.println("    Bienvenido a PrimeSecure - Menú principal   ");
        System.out.println("-------------------------------------------------");
        System.out.println("1. GENERAR POSIBLES CÓDIGOS ");
        System.out.println("2. MOSTRAR SETS DE CÓDIGOS PRIMOS GENERADOS");
        System.out.println("3. AGREGAR A LISTA DE CÓDIGOS OFICIALES");
        System.out.println("4. ELIMINAR CÓDIGO DE LISTA DE CÓDIGOS OFICIALES");
        System.out.println("5. SALIR");
        System.out.println("Ingrese el número de su opción:");
        int choice = scan.nextInt();
        return choice;
    }
}
