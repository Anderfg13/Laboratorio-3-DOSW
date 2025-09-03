package edu.dosw.lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DepositTest {

    private Deposit deposit;
    private Account account;
    private Branch branch;

    @BeforeEach
    void setUp() {
        account = new Account(
                1,
                LocalDate.of(2023, 1, 1),
                "ACTIVE",
                500.0,
                null,
                java.util.Collections.emptyList()
        );

        branch = new Branch();
        deposit = new Deposit();

        deposit.setMovementID(1001);
        deposit.setMovementDate(LocalDate.of(2023, 5, 10));
        deposit.setAmount(250.50);
        deposit.setAccount(account);
        deposit.setTransactionPlace(branch);
    }

    @Test
    void testGettersReturnCorrectValues() {
        assertEquals(1001, deposit.getMovementID());
        assertEquals(LocalDate.of(2023, 5, 10), deposit.getMovementDate());
        assertEquals(250.50, deposit.getAmount());
        assertEquals(account, deposit.getAccount());
        assertEquals(branch, deposit.getTransactionPlace());
    }

    @Test
    void testSettersUpdateValuesCorrectly() {
        Account newAccount = new Account(
                2,
                LocalDate.of(2024, 2, 2),
                "INACTIVE",
                0.0,
                null,
                java.util.Collections.emptyList()
        );
        Branch newBranch = new Branch();

        deposit.setMovementID(2002);
        deposit.setMovementDate(LocalDate.of(2024, 6, 15));
        deposit.setAmount(999.99);
        deposit.setAccount(newAccount);
        deposit.setTransactionPlace(newBranch);

        assertEquals(2002, deposit.getMovementID());
        assertEquals(LocalDate.of(2024, 6, 15), deposit.getMovementDate());
        assertEquals(999.99, deposit.getAmount());
        assertEquals(newAccount, deposit.getAccount());
        assertEquals(newBranch, deposit.getTransactionPlace());
    }
}
