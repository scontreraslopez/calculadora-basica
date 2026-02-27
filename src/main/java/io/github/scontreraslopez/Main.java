package io.github.scontreraslopez;

/**
 * Punto de entrada de la aplicación.
 *
 * <p>Demuestra el uso básico de {@link Calculadora} siguiendo el flujo de una
 * calculadora clásica de memoria secuencial: introducir número, seleccionar
 * operación, introducir segundo número y calcular.</p>
 */
public class Main {

    /**
     * Ejecuta dos operaciones de ejemplo encadenadas:
     * <ol>
     *   <li>5 + 3 = 8</li>
     *   <li>8 / 2 = 4 (usando el resultado anterior que queda en memoria)</li>
     * </ol>
     *
     * @param args argumentos de línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        Calculadora c = new Calculadora();

        // 5 + 3 = 8
        c.ingresarNumero(5);
        c.seleccionarOperacion(Calculadora.Operacion.SUMA);
        c.ingresarNumero(3);
        c.calcular();
        System.out.println("5 + 3 = " + c.getMemoria());

        // El resultado (8) se queda en memoria, dividimos entre 2
        c.seleccionarOperacion(Calculadora.Operacion.DIVISION);
        c.ingresarNumero(2);
        c.calcular();
        System.out.println("8 / 2 = " + c.getMemoria());
    }
}
