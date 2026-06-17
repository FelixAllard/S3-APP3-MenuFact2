package ingredients.exceptions;

/**
 * Exception levée lors d'une opération invalide sur un ingrédient,
 * notamment lors de la création d'un ingrédient avec des paramètres
 * invalides, ou lors d'une consommation d'inventaire excédant la
 * quantité disponible.
 *
 * @author Émile Lefort
 * @version 2.0
 */
public class IngredientException extends Exception {

    /**
     * Construit une nouvelle IngredientException avec le message spécifié.
     *
     * @param message le message décrivant la cause de l'exception
     */
    public IngredientException(String message) {
        super("IngredientException: " + message);
    }
}