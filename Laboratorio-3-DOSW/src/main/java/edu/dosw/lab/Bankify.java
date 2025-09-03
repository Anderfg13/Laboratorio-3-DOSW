package edu.dosw.lab;


import java.util.Scanner;

public class Bankify {
    public static void main(String[] args) {
        System.out.println("Bienvenido a Bankify!");
        System.out.println("Por favor, elige una opción:");
        System.out.println("1. Crear cuenta");
        System.out.println("2. Validar cuenta");
        System.out.println("3. Consultar saldo");
        System.out.println("4. Depositar dinero");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        if (opcion == 1) {
            crearCuenta();
        } else if (opcion == 2) {
            validarCuenta();
        } else if (opcion == 3) {
            consultarSaldo();
        } else if (opcion == 4) {
            depositarDinero();
        } else {
            System.out.println("Opción no válida");
        }
        scanner.close();
    }

    public static void crearCuenta() {

    }

    public static void validarCuenta() {
        System.out.println("Validando cuenta...");
    }

    public static void consultarSaldo() {
        System.out.println("Consultando saldo...");
    }

    public static void depositarDinero() {
        System.out.println("Depositando dinero...");
    }

}
