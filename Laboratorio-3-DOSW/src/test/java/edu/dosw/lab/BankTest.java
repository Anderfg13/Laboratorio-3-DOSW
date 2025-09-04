package edu.dosw.lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    private Bank bank;
    private List<Account> accounts;

    @BeforeEach
    void setUp() {
        accounts = new ArrayList<>();
        accounts.add(new Account(
                1,
                java.time.LocalDate.of(2023, 1, 1),
                "ACTIVE",
                1000.0,
                null,
                new ArrayList<>()
        ));

        bank = new Bank();
        bank.setBankID(101);
        bank.setName("Banco Central");
        bank.setPrefix("BC");
        bank.setStatus("ACTIVE");
        bank.setAccounts(accounts);
    }

    @Test
    void testGettersReturnCorrectValues() {
        assertEquals(101, bank.getBankID());
        assertEquals("Banco Central", bank.getName());
        assertEquals("BC", bank.getPrefix());
        assertEquals("ACTIVE", bank.getStatus());
        assertEquals(accounts, bank.getAccounts());
    }

    @Test
    void testSettersUpdateValuesCorrectly() {
        List<Account> newAccounts = new ArrayList<>();
        Bank newBank = new Bank();

        newBank.setBankID(202);
        newBank.setName("Banco Nacional");
        newBank.setPrefix("BN");
        newBank.setStatus("INACTIVE");
        newBank.setAccounts(newAccounts);

        assertEquals(202, newBank.getBankID());
        assertEquals("Banco Nacional", newBank.getName());
        assertEquals("BN", newBank.getPrefix());
        assertEquals("INACTIVE", newBank.getStatus());
        assertEquals(newAccounts, newBank.getAccounts());
    }

    @Test
    void testSetAndGetAccounts() {
        List<Account> emptyAccounts = new ArrayList<>();
        bank.setAccounts(emptyAccounts);
        assertTrue(bank.getAccounts().isEmpty());
    }
}
