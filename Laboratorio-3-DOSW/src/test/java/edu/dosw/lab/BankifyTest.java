package edu.dosw.lab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankifyTest {

    @Test
    void testCrearCuenta() {
        // TODO: implementar la prueba de crearCuenta
        // Aquí iría la lógica cuando el método tenga funcionalidad real
        Bankify.crearCuenta();
        // Ejemplo: assertNotNull(...);
    }

    @Test
    void testValidarCuenta() {
        // TODO: implementar la prueba de validarCuenta
        Bankify.validarCuenta();
        // Ejemplo: verificar que imprime "Validando cuenta..."
    }

    @Test
    void testConsultarSaldo() {
        // TODO: implementar la prueba de consultarSaldo
        Bankify.consultarSaldo();
        // Ejemplo: verificar que imprime "Consultando saldo..."
    }

    @Test
    void testDepositarDinero() {
        // TODO: implementar la prueba de depositarDinero
        Bankify.depositarDinero();
        // Ejemplo: verificar que imprime "Depositando dinero..."
    }
}
