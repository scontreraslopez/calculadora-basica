package io.github.scontreraslopez;

/**
 * Calculadora de memoria secuencial.
 *
 * <p>Modela el comportamiento de una calculadora clásica: el usuario introduce un número
 * (que queda almacenado en memoria), elige una operación, introduce un segundo número y
 * ejecuta el cálculo. El resultado se almacena en memoria y puede consultarse en cualquier
 * momento mediante {@link #getMemoria()}.</p>
 *
 * <p>Flujo de uso básico:</p>
 * <pre>
 *   calculadora.ingresarNumero(5);
 *   calculadora.seleccionarOperacion(Operacion.SUMA);
 *   calculadora.ingresarNumero(3);
 *   calculadora.calcular();
 *   calculadora.getMemoria(); // → 8.0
 * </pre>
 */
public class Calculadora {

    /**
     * Operaciones aritméticas disponibles.
     */
    public enum Operacion {
        SUMA, RESTA, MULTIPLICACION, DIVISION
    }

    /** Valor actual en memoria (equivalente al display). */
    private double memoria;

    /** Primer operando guardado al seleccionar una operación. */
    private double operandoGuardado;

    /** Operación pendiente de ejecutar. {@code null} si no hay ninguna. */
    private Operacion operacionPendiente;

    /**
     * Crea una calculadora con la memoria inicializada a cero.
     */
    public Calculadora() {
        this.memoria = 0;
        this.operandoGuardado = 0;
        this.operacionPendiente = null;
    }

    /**
     * Introduce un número en la calculadora. El valor queda almacenado en memoria
     * y es visible en el display.
     *
     * @param numero el valor a introducir
     */
    public void ingresarNumero(double numero) {
        this.memoria = numero;
    }

    /**
     * Selecciona la operación aritmética a aplicar. El valor actual en memoria
     * se guarda como primer operando.
     *
     * @param op la operación deseada
     */
    public void seleccionarOperacion(Operacion op) {
        this.operandoGuardado = this.memoria;
        this.operacionPendiente = op;
    }

    /**
     * Ejecuta la operación pendiente usando el operando guardado y el valor actual
     * en memoria. El resultado se almacena en memoria.
     *
     * <p>Si no hay ninguna operación pendiente, no realiza ninguna acción.</p>
     */
    public void calcular() {
        if (operacionPendiente == null) return;
        switch (operacionPendiente) {
            case SUMA:           this.memoria = operandoGuardado + memoria; break;
            case RESTA:          this.memoria = operandoGuardado - memoria; break;
            case MULTIPLICACION: this.memoria = operandoGuardado * memoria; break;
            case DIVISION:       this.memoria = operandoGuardado / memoria; break;
        }
        this.operacionPendiente = null;
    }

    /**
     * Devuelve el valor actual almacenado en memoria (lo que mostraría el display).
     *
     * @return el valor en memoria
     */
    public double getMemoria() {
        return this.memoria;
    }

    /**
     * Reinicia la calculadora: pone la memoria a cero, borra el operando guardado
     * y cancela cualquier operación pendiente.
     */
    public void inicializarMemoria() {
        this.memoria = 0;
        this.operandoGuardado = 0;
        this.operacionPendiente = null;
    }

    /**
     * Devuelve el valor absoluto de un número.
     *
     * @param a el número de entrada
     * @return {@code a} si es positivo o cero, {@code -a} si es negativo
     */
    public double absoluto(double a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }

    /**
     * Indica si un número entero es par.
     *
     * @param a el número a comprobar
     * @return {@code true} si {@code a} es par, {@code false} en caso contrario
     */
    public boolean esPar(int a) {
        return a % 2 == 0;
    }

    /**
     * Redondea un número decimal hacia el entero inferior más próximo
     * (redondeo por defecto o hacia {@code -∞}).
     *
     * <p>A diferencia del cast directo a {@code int}, este método funciona
     * correctamente con números negativos: {@code redondearDefecto(-2.3)} devuelve
     * {@code -3}, no {@code -2}.</p>
     *
     * @param d el número a redondear
     * @return el entero inferior más próximo a {@code d}
     */
    public int redondearDefecto(double d) {
        int result = (int) d;
        if (d < 0) {
            result--;
        }
        return result;
    }
}
