package pt2;

/**
 * La classe {@code CCuenta} representa un compte bancari.
 * Permet gestionar el saldo del compte, ingressar i retirar diners,
 * així com obtenir informació com el nom del titular, el número de compte
 * i el tipus d'interès.
 * 
 * Exemple d'ús:
 * <pre>
 * CCuenta compte = new CCuenta("Juan López", "1000-2365-85-123456789", 2500, 0);
 * compte.ingresar(500);
 * compte.retirar(200);
 * double saldo = compte.getSaldo();
 * </pre>
 * 
 * @author 
 */
public class CCuenta {

    private String nombre;
    private String cuenta;
    private double saldo;
    private double tipoInteres;

    /**
     * Constructor que crea un compte bancari amb la informació proporcionada.
     *
     * @param nom El nom del titular del compte
     * @param cuenta El número de compte
     * @param saldo El saldo inicial del compte
     * @param tipoInteres El tipus d'interès aplicable al compte
     */
    public CCuenta(String nom, String cuenta, double saldo, double tipoInteres) {
        setNombre(nom);
        setCuenta(cuenta);
        setSaldo(saldo);
        setTipoInteres(tipoInteres);
    }

    /**
     * Estableix el nom del titular del compte.
     *
     * @param nombre Nom del titular
     */
    public final void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el nom del titular del compte.
     *
     * @return Nom del titular
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Estableix el número de compte.
     *
     * @param cuenta Número de compte
     */
    public final void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Retorna el número de compte.
     *
     * @return Número de compte
     */
    public String getCuenta() {
        return this.cuenta;
    }

    /**
     * Estableix el saldo del compte.
     *
     * @param saldo Saldo del compte
     */
    public final void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Retorna el saldo actual del compte.
     *
     * @return Saldo del compte
     */
    public double getSaldo() {
        return this.saldo;
    }

    /**
     * Estableix el tipus d'interès del compte.
     *
     * @param tipoInteres Tipus d'interès
     */
    public final void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    /**
     * Retorna el tipus d'interès del compte.
     *
     * @return Tipus d'interès
     */
    public double getTipoInteres() {
        return this.tipoInteres;
    }

    /**
     * Permet ingressar una quantitat al compte.
     *
     * @param cantidad Quantitat a ingressar
     * @throws Exception Si la quantitat és negativa
     */
    public void ingresar(double cantidad) throws Exception {
        if (cantidad < 0) {
            throw new Exception("No se puede ingresar una cantidad negativa");
        }
        setSaldo(saldo + cantidad);
    }

    /**
     * Permet retirar una quantitat del compte.
     *
     * @param cantidad Quantitat a retirar
     * @throws Exception Si la quantitat és negativa o no hi ha suficient saldo
     */
    public void retirar(double cantidad) throws Exception {
        if (cantidad < 0) {
            throw new Exception("No se puede retirar una cantidad negativa");
        }
        if (getSaldo() < cantidad) {
            throw new Exception("No se hay suficiente saldo");
        }
        setSaldo(getSaldo() - cantidad);
    }
}
