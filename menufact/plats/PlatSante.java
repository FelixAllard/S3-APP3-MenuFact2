package menufact.plats;

import menufact.plats.PlatAuMenu;

/**
 * Représente un plat santé offert au menu du restaurant
 * <p>
 * Un PlatSante hérite des caractéristiques de base d'un PlatAuMenu
 * et y ajoute des informations nutritionnelles: le nombre de
 * calories, la teneur en cholestérol et la teneur en gras.
 *
 * @author Émile Lefort
 * @version 2.0
 */
public class PlatSante extends PlatAuMenu {
    private double kcal;
    private double chol;
    private double gras;

    /**
     * Construit un plat santé avec ses informations de base
     * et ses valeurs nutritionnelles.
     *
     * @param code le code unique identifiant le plat
     * @param description la description du plat
     * @param prix le prix du plat
     * @param kcal le nombre de calories (kcal) du plat
     * @param chol la teneur en cholestérol (mg) du plat
     * @param gras la teneur en gras (g) du plat
     */
    public PlatSante(int code, String description, double prix, double kcal, double chol, double gras) {
        super(code, description, prix);
        this.kcal = kcal;
        this.chol = chol;
        this.gras = gras;
    }

    /**
     * Construit un plat santé vide, sans initialiser ses attributs.
     */
    public PlatSante() {
    }

    /**
     * Retourne une représentation textuelle du plat santé,
     * incluant ses valeurs nutritionnelles et les informations
     * de base héritées de PlatAuMenu.
     *
     * @return une chaîne de caractères décrivant le plat santé
     */
    @Override
    public String toString() {
        return "menufact.plats.PlatSante{" +
                "kcal=" + kcal +
                ", chol=" + chol +
                ", gras=" + gras +
                "} " + super.toString();
    }

    /**
     * Retourne le nombre de calories du plat.
     *
     * @return le nombre de calories (kcal)
     */
    public double getKcal() {
        return kcal;
    }

    /**
     * Retourne la teneur en cholestérol du plat.
     *
     * @return la teneur en cholestérol (mg)
     */
    public double getChol() {
        return chol;
    }

    /**
     * Retourne la teneur en gras du plat.
     *
     * @return la teneur en gras (g)
     */
    public double getGras() {
        return gras;
    }
}