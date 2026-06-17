package menufact.exceptions;

/**
 * Exception levée lors d'une opération invalide sur le menu,
 * notamment lors d'un déplacement hors limites dans la liste
 * des plats, ou lors de la création d'un plat avec des
 * paramètres invalides via la PlatFactory.
 *
 * @author Émile Lefort
 * @version 2.0
 */
public class MenuException extends Exception {

    /**
     * Construit une nouvelle MenuException avec le message spécifié.
     *
     * @param message le message décrivant la cause de l'exception
     */
    public MenuException(String message) {
        super("MenuException: " + message);
    }
}