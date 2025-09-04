package edu.dosw.lab;

import java.util.TreeMap;

public class Bank {
    private String bankID;
    private String name;
    private String prefix;
    private String status;

    private TreeMap<String, Account> accounts;

    public Bank(String bankID, String name, String prefix, String status){
        this.bankID = bankID;
        this.name = name;
        this.prefix = prefix;
        this.status = status;
        this.accounts = new TreeMap<>();
    }

    // Getters y setters
    public String getBankID() {return bankID;}

    public String getName() {return name;}

    public String getPrefix() {return prefix;}

    public String getStatus() {return status;}

    public void setBankID(String bankID) {this.bankID = bankID;}

    public void setName(String name) {this.name = name;}

    public void setPrefix(String prefix) {this.prefix = prefix;}

    public void setStatus(String status) {this.status = status;}

    public TreeMap<String, Account> getAccounts() {return accounts;}

    public void setAccounts(TreeMap<String,Account> accounts) {this.accounts = accounts;}


    public void añadirCuenta(Account cuenta){
        accounts.put(cuenta.getAccountID(), cuenta);
    }
}
