package menufact.plats;

import ingredients.Ingredient;
import ingredients.IngredientInventaire;
import ingredients.exceptions.IngredientException;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente un plat de base offert au menu du restaurant
 * <p>
 * Un PlatAuMenu est caractérisé par un code, une description, un prix
 * et une recette composée d'une liste d'ingrédients avec leurs quantités
 * requises. Cette classe constitue la classe de base de la hiérarchie
 * des plats; PlatSante et PlatEnfant en héritent pour ajouter des
 * caractéristiques spécifiques.
 *
 * @author Émile Lefort
 * @version 2.0
 */
public class PlatAuMenu {
    private int code;
    private String description;
    private double prix;
    private List<IngredientInventaire> ingredientInventaire;

    private ArrayList<IngredientInventaire> recette = new ArrayList<>();

    /**
     * Construit un plat au menu avec ses informations de base.
     *
     * @param code le code unique identifiant le plat
     * @param description la description du plat
     * @param prix le prix du plat
     */
    public PlatAuMenu(int code, String description, double prix) {
        this.code = code;
        this.description = description;
        this.prix = prix;
        ingredientInventaire = new ArrayList<>();
    }

    /**
     * Construit un plat au menu vide, sans initialiser ses attributs.
     */
    public PlatAuMenu() {
    }

    /**
     * Retourne une représentation textuelle du plat.
     *
     * @return une chaîne de caractères contenant le code, la description
     *         et le prix du plat
     */
    @Override
    public String toString() {
        return "menufact.plats.PlatAuMenu{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                "}\n";
    }

    /**
     * Ajoute un ingrédient à la recette du plat avec la quantité requise
     * pour sa préparation.
     *
     * @param ingredient l'ingrédient à ajouter à la recette
     * @param quantiteRequise la quantité de l'ingrédient nécessaire à la préparation du plat
     * @throws IngredientException si l'ingrédient ou la quantité est invalide
     */
    public void ajouterIngredientRecette(Ingredient ingredient, int quantiteRequise) throws IngredientException {
        this.recette.add(new IngredientInventaire(ingredient, quantiteRequise));
    }

    /**
     * Retourne la recette du plat, soit la liste des ingrédients
     * requis et leurs quantités.
     *
     * @return la liste des ingrédients composant la recette du plat
     */
    public ArrayList<IngredientInventaire> getRecette() {
        return recette;
    }

    /**
     * Retourne le code du plat.
     *
     * @return le code unique du plat
     */
    public int getCode() {
        return code;
    }

    /**
     * Modifie le code du plat.
     *
     * @param code le nouveau code du plat
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Retourne la description du plat.
     *
     * @return la description du plat
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifie la description du plat.
     *
     * @param description la nouvelle description du plat
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retourne le prix du plat.
     *
     * @return le prix du plat
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Modifie le prix du plat.
     *
     * @param prix le nouveau prix du plat
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }
}