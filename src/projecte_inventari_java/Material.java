package projecte_inventari_java;


public class Material {

    /** Identificador único del material. */
    private int id;

    /** Nombre descriptivo del material. */
    private String nombre;

    /** Tipo o categoría del material (ej: Electrónica, Audio, Accesorios…). */
    private String tipo;

    /** Indica si el material está disponible para préstamo. */
    private boolean disponible;

    /**
     * Construye un nuevo objeto Material con los parámetros especificados.
     *
     * @param id Identificador único del material.
     * @param nombre Nombre del material.
     * @param tipo Tipo o categoría del material.
     * @param disponible Estado de disponibilidad del material.
     */
    public Material(int id, String nombre, String tipo, boolean disponible) {
        setId(id);
        setNombre(nombre);
        setTipo(tipo);
        setDisponible(disponible);
    }

    /**
     * Obtiene el identificador del material.
     *
     * @return ID del material.
     */
    public int getId() { return id; }

    /**
     * Obtiene el nombre del material.
     *
     * @return Nombre del material.
     */
    public String getNombre() { return nombre; }

    /**
     * Obtiene el tipo del material.
     *
     * @return Tipo o categoría del material.
     */
    public String getTipo() { return tipo; }

    /**
     * Indica si el material está disponible.
     *
     * @return true si está disponible, false si está prestado.
     */
    public boolean isDisponible() { return disponible; }

    /**
     * Establece un nuevo ID para el material.
     *
     * @param id Nuevo identificador.
     */
    public void setId(int id) { this.id = id; }

    /**
     * Establece un nuevo nombre para el material.
     *
     * @param nombre Nuevo nombre.
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Establece un nuevo tipo o categoría para el material.
     *
     * @param tipo Nuevo tipo del material.
     */
    public void setTipo(String tipo) { this.tipo = tipo; }

    /**
     * Establece el estado de disponibilidad del material.
     *
     * @param disponible true si debe marcarse como disponible, false si está prestado.
     */
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    /**
     * @return Cadena con el contenido del material.
     */
    @Override
    public String toString() {
        return "Material{id=" + id + ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", disponible=" + disponible + '}';
    }
}
