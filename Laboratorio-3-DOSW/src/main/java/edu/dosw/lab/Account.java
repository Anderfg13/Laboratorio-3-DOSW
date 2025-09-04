package edu.dosw.lab;

import java.time.LocalDate;
import java.util.List;


public class Account implements AccountValidation{
    private int accountID;
    private LocalDate creationDate;
    private String state;
    private double balance;

    private Bank bank;
    private List<Deposit> deposits;

    public Account(int accountID, LocalDate creationDate, String state, double balance, Bank bank) {
        assert(balance >= 0);
        this.accountID = accountID;
        this.creationDate = creationDate;
        this.state = state;
        this.balance = balance;
        this.bank = bank;
    }

    // Getters y Setters
    public int getAccountID() {return accountID;}

    public double getBalance() {return balance;}

    public LocalDate getCreationDate() {return creationDate;}

    public String getState() {return state;}

    public void setAccountID(int accountID) {this.accountID = accountID;}

    public void setCreationDate(LocalDate creationDate) {this.creationDate = creationDate;}

    public void setState(String state) {this.state = state;}

    public void setBalance(double balance) {this.balance = balance;}

    public Bank getBank() {return bank;}

    public void setBank(Bank bank) {this.bank = bank;}

    public List<Deposit> getDeposits() {return deposits;}

    public void setDeposits(List<Deposit> deposits) {this.deposits = deposits;}

    @Override
    public void validate(Account account) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validate'");
    }
}
