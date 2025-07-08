package utilities;

public class PrimeGenerator implements Runnable {
    private PrimesList primesList;
    private int startNumber;
    private int endNumber;
    private int setName;





    // setter and getters
    public PrimesList getPrimesList() {
        return primesList;
    }
    public void setPrimesList(PrimesList primesList) {
        this.primesList = primesList;
    }

    public int getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(int startNumber) {
        this.startNumber = startNumber;
    }

    public int getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(int endNumber) {
        this.endNumber = endNumber;
    }



    public PrimeGenerator(PrimesList primesList, int startNumber, int endNumber, int setName) {
        this.primesList = primesList;
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        this.setName= setName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - Iniciando generación de primos entre " + startNumber + " y " + endNumber);
        for (int i = startNumber; i <= endNumber; i++) {
            try {
                // Verificamos si el número es primo usando el metodo de utilities.PrimesList
                if (primesList.isPrime(i)) {
                    // Sincronizamos el acceso a la lista compartida para evitar condiciones de carrera.
                    // Para evitar problemas cuando múltiples hilos modifican el mismo recurso.
                    synchronized (primesList) {
                        primesList.addToSet(setName, i);
                    }
                }
            } catch (IllegalArgumentException e) {
                System.err.println(Thread.currentThread().getName() + " - Error inesperado al intentar agregar: " + e.getMessage());
            }
        }
        System.out.println(Thread.currentThread().getName() + "] Generación terminada para el set \"" + setName + "\".");
    }
}