package menufact.facture.exceptions;

/**
 * Exception levée lors d'une opération invalide sur une facture,
 * notamment lors d'une tentative de transition d'état non permise
 * (par exemple, ajouter un plat à une facture fermée, ou réouvrir
 * une facture déjà payée).
 *
 * @author Félix Allard
 * @version 2.0
 */
public class FactureException extends Exception {

    /**
     * Construit une nouvelle FactureException avec le message spécifié.
     *
     * @param message le message décrivant la cause de l'exception
     */
    public FactureException(String message) {
        super("FactureException: " + message);
    }
}