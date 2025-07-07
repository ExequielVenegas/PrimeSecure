import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.PrimesList;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class PrimesListTest {

    private PrimesList primesList;

    @BeforeEach
    void setUp() {
        primesList = new PrimesList();
    }

    @Test
    @DisplayName("isPrime: Debe retornar true para números primos")
    void testIsPrime_TrueForPrimes() {
        assertTrue(primesList.isPrime(2));
        assertTrue(primesList.isPrime(3));
        assertTrue(primesList.isPrime(5));
        assertTrue(primesList.isPrime(7));
        assertTrue(primesList.isPrime(11));
        assertTrue(primesList.isPrime(17));
        assertTrue(primesList.isPrime(97));
    }

    @Test
    @DisplayName("isPrime: Debe retornar false para números no primos")
    void testIsPrime_FalseForNonPrimes() {
        assertFalse(primesList.isPrime(1)); // 1 no es primo
        assertFalse(primesList.isPrime(4));
        assertFalse(primesList.isPrime(6));
        assertFalse(primesList.isPrime(9));
        assertFalse(primesList.isPrime(10));
        assertFalse(primesList.isPrime(15));
        assertFalse(primesList.isPrime(100));

        assertFalse(primesList.isPrime(0));
        assertFalse(primesList.isPrime(-1));
        assertFalse(primesList.isPrime(-5));
    }

    @Test
    @DisplayName("add: Debe agregar un número primo correctamente")
    void testAdd_AddsPrimeSuccessfully() {
        assertTrue(primesList.add(2));
        assertEquals(1, primesList.size());
        assertEquals(2, primesList.get(0));
    }

    @Test
    @DisplayName("remove(Object): Debe remover un número primo correctamente")
    void testRemoveObject_RemovesPrimeSuccessfully() {
        primesList.add(2);
        primesList.add(3);
        primesList.add(5);

        assertTrue(primesList.remove(Integer.valueOf(3)));
        assertEquals(2, primesList.size());
        assertFalse(primesList.contains(3));
        assertEquals(Arrays.asList(2, 5), primesList);
    }

    // --- Tests para el método removeAll(Collection) ---
    @Test
    @DisplayName("removeAll: Debe remover una colección de primos correctamente")
    void testRemoveAll_RemovesPrimesCollectionSuccessfully() {
        primesList.addAll(Arrays.asList(2, 3, 5, 7, 11));
        List<Integer> toRemove = Arrays.asList(3, 7);

        assertTrue(primesList.removeAll(toRemove));
        assertEquals(3, primesList.size());
        assertEquals(Arrays.asList(2, 5, 11), primesList);
    }

    @Test
    @DisplayName("getPrimesCount: Debe retornar el conteo correcto de primos")
    void testGetPrimesCount() {
        assertEquals(0, primesList.getPrimesCount());
        primesList.add(2);
        assertEquals(1, primesList.getPrimesCount());
        primesList.add(3);
        primesList.add(5);
        assertEquals(3, primesList.getPrimesCount());
        primesList.remove(Integer.valueOf(3));
        assertEquals(2, primesList.getPrimesCount());
    }
}