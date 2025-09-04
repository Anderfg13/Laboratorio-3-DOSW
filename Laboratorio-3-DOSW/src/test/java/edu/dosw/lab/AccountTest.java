package edu.dosw.lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account("1234567890", LocalDate.now(), "PENDING", 1000.0);
        account.setDeposits(new ArrayList<>());
    }

    @Test
    void testAccountCreation() {
        assertEquals("1234567890", account.getAccountID());
        assertEquals(1000.0, account.getBalance());
        assertNotNull(account.getCreationDate());
        assertEquals(AccountValidation.APPROVED, account.getState()); // porque balance >= 0
    }

    @Test
    void testDepositIncreasesBalanceAndAddsDeposit() {
        int initialDeposits = account.getDeposits().size();

        Deposit deposit = account.deposit(500.0, 1, "Bogotá");

        assertNotNull(deposit);
        assertEquals(initialDeposits + 1, account.getDeposits().size());
        assertTrue(account.getDeposits().contains(deposit));
        assertEquals(500.0, deposit.getAmount());
        assertEquals("Bogotá", deposit.getCity());
    }

    @Test
    void testValidateAccountApproved() {
        account.setBalance(100);
        account.validateAccount(account);
        assertEquals(AccountValidation.APPROVED, account.getState());
    }

    @Test
    void testValidateAccountDenied() {
        account.setBalance(-50);
        account.validateAccount(account);
        assertEquals(AccountValidation.DENIED, account.getState());
    }

    @Test
    void testAssertPreventsNegativeBalanceOnCreation() {
        assertThrows(AssertionError.class, () -> {
            new Account("0987654321", LocalDate.now(), "PENDING", -100);
        });
    }
}