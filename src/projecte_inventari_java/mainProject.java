package projecte_inventari_java;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principal que gestiona un inventari de materials d'un institut.
 * Permet consultar materials, veure la seva disponibilitat i afegir-ne de nous.
 */
public class mainProject {

    /**
     * Llista dinàmica que emmagatzema tots els materials del centre.
     */
    private ArrayList<Material> materials = new ArrayList<>();

    /**
     * Constructor de la classe.
     * Inicialitza l'inventari amb un conjunt de materials típics d'un institut.
     */
    public mainProject() {

        // Llibres de text
        materials.add(new Material(1, "Llibre Matemàtiques 4t ESO", "Llibre de text", true));
        materials.add(new Material(2, "Llibre Català 3r ESO", "Llibre de text", true));
        materials.add(new Material(3, "Llibre Física i Química 1r Batx", "Llibre de text", false));

        // Material escolar
        materials.add(new Material(4, "Pack de regles", "Material escolar", true));
        materials.add(new Material(5, "Compàs Staedtler", "Material escolar", true));
        materials.add(new Material(6, "Calculadora científica Casio FX-82", "Material escolar", false));

        // Informàtica
        materials.add(new Material(7, "Chromebook Lenovo 300e", "Informàtica", true));
        materials.add(new Material(8, "Ratolí Logitech M185", "Informàtica", true));
        materials.add(new Material(9, "Auriculars JBL Kids Safe", "Informàtica", false));

        // Laboratori
        materials.add(new Material(10, "Probeta 100ml", "Laboratori", true));
        materials.add(new Material(11, "Microscopi escolar Bresser", "Laboratori", false));
        materials.add(new Material(12, "Model d'ADN 3D", "Laboratori", true));

        // Educació física
        materials.add(new Material(13, "Pilota de voleibol Mikasa", "Educació Física", true));
        materials.add(new Material(14, "Cronòmetre digital Casio", "Educació Física", true));
        materials.add(new Material(15, "Javelina d'entrenament 500g", "Educació Física", false));

        // Material artístic
        materials.add(new Material(16, "Caixa d'aquarel·les 24 colors", "Material artístic", true));
        materials.add(new Material(17, "Easel - Cavallet de pintura", "Material artístic", true));
    }

    /**
     * Busca i retorna un material a partir del seu identificador únic.
     *
     * @param id Identificador del material.
     * @return El material que coincideix amb l'ID, o null si no existeix.
     */
    public Material getMaterialPerID(int id) {
        for (Material material : materials) {
            if (material.getId() == id)
                return material;
        }
        return null;
    }

    /**
     * Comprova si un material identificat pel seu ID està disponible.
     *
     * @param id Identificador del material.
     * @return true si el material existeix i està disponible, false en cas contrari.
     */
    public boolean getDisponibilitatPerID(int id) {
        Material material = getMaterialPerID(id);
        return (material != null && material.isDisponible());
    }

    /**
     * Afegeix un nou material a la llista d'inventari.
     *
     * @param id Identificador únic del material.
     * @param nom Nom descriptiu del material.
     * @param tipus Categoria o tipus del material.
     * @param disponibilitat Estat de disponibilitat del material.
     */
    public void afegirMaterial(int id, String nom, String tipus, boolean disponibilitat) {
        materials.add(new Material(id, nom, tipus, disponibilitat));
        System.out.println("Material afegit correctament!");
    }

    /**
     * Inicia el menú interactiu del programa.
     * Permet a l'usuari consultar materials, veure disponibilitat i afegir-ne de nous.
     */
    public void start() {
        Scanner scan = new Scanner(System.in);
        int opcio = 0;

        do {
            System.out.println("======================");
            System.out.println(" - Gestió Inventari - ");
            System.out.println("1. Obtindre material per id");
            System.out.println("2. Veure disponibilitat material per id");
            System.out.println("3. Afegir material");
            System.out.println("99. Sortir");
            System.out.println("======================");

            opcio = scan.nextInt();

            switch (opcio) {

                case 1: {
                    System.out.print("Id del material: ");
                    int id = scan.nextInt();

                    Material material = getMaterialPerID(id);

                    if (material != null)
                        System.out.println(material);
                    else
                        System.out.println("Aquest material no existeix");

                    break;
                }

                case 2: {
                    System.out.print("Id del material: ");
                    int id = scan.nextInt();

                    if (getDisponibilitatPerID(id))
                        System.out.println("El material està disponible");
                    else
                        System.out.println("Aquest material no està disponible");

                    break;
                }

                case 3: {
                    System.out.println("Afegir material:");

                    System.out.print("Id: ");
                    int id = scan.nextInt();
                    scan.nextLine();

                    System.out.print("Nom: ");
                    String nom = scan.nextLine();

                    System.out.print("Tipus: ");
                    String tipus = scan.nextLine();

                    System.out.print("Disponibilitat (true/false): ");
                    boolean disponibilitat = scan.nextBoolean();

                    afegirMaterial(id, nom, tipus, disponibilitat);
                    break;
                }

                case 99:
                    System.out.println("Sortint...");
                    break;

                default:
                    System.out.println("Opció incorrecta");
            }

        } while (opcio != 99);

        scan.close();
    }

    /**
     * Mètode principal que inicia el programa.
     *
     * @param args Arguments de línia de comandes (no s'utilitzen).
     */
    public static void main(String[] args) {
        new mainProject().start();
    }
}
