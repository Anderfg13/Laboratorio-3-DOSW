package edu.dosw.lab;

import java.time.LocalDate;

public class Deposit {
    private int movementID;
    private LocalDate movementDate;
    private double amount;

    private Account account;
    private Branch transactionPlace;

    // Getters y setters
    public int getMovementID() {return movementID;}

    public void setMovementID(int movementID) {this.movementID = movementID;}

    public LocalDate getMovementDate() {return movementDate;}

    public void setMovementDate(LocalDate movementDate) {this.movementDate = movementDate;}

    public double getAmount() {return amount;}

    public void setAmount(double amount) {this.amount = amount;}

    public Account getAccount() {return account;}

    public void setAccount(Account account) {this.account = account;}

    public Branch getTransactionPlace() {return transactionPlace;}

    public void setTransactionPlace(Branch transactionPlace) {this.transactionPlace = transactionPlace;}
}
