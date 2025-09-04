package edu.dosw.lab;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Account implements AccountValidation{
    private String accountID;
    private LocalDate creationDate;
    private String state;
    private double balance;

    private List<Deposit> deposits;

    public Account(String accountID, LocalDate creationDate, String state, double balance) {
        assert(balance >= 0);
        this.accountID = accountID;
        this.creationDate = creationDate;
        this.state = state;
        this.balance = balance;
        this.deposits = new ArrayList<>();
        validateAccount(this);
    }

    // Getters y Setters
    public String getAccountID() {return accountID;}

    public double getBalance() {return balance;}

    public LocalDate getCreationDate() {return creationDate;}

    public String getState() {return state;}

    public void setAccountID(String accountID) {this.accountID = accountID;}

    public void setCreationDate(LocalDate creationDate) {this.creationDate = creationDate;}

    public void setState(String state) {this.state = state;}

    public void setBalance(double balance) {this.balance = balance;}

    public List<Deposit> getDeposits() {return deposits;}

    public void setDeposits(List<Deposit> deposits) {this.deposits = deposits;}

    /**
     * Realiza un depósito en la cuenta.
     *
     * <p>Este método crea un nuevo objeto {@link Deposit} con los datos
     * del depósito (monto, identificador y ciudad) y lo agrega a la lista
     * de depósitos asociados a la cuenta.</p>
     *
     * @param amount    monto del depósito, debe ser mayor que 0
     * @param idDeposit identificador único del depósito
     * @param city      ciudad donde se realiza el depósito
     * @return el objeto {@link Deposit} creado y agregado a la lista
     * @throws AssertionError si el monto es menor o igual a 0
     */
    public Deposit deposit(double amount, int idDeposit, String city) {
        Deposit deposit = new Deposit(idDeposit, amount, city);
        deposits.add(deposit);
        return deposit;
    }
    /**
     * Valida el estado de la cuenta según su balance.
     *
     * <p>Si el balance es mayor o igual a 0, la cuenta se marca como
     * {@link AccountValidation#APPROVED}. En caso contrario, se marca
     * como {@link AccountValidation#DENIED}.</p>
     *
     * @param account la cuenta a validar
     */
    @Override
    public void validateAccount(Account account) {
        if (account.getBalance() >= 0) {
            account.setState(APPROVED);
        } else {
            account.setState(DENIED);
        }
    }
}
