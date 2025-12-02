package projecte_inventari_java;

/**
 * Representa el préstec d'un material.
 * Quan es crea un Prestec, el material es marca automàticament com no disponible.
 */
public class Prestec {

    private Material materialPrestat;

    /**
     * Constructor del préstec.
     *
     * @param materialPrestat Material que es prestarà i quedarà no disponible.
     */
    public Prestec(Material materialPrestat) {
        this.materialPrestat = materialPrestat;
        materialPrestat.setDisponible(false);
    }

    /**
     * Retorna el material associat al préstec.
     *
     * @return Material prestat.
     */
    public Material getMaterialPrestat() {
        return materialPrestat;
    }
}
