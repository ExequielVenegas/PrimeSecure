class PrimeGenerator implements Runnable {
    private PrimesList primesList;
    private int startNumber;
    private int endNumber;

    public PrimeGenerator(PrimesList primesList, int startNumber, int endNumber) {
        this.primesList = primesList;
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - Iniciando generación de primos entre " + startNumber + " y " + endNumber);
        for (int i = startNumber; i <= endNumber; i++) {
            try {
                // Verificamos si el número es primo usando el metodo de PrimesList
                if (primesList.isPrime(i)) {
                    // Sincronizamos el acceso a la lista compartida para evitar condiciones de carrera.
                    // Para evitar problemas cuando múltiples hilos modifican el mismo recurso.
                    synchronized (primesList) {
                        primesList.add(i);
                    }
                }
            } catch (IllegalArgumentException e) {
                System.err.println(Thread.currentThread().getName() + " - Error inesperado al intentar agregar: " + e.getMessage());
            }
        }
        System.out.println(Thread.currentThread().getName() + " - Generación de primos finalizada.");
    }
}