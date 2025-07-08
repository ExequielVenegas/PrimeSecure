# PrimeSecureApp: Gestión y Generación Concurrente de Números Primos

Este proyecto implementa un sistema para la gestión eficiente de números primos, centrándose en la seguridad y el rendimiento mediante el uso de programación multihilo en Java. La aplicación es capaz de almacenar y manipular exclusivamente números primos, así como generarlos de forma concurrente para optimizar el rendimiento.

## Estructura del Proyecto

El proyecto está compuesto por las siguientes clases Java:

* **`utilities.PrimesList.java`**:
    * Extiende `ArrayList<Integer>` para crear una lista que solo permite almacenar números primos.
    * Incluye un método `isPrime(int number)` para verificar si un número es primo.
    * Sobrescribe los métodos `add()` y `remove()`, lanzando `IllegalArgumentException` si se intenta añadir o remover un número no primo.
    * Proporciona `getPrimesCount()` para obtener el número de primos en la lista.

* **`utilities.PrimeGenerator.java`**:
    * Implementa la interfaz `Runnable`.
    * Diseñada para ser ejecutada en un hilo separado (`Thread`).
    * Su tarea principal es generar números primos, utilizando sincronización para evitar problemas de concurrencia.

* **`Main.java`**:
    * Contiene el método `main()` para demostrar el uso de `utilities.PrimesList` y `utilities.PrimeGenerator`.
    * Muestra cómo se manipula la `utilities.PrimesList` (añadir, remover, etc.) y cómo múltiples `utilities.PrimeGenerator` pueden generar primos concurrentemente, añadiéndolos a una única `utilities.PrimesList`.

* **`PrimesListTest.java`**:
    * Clase de pruebas unitarias JUnit 5 para `utilities.PrimesList`.
    * Verifica la correcta funcionalidad de `isPrime`, los métodos de adición y eliminación con validación de primos.

## Requisitos

* **JDK 17** o superior.
* **JUnit 5** (gestionado automáticamente por Maven si el `pom.xml` está configurado correctamente).
