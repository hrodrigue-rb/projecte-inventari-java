package projecte_inventari_java;

import java.util.Scanner;

/**
 * Classe principal del programa de gestió d'inventari.
 * Permet consultar materials, veure disponibilitat, afegir-ne de nous i prestar-los.
 */
public class mainProject {

    public static void main(String[] args) {

        InventariRepository repositori = new InventariRepository();
        InventariService serveiInventari = new InventariService(repositori);

        // Afegim materials inicials
        serveiInventari.afegirNouMaterial(1, "Llibre Matemàtiques 4t ESO", Categoria.LLIBRE_TEXT, true);
        serveiInventari.afegirNouMaterial(2, "Chromebook Lenovo", Categoria.INFORMÀTICA, true);
        serveiInventari.afegirNouMaterial(3, "Microscopi escolar", Categoria.LABORATORI, true);

        Scanner scannerEntrada = new Scanner(System.in);
        int opcioMenu;

        do {
            System.out.println("\n===== INVENTARI BÀSIC =====");
            System.out.println("1. Consultar material per ID");
            System.out.println("2. Veure disponibilitat");
            System.out.println("3. Afegir material");
            System.out.println("4. Prestar material");
            System.out.println("5. Canviar disponibilitat manualment");

            System.out.println("99. Sortir");
            System.out.print("Opció: ");
            opcioMenu = scannerEntrada.nextInt();

            switch (opcioMenu) {
                case 1:
                    System.out.print("Introdueix l'ID del material: ");
                    int idMaterial = scannerEntrada.nextInt();
                    Material materialConsultat = serveiInventari.obtenirMaterialPerID(idMaterial);
                    System.out.println(materialConsultat != null ? materialConsultat : "No existeix aquest material.");
                    break;

                case 2:
                    System.out.print("Introdueix l'ID del material: ");
                    idMaterial = scannerEntrada.nextInt();
                    System.out.println(serveiInventari.estaDisponible(idMaterial) ? "Disponible" : "No disponible");
                    break;

                case 3:
                    System.out.print("ID: ");
                    idMaterial = scannerEntrada.nextInt();
                    scannerEntrada.nextLine();
                    System.out.print("Nom: ");
                    String nomMaterial = scannerEntrada.nextLine();

                    System.out.println("Categoria (0-5):");
                    for (Categoria categoriaActual : Categoria.values()) {
                        System.out.println(categoriaActual.ordinal() + " - " + categoriaActual);
                    }
                    Categoria categoriaMaterial = Categoria.values()[scannerEntrada.nextInt()];

                    System.out.print("Disponible (true/false): ");
                    boolean disponibleMaterial = scannerEntrada.nextBoolean();

                    serveiInventari.afegirNouMaterial(idMaterial, nomMaterial, categoriaMaterial, disponibleMaterial);
                    System.out.println("Material afegit correctament!");
                    break;

                case 4:
                    System.out.print("Introdueix l'ID del material a prestar: ");
                    idMaterial = scannerEntrada.nextInt();
                    boolean materialPrestatCorrectament = serveiInventari.prestarMaterial(idMaterial);
                    System.out.println(materialPrestatCorrectament ? "Material prestat amb èxit!" 
                                                                    : "No es pot prestar: no existeix o ja no està disponible.");

                    break;

                case 5:
                    System.out.print("Introdueix l'ID del material: ");
                    idMaterial = scannerEntrada.nextInt();
                    System.out.print("Nova disponibilitat (true/false): ");
                    boolean novaDisponibilitat = scannerEntrada.nextBoolean();
                    boolean canviCorrecte = serveiInventari.canviarDisponibilitatMaterial(idMaterial, novaDisponibilitat);
                    System.out.println(canviCorrecte ? "Disponibilitat actualitzada correctament." 
                                                      : "No s'ha pogut actualitzar: material no existeix.");

                    break;

                case 99:
                    System.out.println("Sortint del programa...");
                    break;

                default:
                    System.out.println("Opció incorrecta. Torna-ho a intentar.");
            }

        } while (opcioMenu != 99);

        scannerEntrada.close();
    }
}
