package edu.dosw.lab;


import java.time.LocalDate;
import java.util.Scanner;
import java.util.TreeMap;

public class Bankify {

    private TreeMap<String,Bank> bancos;
    
        public static void main(String[] args) {
            Bankify bankify = new Bankify();
            bankify.start();
 
        }
    
        public Bankify(){
            this.bancos = new TreeMap<>();
            crearBancos();
        }

        private void crearBancos(){
            Bank bancolombia = new Bank(01,"BANCOLOMBIA","01","Activo");
            Bank daviplata = new Bank(02,"DAVIPLATTA","02","Activo");
            insertarBanco("01", bancolombia);
            insertarBanco("02", daviplata);
        }
        private void start(){
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
    
        private void insertarBanco(String prefix,Bank banco){
            this.bancos.put(prefix, banco);
        }
    
        public static void crearCuenta() {
            System.out.println("Creando Cuenta...");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println("Que banco usara para crear su cuenta?(Escriba el prefijo)");
            Scanner scanner = new Scanner(System.in);
            String prefijo = scanner.nextLine();
            assert(this.bancos.containsKey(prefijo));

            Bank bancoDeLaCuenta = this.bancos.get(prefijo);
            
        
            System.out.println("Escriba su numero de cuenta");
            System.out.println("RECUERDE:\n- No se aceptan letras\n- No se aceptan caracteres especiales");

            int numerosFinalesDeCuenta = scanner.nextInt();
            String cantidadDigitos = String.valueOf(numerosFinalesDeCuenta);
            assert(cantidadDigitos.length() == 8);

            String numeroCuenta = prefijo + numerosFinalesDeCuenta;

            LocalDate fechaCreacion = LocalDate.now();

            bancoDeLaCuenta.crearCuenta(numeroCuenta,fechaCreacion,"ACTIVO",0.0,bancoDeLaCuenta);
            
            System.out.println("\n\n!FELICIDADES¡");
            System.out.println("Su cuenta ha sido creada con el numero de cuenta "+numeroCuenta+".");

            continuar();

            
            

            
    }
    private static void continuar(){
        System.out.println("Desea realizar otra consulta? (SI/NO)");
        Scanner scanner = new Scanner(System.in);
        String confirmacion = scanner.nextLine();
        scanner.close();
        if(confirmacion == "SI"){
            start();
        }
        
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
