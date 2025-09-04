package edu.dosw.lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
 
class UserTest {
    @Test
    void testSetAndGetIdentification() {
        user.setIdentification("9876543210");
        assertEquals("9876543210", user.getIdentification());
    }

    @Test
    void testSetAndGetName() {
        user.setName("Nuevo Nombre");
        assertEquals("Nuevo Nombre", user.getName());
    }

    @Test
    void testSetAndGetEmail() {
        user.setEmail("nuevo@email.com");
        assertEquals("nuevo@email.com", user.getEmail());
    }

    @Test
    void testSetAndGetPhone() {
        user.setPhone("3009999999");
        assertEquals("3009999999", user.getPhone());
    }

    @Test
    void testSetAndGetStatus() {
        user.setStatus(false);
        assertFalse(user.isStatus());
        user.setStatus(true);
        assertTrue(user.isStatus());
    }

    @Test
    void testSetAndGetAccounts() {
        TreeMap<String, Account> newAccounts = new TreeMap<>();
        Account acc = new Account("0123456789", LocalDate.now(), "APPROVED", 100.0);
        newAccounts.put("0123456789", acc);
        user.setAccounts(newAccounts);
        assertEquals(newAccounts, user.getAccounts());
        assertTrue(user.getAccounts().containsKey("0123456789"));
    }
    private User user;
    private Bank bancolombia;
    private Bank davivienda;
 
    @BeforeEach
    void setUp() {
        user = new User("1234567890", "Test User", "test@example.com", "3001234567", true);
        bancolombia = new Bank("01", "BANCOLOMBIA", "01", "ACTIVE");
        davivienda = new Bank("02", "DAVIVIENDA", "02", "ACTIVE");
    }
 
    @Test
    @DisplayName("Test de creación de cuenta bancaria")
    void testCreateAccount() {
        Account account = user.createAccount("0123456789", LocalDate.now(), "PENDING", 0.0);
        assertAll("Validación de creación de cuenta",
            () -> assertNotNull(account, "La cuenta no debe ser null"),
            () -> assertTrue(user.getAccounts().containsKey(account.getAccountID()), 
                           "La cuenta debe estar en la lista de cuentas del usuario"),
            () -> assertTrue(account.getAccountID().startsWith("01"), 
                           "El número de cuenta debe empezar con el prefijo del banco")
        );
    }
 
    
 
    @Test
    @DisplayName("Test de múltiples cuentas en diferentes bancos")
    void testMultipleAccountsDifferentBanks() {
        Account bancolombiaAccount = user.createAccount("0123456789", LocalDate.now(), "PENDING", 0.0);
        Account daviviendaAccount = user.createAccount("0223456789", LocalDate.now(), "PENDING", 0.0);
        assertAll("Validación de múltiples cuentas",
            () -> assertEquals(2, user.getAccounts().size(), 
                             "El usuario debe tener dos cuentas"),
            () -> assertTrue(bancolombiaAccount.getAccountID().startsWith("01"), 
                           "La cuenta de Bancolombia debe empezar con 01"),
            () -> assertTrue(daviviendaAccount.getAccountID().startsWith("02"), 
                           "La cuenta de Davivienda debe empezar con 02")
        );
    }
}