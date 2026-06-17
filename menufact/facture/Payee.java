package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

/**
 * Représente l'état PAYEE d'une facture.
 * Cet état est final. Aucune modification ou transition n'est permise.
 *
 * @author Émile Lefort
 * @version 2.0
 */
public class Payee implements FactureEtat {

    /**
     * Refuse l'ajout d'un plat, puisqu'une facture payée ne peut
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
     * Refuse la réouverture, puisqu'une facture payée ne peut
     * jamais être réouverte.
     *
     * @param facture la facture concernée
     * @throws FactureException systématiquement, puisqu'une facture
     *         payée ne peut pas être réouverte
     */
    @Override
    public void ouvrir(Facture facture) throws FactureException {
        throw new FactureException("La facture ne peut pas être reouverte.");
    }

    /**
     * Refuse la fermeture, puisqu'une facture payée est déjà
     * fermée et réglée.
     *
     * @param facture la facture concernée
     * @throws FactureException systématiquement, puisque la facture
     *         est déjà réglée et fermée
     */
    @Override
    public void fermer(Facture facture) throws FactureException {
        throw new FactureException("La facture est déjà réglée et fermée.");
    }

    /**
     * Ne fait rien, puisque la facture est déjà à l'état PAYEE.
     *
     * @param facture la facture concernée (non modifiée)
     */
    @Override
    public void payer(Facture facture) {
        // Déjà payée, aucune action requise
    }

    /**
     * Retourne une représentation textuelle de l'état.
     *
     * @return la chaîne "PAYEE"
     */
    @Override
    public String toString() {
        return "PAYEE";
    }
}