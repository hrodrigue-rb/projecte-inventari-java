package pt2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * La clase {@code Main} proporciona una interfaz de consola
 * para gestionar un objeto {@link CCuenta}. Permite al usuario
 * ingresar y retirar dinero de la cuenta, así como consultar el saldo final.
 * 
 * Ejemplo de uso:
 * <pre>
 * CCuenta cuenta = new CCuenta("Juan López", "1000-2365-85-123456789", 2500, 0);
 * Main.gestionarCompte(cuenta);
 * </pre>
 * 
 */
public class Main {

    /** Objeto BufferedReader para leer la entrada del usuario */
    static BufferedReader dato = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Muestra un menú de operaciones para el usuario y permite gestionar
     * los movimientos de la cuenta bancaria.
     * Las operaciones disponibles son:
     * <ul>
     *   <li>1 - Ingresar dinero</li>
     *   <li>2 - Retirar dinero</li>
     *   <li>3 - Finalizar ejecución</li>
     * </ul>
     * 
     * @param comptePrincipal La cuenta bancaria que se gestionará
     */
    public static void gestionarCompte(CCuenta comptePrincipal) {
        int opcion = 0;

        do {
            try {
                System.out.println("MENÚ DE OPERACIONES");
                System.out.println("-------------------");
                System.out.println("1 - Ingresar");
                System.out.println("2 - Retirar");
                System.out.println("3 - Finalizar");
                opcion = Integer.parseInt(dato.readLine());

                switch (opcion) {
                    case 1: {
                        System.out.println("¿Cuánto desea ingresar?: ");
                        float ingresar = Float.parseFloat(dato.readLine());
                        try {
                            System.out.println("Ingreso en cuenta");
                            comptePrincipal.ingresar(ingresar);
                        } catch (Exception e) {
                            System.out.println("Fallo al ingresar");
                        }
                        break;
                    }

                    case 2: {
                        System.out.println("¿Cuánto desea retirar?: ");
                        float retirar = Float.parseFloat(dato.readLine());
                        try {
                            comptePrincipal.retirar(retirar);
                        } catch (Exception e) {
                            System.out.println("Fallo al retirar");
                        }
                        break;
                    }

                    case 3: {
                        System.out.println("Finalizamos la ejecución");
                        break;
                    }

                    default:
                        System.err.println("Opción errónea");
                        break;
                }

            } catch (IOException e) {
                System.out.println("Error de entrada");
            }

        } while (opcion != 3);
    }

    /**
     * Método principal que inicia la aplicación.
     * Crea un objeto {@link CCuenta} y llama a {@link #gestionarCompte(CCuenta)}
     * para permitir al usuario realizar operaciones en la cuenta.
     *
     * @param args Argumentos de línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        CCuenta comptePrincipal = new CCuenta("Juan López", "1000-2365-85-123456789", 2500, 0);

        gestionarCompte(comptePrincipal);

        double saldoActual = comptePrincipal.getSaldo();
        System.out.println("El saldo actual és " + saldoActual);
    }
}
