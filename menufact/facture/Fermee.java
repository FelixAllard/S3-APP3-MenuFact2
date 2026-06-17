package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

/**
 * Représente l'état FERMEE d'une facture.
 * Interdit l'ajout de plats. Permet la réouverture ou le paiement.
 *
 * @author Émile Lefort
 * @version 2.0
 */
public class Fermee implements FactureEtat {

    /**
     * Refuse l'ajout d'un plat, puisqu'une facture fermée ne peut
     * plus être modifiée.
     *
     * @param facture la facture concernée
     * @param p le plat choisi qu'on tente d'ajouter
     * @throws FactureException systématiquement, puisque l'ajout
     *         n'est permis que sur une facture OUVERTE
     */
    @Override
    public void ajoutePlat(Facture facture, PlatChoisi p) throws FactureException {
        throw new FactureException("On peut ajouter un plat seulement sur une facture OUVERTE.");
    }

    /**
     * Fait passer la facture à l'état OUVERTE.
     *
     * @param facture la facture dont l'état doit être modifié
     */
    @Override
    public void ouvrir(Facture facture) {
        facture.setEtat(new Ouverte());
    }

    /**
     * Ne fait rien, puisque la facture est déjà à l'état FERMEE.
     *
     * @param facture la facture concernée (non modifiée)
     */
    @Override
    public void fermer(Facture facture) {
        // Déjà fermée, aucune action requise
    }

    /**
     * Fait passer la facture à l'état PAYEE.
     *
     * @param facture la facture dont l'état doit être modifié
     */
    @Override
    public void payer(Facture facture) {
        facture.setEtat(new Payee());
    }

    /**
     * Retourne une représentation textuelle de l'état.
     *
     * @return la chaîne "FERMEE"
     */
    @Override
    public String toString() {
        return "FERMEE";
    }
}