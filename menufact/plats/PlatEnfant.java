package menufact.plats;

/**
 * Représente un plat enfant offert au menu du restaurant.
 * <p>
 * Un PlatEnfant hérite des caractéristiques de base d'un PlatAuMenu
 * et y ajoute une proportion, indiquant la fraction d'une portion
 * normale que représente ce plat.
 *
 * @author Émile Lefort
 * @version 2.0
 */
public class PlatEnfant extends PlatAuMenu {
    private double proportion;

    /**
     * Construit un plat enfant vide, sans initialiser ses attributs.
     */
    public PlatEnfant() {
    }

    /**
     * Construit un plat enfant avec ses informations de base
     * et sa proportion.
     *
     * @param code le code unique identifiant le plat
     * @param description la description du plat
     * @param prix le prix du plat
     * @param proportion la fraction d'une portion normale que représente ce plat
     */
    public PlatEnfant(int code, String description, double prix, double proportion) {
        super(code, description, prix);
        this.proportion = proportion;
    }

    /**
     * Retourne la proportion du plat enfant.
     *
     * @return la fraction d'une portion normale que représente ce plat
     */
    public double getProportion() {
        return proportion;
    }

    /**
     * Retourne une représentation textuelle du plat enfant,
     * incluant sa proportion et les informations de base
     * héritées de PlatAuMenu.
     *
     * @return une chaîne de caractères décrivant le plat enfant
     */
    @Override
    public String toString() {
        return "PlatEnfant{" +
                "proportion=" + proportion +
                "} " + super.toString();
    }
}