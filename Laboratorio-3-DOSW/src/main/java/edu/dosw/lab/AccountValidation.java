package edu.dosw.lab;

public interface AccountValidation {
    String APPROVED = "Cuenta validada";
    String DENIED = "Cuenta no validada";

    

    void validateAccount(Account account);
}
