package edu.dosw.lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    private Bank bank;

    @BeforeEach
    void setUp() {
        bank = new Bank("01", "Bancolombia", "01", "ACTIVE");
    }

    @Test
    void testBankCreation() {
        assertEquals("01", bank.getBankID());
        assertEquals("Bancolombia", bank.getName());
        assertEquals("01", bank.getPrefix());
        assertEquals("ACTIVE", bank.getStatus());
        assertNotNull(bank.getAccounts());
        assertTrue(bank.getAccounts().isEmpty());
    }

    @Test
    void testAddAccount() {
        Account account = new Account("0123456789", LocalDate.now(), "PENDING", 500.0);
        bank.añadirCuenta(account);

        assertEquals(1, bank.getAccounts().size());
        assertTrue(bank.getAccounts().containsKey(account.getAccountID()));
        assertEquals(account, bank.getAccounts().get(account.getAccountID()));
    }

    @Test
    void testSettersAndGetters() {
        bank.setBankID("02");
        bank.setName("Davivienda");
        bank.setPrefix("02");
        bank.setStatus("INACTIVE");

        assertEquals("02", bank.getBankID());
        assertEquals("Davivienda", bank.getName());
        assertEquals("02", bank.getPrefix());
        assertEquals("INACTIVE", bank.getStatus());
    }

    @Test
    void testSetAccounts() {
        TreeMap<String, Account> newAccounts = new TreeMap<>();
        Account account = new Account("9876543210", LocalDate.now(), "PENDING", 1000.0);
        newAccounts.put(account.getAccountID(), account);

        bank.setAccounts(newAccounts);

        assertEquals(1, bank.getAccounts().size());
        assertEquals(account, bank.getAccounts().get("9876543210"));
    }
}
