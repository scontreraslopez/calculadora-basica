package io.github.scontreraslopez;

import io.github.scontreraslopez.Calculadora;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class CalculadoraTest {

    Calculadora c;

    @BeforeEach
    void setUp() {
        c = new Calculadora();
    }

    @Test
    void getMemoria_objetoNuevo_devuelveCero() {
        assertEquals(0.0, c.getMemoria());
    }

    @Test
    void ingresarNumero_actualizaMemoria() {
        c.ingresarNumero(7.0);
        assertEquals(7.0, c.getMemoria());
    }

    @Test
    void calcular_suma_dosPositivos_devuelveResultadoCorrecto() {
        c.ingresarNumero(5);
        c.seleccionarOperacion(Calculadora.Operacion.SUMA);
        c.ingresarNumero(3);
        c.calcular();
        assertEquals(8.0, c.getMemoria());
    }

    @Test
    void calcular_resta_dosPositivos_devuelveResultadoCorrecto() {
        c.ingresarNumero(10);
        c.seleccionarOperacion(Calculadora.Operacion.RESTA);
        c.ingresarNumero(4);
        c.calcular();
        assertEquals(6.0, c.getMemoria());
    }

    @Test
    void calcular_multiplicacion_porCero_devuelveCero() {
        c.ingresarNumero(5);
        c.seleccionarOperacion(Calculadora.Operacion.MULTIPLICACION);
        c.ingresarNumero(0);
        c.calcular();
        assertEquals(0.0, c.getMemoria());
    }

    @Test
    void calcular_division_normal_devuelveResultadoCorrecto() {
        c.ingresarNumero(10);
        c.seleccionarOperacion(Calculadora.Operacion.DIVISION);
        c.ingresarNumero(2);
        c.calcular();
        assertEquals(5.0, c.getMemoria());
    }

    @Test
    void calcular_division_porCero_devuelveInfinitoPositivo() {
        c.ingresarNumero(1);
        c.seleccionarOperacion(Calculadora.Operacion.DIVISION);
        c.ingresarNumero(0);
        c.calcular();
        assertEquals(Double.POSITIVE_INFINITY, c.getMemoria());
    }

    @Test
    void inicializarMemoria_trasOperacion_reiniciaMemoriaACero() {
        c.ingresarNumero(5);
        c.seleccionarOperacion(Calculadora.Operacion.SUMA);
        c.ingresarNumero(3);
        c.calcular();                  // memoria = 8.0
        c.inicializarMemoria();
        assertEquals(0.0, c.getMemoria());
    }

    @Test
    void absoluto_positivo_devuelveMismo() {
        assertEquals(3.0, c.absoluto(3.0));
    }

    @Test
    void absoluto_negativo_devuelvePositivo() {
        assertEquals(3.0, c.absoluto(-3.0));
    }

    @Test
    void absoluto_cero_devuelveCero() {
        assertEquals(0.0, c.absoluto(0.0));
    }

    @Test
    void esPar_numeroParPositivo_devuelveTrue() {
        assertTrue(c.esPar(4));
    }

    @Test
    void esPar_numeroImparPositivo_devuelveFalse() {
        assertFalse(c.esPar(3));
    }

    @Test
    void esPar_cero_devuelveTrue() {
        assertTrue(c.esPar(0));
    }

    @Test
    void esPar_numeroParNegativo_devuelveTrue() {
        assertTrue(c.esPar(-4));
    }

    @Test
    void esPar_numeroImparNegativo_devuelveFalse() {
        assertFalse(c.esPar(-3));
    }

    @Test
    void redondearDefecto_positivoConDecimales_redondeoHaciaAbajo() {
        assertEquals(2, c.redondearDefecto(2.7));     // CP-RD-01
    }

    @Test
    void redondearDefecto_positivoEntero_sinDecimales() {
        assertEquals(2, c.redondearDefecto(2.0));     // CP-RD-02
    }

    @Test
    void redondearDefecto_cero_devuelveCero() {
        assertEquals(0, c.redondearDefecto(0.0));     // CP-RD-03
    }

    @Test
    void redondearDefecto_negativoConDecimalesCercaCero_redondeoHaciaAbajo() {
        assertEquals(-1, c.redondearDefecto(-0.5));   // CP-RD-04
    }

    @Test
    void redondearDefecto_negativoConDecimales_redondeoHaciaAbajo() {
        assertEquals(-2, c.redondearDefecto(-1.5));   // CP-RD-05
    }

    @Test
    void redondearDefecto_negativoEnteroExacto_sinDecimales() {
        assertEquals(-1, c.redondearDefecto(-1.0));   // CP-RD-06: límite crítico
    }

    @Test
    void redondearDefecto_negativoEnteroExactoMayor_sinDecimales() {
        assertEquals(-2, c.redondearDefecto(-2.0));   // CP-RD-07: límite crítico
    }

    @ParameterizedTest
    @CsvSource({
            "2.7, 2", // positivo con decimales
            "2.0, 2", // positivo entero
            "0.0, 0", // cero
            "-0.5, -1", // negativo con decimales
            "-1.5, -2", // negativo con decimales
            "-1.0, -1", // negativo entero
            "-2.0, -2"  // negativo entero
    })
    void redondearDefecto_parametrizado(double input, int expected) {
        assertEquals(expected, c.redondearDefecto(input));
    }

}