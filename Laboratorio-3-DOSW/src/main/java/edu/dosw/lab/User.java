package edu.dosw.lab;

import java.time.LocalDate;

import java.util.TreeMap;

public class User {
    private String identification;
    private String name;
    private String email;
    private String phone;
    private boolean status;
    private TreeMap<String, Account> accounts;

    public User(String identification, String name, String email, String phone, boolean status) {
        this.identification = identification;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.accounts = new TreeMap<>();
    }

    
    // Getters and Setters
    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public boolean isActive() {
        return status;
    }
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public TreeMap<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(TreeMap<String, Account> accounts) {
        this.accounts = accounts;
    }

    //METODOS BANKIFY


    /**
     * Crea una nueva cuenta bancaria y la asocia al usuario actual.
     *
     * @param idCuenta       Identificador único de la cuenta (10 dígitos).
     * @param fechaCreacion  Fecha en la que se crea la cuenta.
     * @param state          Estado inicial de la cuenta (ej. "APPROVED" o "DENIED").
     * @param balance        Saldo inicial de la cuenta (no negativo).
     * @return La instancia de {@link Account} creada y registrada en el usuario.
     *
     * @throws AssertionError si el saldo inicial es negativo (validación en {@link Account}).
     */
        public Account createAccount(String idCuenta, LocalDate fechaCreacion, String state, Double balance) {
        Account cuenta = new Account(idCuenta, fechaCreacion, state, balance);
        accounts.put(idCuenta, cuenta);
        return cuenta;
    }

    /**
     * Realiza un depósito en una cuenta bancaria específica del usuario.
     *
     * @param idAccount  Identificador único de la cuenta donde se realizará el depósito.
     * @param amount     Monto a depositar (debe ser mayor que 0).
     * @param idDeposit  Identificador único generado para el depósito.
     * @param city       Ciudad desde donde se realiza la transacción.
     * @return La instancia de {@link Deposit} creada y asociada a la cuenta.
     *
     * @throws NullPointerException si la cuenta no existe en el usuario.
     * @throws AssertionError si el monto no cumple con las validaciones internas de {@link Deposit}.
     */

    public Deposit makeDeposit(String idAccount, Double amount, int idDeposit, String city) {
        Account account = accounts.get(idAccount);
        account.setBalance(account.getBalance() + amount);
        Deposit deposit = account.deposit(amount, idDeposit, city);
        return deposit;
    }

}
