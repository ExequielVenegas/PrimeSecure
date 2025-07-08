package utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimesList extends ArrayList<Integer> {

    private final Map<String, List<Integer>> primeSets = new HashMap<>(); // para guardar los sets de codigos generados por hilo


    /**
     * Verifica si un número dado es primo.
     * Un número primo es un número natural mayor que 1 que no tiene divisores positivos
     * aparte de 1 y él mismo.
     */
    public boolean isPrime(int number) {
        if (number <= 1) {
            return false; // Los números menores o iguales a 1 no son primos
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false; // Si tiene un divisor, no es primo
            }
        }
        return true; // Si no se encontraron divisores, es primo
    }

    @Override
    public boolean add(Integer element) {
        if (element == null) {
            throw new IllegalArgumentException("No se puede agregar un valor nulo a la lista.");
        }
        if (!isPrime(element)) {
            // Lanza una excepción si el número no es primo
            throw new IllegalArgumentException("El número " + element + " no es primo y no puede ser agregado a utilities.PrimesList.");
        }
        // Si es primo, lo agrega a la lista subyacente de ArrayList
        return super.add(element);
    }

    @Override
    public boolean remove(Object o) {
        if (o instanceof Integer) {
            Integer element = (Integer) o;
            if (!isPrime(element)) {
                // Si se intenta remover un número no primo, lanza una excepción
                throw new IllegalArgumentException("No se puede manipular (remover) el número no primo " + element + " de utilities.PrimesList.");
            }
            // Si es primo, procede con la eliminación normal
            return super.remove(o);
        }
        return super.remove(o);
    }

    public int getPrimesCount() {
        return this.size();
    }

    public synchronized void addToSet (int setName, int number){
        if(!isPrime(number)) {
        throw new IllegalArgumentException("El número " + number + " no es primo. No se puede agregar");
        }
        this.add(number); // agrega a la lista global
        // agrega al conjunto correspondiente
        primeSets.computeIfAbsent(String.valueOf(setName), key -> new ArrayList<>()).add(number); // esta funcion la vi, no la decrifré yo
    }

    public void printSets(){
        if(primeSets.isEmpty()){
            System.out.println("No se han generado sets de códigos");
            return;
        }
        for (String name : primeSets.keySet()) {
            List<Integer> set = primeSets.get(name);
            System.out.println("Set: " + name + " (" + set.size() + " números)");
            for (Integer prime : set) {
                System.out.println("🔒 " +  prime );
            }
        }
    }

}