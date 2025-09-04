package edu.dosw.lab;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private Account account;
    private Bank bank;
    private List<Deposit> deposits;

    @BeforeEach
    void setUp() {
        bank = new Bank(); 
        deposits = new ArrayList<>();
        deposits.add(new Deposit()); 

        account = new Account(
                1,
                LocalDate.of(2023, 1, 1),
                "ACTIVE",
                500.0,
                bank,
                deposits
        );
    }

    @Test
    void testGettersReturnCorrectValues() {
        assertEquals(1, account.getAccountID());
        assertEquals(LocalDate.of(2023, 1, 1), account.getCreationDate());
        assertEquals("ACTIVE", account.getState());
        assertEquals(500.0, account.getBalance());
        assertEquals(bank, account.getBank());
        assertEquals(deposits, account.getDeposits());
    }

    @Test
    void testSettersUpdateValuesCorrectly() {
        Bank newBank = new Bank();
        List<Deposit> newDeposits = new ArrayList<>();

        account.setAccountID(2);
        account.setCreationDate(LocalDate.of(2024, 5, 15));
        account.setState("INACTIVE");
        account.setBalance(1000.0);
        account.setBank(newBank);
        account.setDeposits(newDeposits);

        assertEquals(2, account.getAccountID());
        assertEquals(LocalDate.of(2024, 5, 15), account.getCreationDate());
        assertEquals("INACTIVE", account.getState());
        assertEquals(1000.0, account.getBalance());
        assertEquals(newBank, account.getBank());
        assertEquals(newDeposits, account.getDeposits());
    }

    @Test
    void testConstructorBalanceCannotBeNegative() {
        assertThrows(AssertionError.class, () -> {
            new Account(3, LocalDate.now(), "ACTIVE", -100.0, bank, deposits);
        });
    }
}
