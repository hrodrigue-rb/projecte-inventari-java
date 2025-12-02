package projecte_inventari_java;

/**
 * Representa un material dins de l'inventari del centre.
 * Conté informació com ID, nom, categoria i disponibilitat.
 */
public class Material {

    private int id;
    private String nom;
    private Categoria categoria;
    private boolean disponible;

    /**
     * Constructor del material.
     *
     * @param id Identificador únic del material.
     * @param nom Nom descriptiu del material.
     * @param categoria Categoria a la qual pertany el material.
     * @param disponible Estat inicial de disponibilitat del material.
     */
    public Material(int id, String nom, Categoria categoria, boolean disponible) {
        this.id = id;
        this.nom = nom;
        this.categoria = categoria;
        this.disponible = disponible;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public Categoria getCategoria() { return categoria; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String toString() {
        return "ID: " + id + ", Nom: " + nom + ", Categoria: " + categoria + ", Disponible: " + disponible;
    }
}
