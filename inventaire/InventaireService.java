package inventaire;

import ingredients.Ingredient;
import ingredients.IngredientInventaire;
import ingredients.exceptions.IngredientException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe gérant l'instance unique de l'inventaire (singleton)
 *
 */
public class InventaireService {

    /** Instance unique de InventaireService. */
    private static InventaireService instance;

    /** Liste de l'inventaire de chaque ingrédient dans l'inventaire. */
    private List<IngredientInventaire> ingredient = new ArrayList<IngredientInventaire>();

    /** Constructeur privé de l'objet InventaireService. */
    private InventaireService(){}

    /**
     * Obtenir l'instance courante si elle existe : la crée si elle n'existe pas.
     */
    public static InventaireService getInstance(){
        if(instance == null){
            instance = new InventaireService();
        }
        return instance;
    }

    /**
     * Ajoute l'inventaire d'un ingrédient si elle n'existe pas, sinon ajoute à la quantité.
     *
     * <p>
     *     Vérifie si l'inventaire de l'ingrédient est déjà dans la liste, ajoute à la quantité
     *     s'il est déjà dedans et l'ajoute si ce n'est pas le cas.
     * </p>
     * @param ingredientInventaire l'inventaire de l'ingrédient à ajouter.
     * @throws RuntimeException si ça prend trop longtemps.
     */
    public void ajouterIngredientInventaire(IngredientInventaire ingredientInventaire) {

        Optional<IngredientInventaire> existant = ingredient.stream()
                .filter(i -> i.getIngredient().getNom()
                        .equals(ingredientInventaire.getIngredient().getNom()))
                .findFirst();

        if (existant.isPresent()) {
            IngredientInventaire ingredientExistant = existant.get();
            try {
                ingredientExistant.setQuantite(
                        ingredientExistant.getQuantite()
                                + ingredientInventaire.getQuantite()
                );
            } catch (IngredientException e) {
                throw new RuntimeException(e);
            }
        } else {
            ingredient.add(ingredientInventaire);
        }
    }

    /**
     * Vérifie s'il a assez d'ingrédient dans l'inventaire pour un ingrédient
     *
     * <p>
     *     Par exemple, s'assurer que la quantité d'un certain ingrédient pour un plat est suffisante dans l'inventaire.
     * </p>
     *
     * @param ingredientInventaire l'inventaire de l'ingrédient qu'on veut vérifier
     * @return oui/non s'il a assez d'un ingrédient dans l'inventaire.
     */
    public boolean verifierDisponibiliteIngredient(IngredientInventaire ingredientInventaire){
        return ingredient.stream()
                .anyMatch(i ->
                        i.getIngredient().getNom()
                                .equals(ingredientInventaire.getIngredient().getNom())
                                &&
                                i.getQuantite() >= ingredientInventaire.getQuantite()
                );
    }

    /**
     * Vérifie la quantité d'une liste d'ingrédients dans l'inventaire
     *
     * <p>
     *     Par exemple, vérifie si toute la liste d'ingrédient est en quantité suffisante pour être en
     *     de prépaper un plat.
     * </p>
     *
     * @param ingredientsInventaire liste de la quantité d'ingrédients à vérifier dans l'inventaire.
     * @return oui/non s'il y a assez d'ingrédients dans l'inventaire.
     */
    public boolean verifierDisponibiliteIngredient(List<IngredientInventaire> ingredientsInventaire){


        for(IngredientInventaire ingredientInventaire : ingredientsInventaire){
            if(!ingredient.stream()
                    .anyMatch(i ->
                            i.getIngredient().getNom()
                                    .equals(ingredientInventaire.getIngredient().getNom())
                                    &&
                                    i.getQuantite() >= ingredientInventaire.getQuantite()
                    ))
                return false;
        }
        return true;
    }

    /**
     * Utilisation d'ingrédients dans l'inventaire
     *
     * <p>
     *     Par exemple, la préparation d'un plat va utiliser des ingrédients.
     *     On va alors retirer la quantité d'ingrédients utilisés dans l'inventaire.
     * </p>
     *
     * @param ingredientsInventaire La liste d'ingrédients qu'on demande de consommer
     * @throws IllegalStateException s'il n'a pas assez d'ingrédients dans l'inventaire.
     * @throws RuntimeException si l'exécution prend trop de temps.
     */
    public void consommerIngredientInventaire(List<IngredientInventaire> ingredientsInventaire) {

        if (!verifierDisponibiliteIngredient(ingredientsInventaire)) {
            throw new IllegalStateException("Quantité insuffisante dans l'inventaire");
        }

        for (IngredientInventaire ingredientAConsommer : ingredientsInventaire) {
                ingredient.stream()
                        .filter(i -> i.getIngredient().getNom()
                                .equals(ingredientAConsommer.getIngredient().getNom()))
                        .findFirst()
                        .ifPresent(i ->
                                {
                                    try {
                                        i.setQuantite(
                                                i.getQuantite() - ingredientAConsommer.getQuantite()
                                        );
                                    } catch (IngredientException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                        );

        }

        ingredient.removeIf(i -> i.getQuantite() <= 0);
    }
}
