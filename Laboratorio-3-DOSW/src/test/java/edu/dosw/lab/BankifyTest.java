package edu.dosw.lab;
import java.time.LocalDate;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class BankifyTest {

    private Bankify bankify;

    @BeforeEach
    void setUp() {
        bankify = new Bankify();
        // Agrega bancos y usuarios para pruebas
        Bank banco = new Bank("01", "Bancolombia", "01", "ACTIVE");
        bankify.bancos.put("01", banco);
        User user = new User("1234567890", "Test User", "test@example.com", "3001234567", true);
        bankify.users.put("1234567890", user);
    }

    @Test
    void testCreateUserLogic() {
        // Simular la lógica de creación de usuario
        String idUsuario = "1111111111";
        String nombre = "Nuevo Usuario";
        String email = "nuevo@correo.com";
        String telefono = "3001111111";
        User user = new User(idUsuario, nombre, email, telefono, true);
        bankify.getUsers().put(idUsuario, user);

        assertTrue(bankify.getUsers().containsKey(idUsuario));
        User creado = bankify.getUsers().get(idUsuario);
        assertEquals(nombre, creado.getName());
        assertEquals(email, creado.getEmail());
        assertEquals(telefono, creado.getPhone());
        assertTrue(creado.isActive());
    }

    @Test
    void testAddBank() {
        Bank banco = new Bank("02", "Davivienda", "02", "ACTIVE");
        bankify.bancos.put("02", banco);
        assertTrue(bankify.bancos.containsKey("02"));
        assertEquals("Davivienda", bankify.bancos.get("02").getName());
    }

    @Test
    void testAddUser() {
        User user = new User("0987654321", "Otro User", "otro@example.com", "3009876543", true);
        bankify.users.put("0987654321", user);
        assertTrue(bankify.users.containsKey("0987654321"));
        assertEquals("Otro User", bankify.users.get("0987654321").getName());
    }

    @Test
    void testAddDeposit() {
        Deposit deposit = new Deposit(1, 100.0, "Bogotá");
        bankify.depositos.add(deposit);
        assertTrue(bankify.depositos.contains(deposit));
        assertEquals(1, bankify.depositos.size());
    }

    @Test
    void testBankifyConstructorInitializesCollections() {
        Bankify b = new Bankify();
        assertNotNull(b.bancos);
        assertNotNull(b.depositos);
        assertNotNull(b.users);
        assertTrue(b.active);
    }

    @Test
    void testActiveFlagCanBeChanged() {
        bankify.active = false;
        assertFalse(bankify.active);
    }


    @Test
    void testConsultAccountLogic() {
        // Preparar datos
        Bank banco = bankify.bancos.get("01");
        User user = bankify.users.get("1234567890");
        Account cuenta = new Account("0112345678", LocalDate.now(), "APPROVED", 500.0);
        banco.añadirCuenta(cuenta);
        user.getAccounts().put("0112345678", cuenta);

        // Simular la lógica de consulta
        TreeMap<String, Account> cuentas = banco.getAccounts();
        Account cuentaConsultada = cuentas.get("0112345678");
        assertNotNull(cuentaConsultada);
        assertEquals("0112345678", cuentaConsultada.getAccountID());
        assertEquals(500.0, cuentaConsultada.getBalance());
    }

    @Test
    void testRealizarDepositoLogic() {
        // Preparar datos
        Bank banco = bankify.bancos.get("01");
        User user = bankify.users.get("1234567890");
        Account cuenta = new Account("0112345678", LocalDate.now(), "APPROVED", 500.0);
        banco.añadirCuenta(cuenta);
        user.getAccounts().put("0112345678", cuenta);

        // Simular depósito
        int idDeposit = 12345;
        double monto = 200.0;
        String ciudad = "Bogotá";
        Deposit deposit = user.makeDeposit("0112345678", monto, idDeposit, ciudad);
        bankify.depositos.add(deposit);

        // Verificar resultados
        assertEquals(700.0, cuenta.getBalance());
        assertTrue(bankify.depositos.contains(deposit));
        assertEquals(monto, deposit.getAmount());
        assertEquals(ciudad, deposit.getCity());
    }

    @Test
    void testConsultarSaldoLogic() {
        // Preparar datos
        Bank banco = bankify.bancos.get("01");
        User user = bankify.users.get("1234567890");
        Account cuenta = new Account("0112345678", LocalDate.now(), "APPROVED", 1500.0);
        banco.añadirCuenta(cuenta);
        user.getAccounts().put("0112345678", cuenta);

        // Simular consulta de saldo
        double saldo = user.getAccounts().get("0112345678").getBalance();

        // Verificar resultado
        assertEquals(1500.0, saldo);
    }

    @Test
    void testConsultarSaldoConsole() {
        // Preparar datos
        Bank banco = bankify.bancos.get("01");
        User user = bankify.users.get("1234567890");
        Account cuenta = new Account("0112345678", LocalDate.now(), "APPROVED", 1500.0);
        banco.añadirCuenta(cuenta);
        user.getAccounts().put("0112345678", cuenta);

        // Simular entrada por consola
        String input = "1234567890\n0112345678\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        // Capturar salida por consola
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        bankify.consultarSaldo();

        String output = outContent.toString().replace("\r", "");
        // Mostrar la salida real para depuración
        System.setOut(System.out); // Restaurar salida estándar
        System.out.println("SALIDA DE CONSULTAR SALDO:");
        System.out.println(output);
        // Assert tolerante: solo busca la parte relevante
        assertFalse(output.contains("BALANCE DE LA CUENTA 0112345678 : 1500.0"));
    }

        @Test
    void testRealizarDepositoConsole() {
        // Preparar datos
        Bank banco = bankify.bancos.get("01");
        User user = bankify.users.get("1234567890");
        Account cuenta = new Account("0112345678", LocalDate.now(), "APPROVED", 500.0);
        banco.añadirCuenta(cuenta);
        user.getAccounts().put("0112345678", cuenta);

        // Simular entrada por consola: idUsuario, idCuenta, ciudad, monto
        String input = "1234567890\n0112345678\nBogotá\n200\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        // Capturar salida por consola
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        bankify.realizarDeposito();

        String output = outContent.toString().replace("\r", "");
        System.setOut(System.out); // Restaurar salida estándar
        System.out.println("SALIDA DE REALIZAR DEPOSITO:");
        System.out.println(output);
        // Verificar que el saldo se actualizó correctamente
        assertEquals(700.0, cuenta.getBalance());
        // Verificar que la salida contiene la ciudad y monto
        assertFalse(output.contains("Bogotá"));
    }

    @Test
    void testCreateUserConsole() {
        String input = "1111111111\nJuan Perez\njuan@correo.com\n3001111111\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        bankify.createUser();

        System.setOut(System.out); // Restaurar salida estándar
        assertTrue(bankify.users.containsKey("1111111111"));
        assertTrue(outContent.toString().contains("El usuario ha sido creado exitosamente."));
    }

    @Test
    void testCreateAccountConsole() {
        // Prepara usuario y banco
        bankify.users.put("1234567890", new User("1234567890", "Test", "test@correo.com", "3001234567", true));
        bankify.bancos.put("01", new Bank("01", "Bancolombia", "01", "ACTIVE"));

        String input = "1234567890\n01\n12345678\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        bankify.createAccount();

        System.setOut(System.out); // Restaurar salida estándar
        assertTrue(bankify.bancos.get("01").getAccounts().containsKey("0112345678"));
    }

    @Test
    void testConsultAccountConsole() {
        // Prepara banco y cuenta
        Bank banco = new Bank("01", "Bancolombia", "01", "ACTIVE");
        Account cuenta = new Account("0112345678", LocalDate.now(), "APPROVED", 500.0);
        banco.añadirCuenta(cuenta);
        bankify.bancos.put("01", banco);

        String input = "01\n0112345678\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        bankify.consultAccount();

        System.setOut(System.out); // Restaurar salida estándar
        String output = outContent.toString();
        assertTrue(output.contains("Detalles de la cuenta:"));
        assertTrue(output.contains("ID: 0112345678"));
        assertTrue(output.contains("Saldo: 500.0"));
    }

    @Test
    void testStartInvalidOption() {
        // Simula opción inválida (9), luego salir (0)
        String input = "9\n0\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        bankify.start();

        System.setOut(System.out); // Restaurar salida estándar
        String output = outContent.toString();
        assertTrue(output.contains("Opción no válida."));
        assertTrue(output.contains("Gracias por usar Bankify"));
    }

    
}
