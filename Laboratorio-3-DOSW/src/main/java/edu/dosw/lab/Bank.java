package edu.dosw.lab;

import java.util.List;

public class Bank {
    private int bankID;
    private String name;
    private String prefix;
    private String status;

    private List<Account> accounts;

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
