package edu.dosw.lab;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private int bankID;
    private String name;
    private String prefix;
    private String status;

    private List<Account> accounts;

    public Bank(int bankID, String name, String prefix, String status){
        this.bankID = bankID;
        this.name = name;
        this.prefix = prefix;
        this.status = status;
        this.accounts = new ArrayList<>();
    }
    void crearCuenta(String numeroCuenta, LocalDate fechaCreacion, String estado, Double balance,Bank banco){
        Account cuenta = new Account(bankID, fechaCreacion, estado, bankID, banco);
        accounts.add(cuenta);
    }

    // Getters y setters
    public int getBankID() {return bankID;}

    public String getName() {return name;}

    public String getPrefix() {return prefix;}

    public String getStatus() {return status;}

    public void setBankID(int bankID) {this.bankID = bankID;}

    public void setName(String name) {this.name = name;}

    public void setPrefix(String prefix) {this.prefix = prefix;}

    public void setStatus(String status) {this.status = status;}

    public List<Account> getAccounts() {return accounts;}

    public void setAccounts(List<Account> accounts) {this.accounts = accounts;}
}
