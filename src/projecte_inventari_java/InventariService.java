package projecte_inventari_java;

/**
 * Servei que gestiona les operacions de l'inventari.
 * Proporciona funcionalitats per afegir, consultar, comprovar disponibilitat i prestar materials.
 */
public class InventariService {

    private InventariRepository repositoriInventari;

    /**
     * Constructor del servei d'inventari.
     *
     * @param repositoriInventari Repositori on es guarden els materials.
     */
    public InventariService(InventariRepository repositoriInventari) {
        this.repositoriInventari = repositoriInventari;
    }

    /**
     * Afegeix un material a l'inventari.
     *
     * @param id Identificador únic del material.
     * @param nom Nom del material.
     * @param categoria Categoria del material.
     * @param disponible Estat inicial de disponibilitat.
     */
    public void afegirNouMaterial(int id, String nom, Categoria categoria, boolean disponible) {
        repositoriInventari.afegirMaterial(new Material(id, nom, categoria, disponible));
    }

    /**
     * Retorna un material pel seu ID.
     *
     * @param id Identificador del material.
     * @return Material amb l'ID especificat o null si no existeix.
     */
    public Material obtenirMaterialPerID(int id) {
        return repositoriInventari.cercarMaterialPerID(id);
    }

    /**
     * Comprova si un material està disponible.
     *
     * @param id Identificador del material.
     * @return true si el material existeix i està disponible, false si no.
     */
    public boolean estaDisponible(int id) {
        Material material = repositoriInventari.cercarMaterialPerID(id);
        return material != null && material.isDisponible();
    }

    /**
     * Presta un material marcant-lo com no disponible.
     *
     * @param id Identificador del material a prestar.
     * @return true si el material s'ha prestat correctament, false si no es pot prestar.
     */
    public boolean prestarMaterial(int id) {
        Material material = repositoriInventari.cercarMaterialPerID(id);
        if (material != null && material.isDisponible()) {
            new Prestec(material); // Marca com no disponible
            return true;
        }
        return false;
    }
}
