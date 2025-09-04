package edu.dosw.lab;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Bankify {

    public TreeMap<String,Bank> bancos;
    public List<Deposit> depositos;
    public TreeMap<String,User> users;
    public boolean active;

    public Bankify() {
        this.bancos = new TreeMap<>();
        this.depositos = new ArrayList<>();
        this.users = new TreeMap<>();
        this.active = true;
    }


    public TreeMap<String,User> getUsers() {
        return users;
    }

    public boolean isActive() {
        return active;
    }

    public static void main(String[] args) {
        Bankify bankify = new Bankify();
        bankify.start();
    }

    /**
     * Inicia la aplicación de consola de Bankify y muestra el menú principal.
     *
     * Este método utiliza un bucle principal para mostrar opciones
     * al usuario y ejecutar las acciones correspondientes mediante
     * un mapa de opciones (Map) que asocia números con métodos
     * de la clase a través de Runnable.
     *
     * Las opciones disponibles son:
     * 1 - Crear Usuario
     * 2 - Consultar Cuenta
     * 3 - Crear Cuenta
     * 4 - Consultar Saldo de Cuenta
     * 5 - Realizar Depósito
     * 6 - Validar Cuenta
     * 0 - Salir
     *
     * Si el usuario ingresa una opción inválida, se mostrará
     * un mensaje de error.
     *
     * El bucle finaliza cuando el usuario selecciona la opción 0,
     * lo que desactiva la variable active y cierra el Scanner.
     */
    public void start() {
        System.out.println("===== BIENVENIDO A BANKIFY =====\n");
        Scanner scanner = new Scanner(System.in);

        // Map de opciones -> acciones
        Map<Integer, Runnable> actions = new HashMap<>();
        actions.put(1, this::createUser);
        actions.put(2, this::consultAccount);
        actions.put(3, this::createAccount);
        actions.put(4, this::consultarSaldo);
        actions.put(5, this::realizarDeposito);
        actions.put(0, () -> {
            System.out.println("Gracias por usar Bankify. ¡Hasta luego!");
            active = false;
        });

        while (active) {
            System.out.println("== MENU PRINCIPAL ==");
            System.out.println("1. Crear Usuario");
            System.out.println("2. Consultar Cuenta");
            System.out.println("3. Crear Cuenta");
            System.out.println("4. Consultar Saldo de Cuenta");
            System.out.println("5. Realizar Deposito");
            System.out.println("6. Validar Cuenta");  
            System.out.println("0. Salir");

            int opcion = scanner.nextInt();
            actions.getOrDefault(opcion, () -> System.out.println("Opción no válida."))
                .run();
        }

        scanner.close();

    }

    
    // METODOS PRINCIPALES DE BANKIFY

    /**
     * Crea un nuevo usuario en el sistema Bankify.
     *
     * Este método solicita al usuario la información necesaria
     * mediante la consola:
     * <ul>
     *   <li>Número de identificación (10 dígitos, validado con assert)</li>
     *   <li>Nombre</li>
     *   <li>Email</li>
     *   <li>Teléfono (10 dígitos, validado con assert)</li>
     * </ul>
     *
     * Una vez ingresados los datos y validados, se crea una instancia
     * de {@link User} y se almacena en la colección de usuarios del sistema.
     *
     * Si alguna de las validaciones falla, se lanza un
     * {@link AssertionError}.
     *
     * Finalmente, muestra un mensaje confirmando la creación exitosa.
     */
        public void createUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el numero de identificacion: ");
        String idUsuario = scanner.nextLine();
        assert idUsuario.length() == 10 : "El numero de identificacion debe tener 10 numeros.";

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese su telefono: ");
        String telefono = scanner.nextLine();
        assert telefono.length() == 10 : "El numero de telefono debe tener 10 numeros.";

        // Crear el usuario
        User user = new User(idUsuario, nombre, email, telefono,true);
        users.put(idUsuario, user);
        System.out.println("El usuario ha sido creado exitosamente.");

        scanner.close();
    }


    /**
     * Consulta y muestra los detalles de una cuenta bancaria registrada en Bankify.
     *
     * El método solicita al usuario ingresar:
     * <ul>
     *   <li>El prefijo del banco (2 dígitos, validado con assert)</li>
     *   <li>El ID de la cuenta (10 dígitos, validado con assert)</li>
     * </ul>
     *
     * A partir del prefijo, se busca el banco en el mapa de bancos del sistema
     * y se obtiene la cuenta correspondiente. 
     *
     * Si la cuenta existe, se muestran en consola los detalles principales:
     * <ul>
     *   <li>ID de la cuenta</li>
     *   <li>Fecha de creación</li>
     *   <li>Estado de la cuenta</li>
     *   <li>Saldo actual</li>
     * </ul>
     *
     * Si el banco o la cuenta no existen, se muestra un mensaje informativo.
     *
     * @throws AssertionError si el prefijo o el ID de cuenta no cumplen con las validaciones.
     */
    public void consultAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el prefijo del banco de su cuenta: ");
        String prefijo = scanner.nextLine();
        assert prefijo.length() == 2 : "El prefijo solo tiene dos digitos";
        assert bancos.containsKey(prefijo) : "El banco no existe.";

        System.out.print("Ingrese el ID de su cuenta: ");
        String idCuenta = scanner.nextLine();
        assert idCuenta.length() == 10 : "El ID de la cuenta debe tener 10 digitos.";

        Bank bancoDeCuenta = bancos.get(prefijo);
        TreeMap<String, Account> cuentas = bancoDeCuenta.getAccounts();
        Account cuenta = cuentas.get(idCuenta);
        if (cuenta != null) {
            System.out.println("Detalles de la cuenta:");
            System.out.println("ID: " + cuenta.getAccountID());
            System.out.println("Fecha de Creación: " + cuenta.getCreationDate());
            System.out.println("Estado: "+ cuenta.getState());
            System.out.println("Saldo: " + cuenta.getBalance());
        } else {
            System.out.println("La cuenta no existe.");
        }
        scanner.close();
    }

    /**
     * Crea una nueva cuenta bancaria asociada a un usuario y la registra en un banco.
     *
     * El método solicita al usuario la siguiente información:
     * <ul>
     *   <li>Número de identificación del usuario (10 dígitos, validado con assert)</li>
     *   <li>Prefijo del banco (2 dígitos, validado con assert y existencia en el sistema)</li>
     *   <li>Número de cuenta (8 dígitos, sin letras ni caracteres especiales, validado con regex)</li>
     * </ul>
     *
     * La cuenta completa se construye concatenando el prefijo del banco con el número de cuenta,
     * generando un ID de cuenta de 10 dígitos.
     *
     * Una vez obtenidos y validados los datos:
     * <ol>
     *   <li>Se crea una nueva instancia de {@link Account} asociada al usuario.</li>
     *   <li>Se establece la fecha de creación como la actual.</li>
     *   <li>Se registra la cuenta en el banco correspondiente.</li>
     * </ol>
     *
     * Si alguno de los datos no cumple con las validaciones establecidas,
     * se lanza un {@link AssertionError}.
     */
    public void createAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("A que usuario quiere crear la cuenta? (ingrese identificacion)");
        String idUsuario = scanner.nextLine();
        assert idUsuario.length() == 10 : "El numero de identificacion debe tener 10 numeros.";

        System.out.print("Ingrese el prefijo del banco de su cuenta:");
        String prefijoBanco = scanner.nextLine();
        assert prefijoBanco.length() == 2 : "El prefijo del banco debe tener 2 digitos.";
        assert bancos.containsKey(prefijoBanco) : "El banco no existe.";

        System.out.print("\nIngrese el numero de su cuenta");
        System.out.print("== INSTRUCCIONES ==");
        System.out.print("- Digite 8 digitos");
        System.out.print("- Ninguna letra");
        System.out.print("- Ningun caracter especial");

        String numeroCuenta = scanner.nextLine();
        assert numeroCuenta.matches("\\d{8}") : "El número debe tener exactamente 8 dígitos sin letras ni caracteres especiales.";
        String idCuenta = prefijoBanco + numeroCuenta;

        LocalDate fechaCreacion = LocalDate.now();

        User usuario = users.get(idUsuario);
        Account cuenta = usuario.createAccount(idCuenta,fechaCreacion,"APPROVED",0.0);

        Bank banco = bancos.get(prefijoBanco);
        banco.añadirCuenta(cuenta);
        scanner.close();
    }


    /**
     * Consulta y muestra en consola el saldo de una cuenta bancaria específica.
     *
     * El método solicita al usuario:
     * <ul>
     *   <li>Número de identificación del usuario (10 dígitos, validado con assert y existencia en el sistema).</li>
     *   <li>ID de la cuenta bancaria (10 dígitos, validado con assert y existencia en el usuario).</li>
     * </ul>
     *
     * Una vez validados los datos, obtiene la cuenta del usuario y muestra
     * en consola el saldo actual.
     *
     * @throws AssertionError si el usuario o la cuenta no existen, o si las entradas no cumplen las validaciones.
     */
    public void consultarSaldo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite el numero de identificacion del usuario que tiene la cuenta");
        String idUsuario = scanner.nextLine();
        assert idUsuario.length() == 10 : "El numero de identificacion debe tener 10 numeros.";
        assert users.containsKey(idUsuario):"No existe el usuario";

        User usuario = users.get(idUsuario);

        System.out.print("Digite el numero de cuenta");
        String idCuenta = scanner.nextLine();
        assert idCuenta.length() == 10 : "El numero de identificacion debe tener 10 numeros.";
        assert usuario.getAccounts().containsKey(idCuenta):"No existe la cuenta";

        System.out.print("== BALANCE DE LA CUENTA "+ idCuenta + ": " + usuario.getAccounts().get(idCuenta).getBalance()+" =="); 
        scanner.close();
    }

    
    /**
     * Realiza un depósito en una cuenta bancaria de un usuario registrado.
     *
     * El método solicita al usuario:
     * <ul>
     *   <li>Número de identificación del usuario (10 dígitos, validado con assert y existencia en el sistema).</li>
     *   <li>ID de la cuenta bancaria (10 dígitos, validado con assert y existencia en el usuario).</li>
     *   <li>Ciudad desde la cual se realiza el depósito.</li>
     *   <li>Monto a depositar (mayor que 0, validado con assert).</li>
     * </ul>
     *
     * Una vez validados los datos:
     * <ol>
     *   <li>Se genera un ID aleatorio de 5 dígitos para el depósito.</li>
     *   <li>Se crea un objeto {@link Deposit} asociado a la cuenta y al usuario.</li>
     *   <li>Se agrega el depósito a la lista global de depósitos del sistema.</li>
     * </ol>
     *
     * @throws AssertionError si el usuario o la cuenta no existen, o si los datos ingresados no cumplen con las validaciones.
     */

     public void realizarDeposito() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite el numero de identificacion del usuario que tiene la cuenta");
        String idUsuario = scanner.nextLine();
        assert idUsuario.length() == 10 : "El numero de identificacion debe tener 10 numeros.";
        assert users.containsKey(idUsuario):"No existe el usuario";

        User usuario = users.get(idUsuario);
        System.out.print("Digite el numero de cuenta");
        String idCuenta = scanner.nextLine();
        assert idCuenta.length() == 10 : "El numero de identificacion debe tener 10 numeros.";
        assert usuario.getAccounts().containsKey(idCuenta):"No existe la cuenta";

        System.out.println("Desde que ciudad esta haciendo el deposito?");
        String ciudad = scanner.nextLine();

        System.out.print("Digite el monto a depositar");
        Double monto = scanner.nextDouble();
        assert monto > 0 : "El monto debe ser mayor que 0.";

        int idDeposit = (int)(Math.random() * 90000) + 10000;

        Deposit deposit = usuario.makeDeposit(idCuenta, monto, idDeposit, ciudad);
        depositos.add(deposit);

        scanner.close();

    }

}
