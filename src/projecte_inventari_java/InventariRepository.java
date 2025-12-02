package projecte_inventari_java;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que emmagatzema els materials de l'inventari.
 * Proporciona mètodes per afegir materials i cercar per ID.
 */
public class InventariRepository {

    private List<Material> llistaDeMaterials = new ArrayList<>();

    /**
     * Retorna el llistat de materials
     *
     */
    public List<Material> getMaterials() {
        return llistaDeMaterials;
    }
    
    /**
     * Afegeix un material a l'inventari.
     *
     * @param material Material a afegir.
     */
    public void afegirMaterial(Material material) {
        llistaDeMaterials.add(material);
    }

    /**
     * Cerca un material dins l'inventari pel seu ID.
     *
     * @param id Identificador del material.
     * @return El material amb l'ID corresponent, o null si no existeix.
     */
    public Material cercarMaterialPerID(int id) {
        for (Material material : llistaDeMaterials) {
            if (material.getId() == id) return material;
        }
        return null;
    }
}
