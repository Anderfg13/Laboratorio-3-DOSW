package edu.dosw.lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DepositTest {

    private Deposit deposit;

    @BeforeEach
    void setUp() {
        deposit = new Deposit(1, 500.0, "Bogotá");
    }

    @Test
    void testDepositCreation() {
        assertEquals(1, deposit.getMovementID());
        assertEquals(500.0, deposit.getAmount());
        assertNotNull(deposit.getMovementDate());
        assertEquals(LocalDate.now(), deposit.getMovementDate()); // Fecha del sistema
        assertEquals("Bogotá", deposit.getCity());
    }

    @Test
    void testSettersAndGetters() {
        deposit.setMovementID(2);
        deposit.setAmount(1000.0);
        deposit.setMovementDate(LocalDate.of(2025, 9, 3));

        assertEquals(2, deposit.getMovementID());
        assertEquals(1000.0, deposit.getAmount());
        assertEquals(LocalDate.of(2025, 9, 3), deposit.getMovementDate());
    }

    @Test
    void testAssociateAccount() {
        Account account = new Account("1234567890", LocalDate.now(), "PENDING", 1000.0);
        deposit.setAccount(account);

        assertNotNull(deposit.getAccount());
        assertEquals(account, deposit.getAccount());
    }

    @Test
    void testTransactionPlaceAndCity() {
        Branch branch = new Branch("DEPOSITO", "Medellín");
        deposit.setTransactionPlace(branch);

        assertNotNull(deposit.getTransactionPlace());
        assertEquals("Medellín", deposit.getTransactionPlace().getLocation().getCity());
    }

    @Test
    void testAssertPreventsNegativeDeposit() {
        assertThrows(AssertionError.class, () -> {
            new Deposit(2, -200.0, "Cali");
        });
    }
}
