package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

/**
 * Interface représentant l'état abstrait d'une Facture.
 * Définit les opérations dont le comportement varie selon l'état actuel.
 *
 * @author Justin Morissette
 * @version 1.0
 */
public interface FactureEtat {
    /**
     * Tente d'ajouter un plat choisi à la facture selon l'état actuel.
     *
     * @param facture la facture à modifier
     * @param p       le plat choisi à ajouter
     * @throws FactureException si l'état actuel ne permet pas l'ajout
     */
    void ajoutePlat(Facture facture, PlatChoisi p) throws FactureException;

    /**
     * Tente de faire passer la facture à l'état OUVERTE.
     *
     * @param facture la facture à modifier
     * @throws FactureException si la transition est interdite depuis l'état actuel
     */
    void ouvrir(Facture facture) throws FactureException;

    /**
     * Tente de faire passer la facture à l'état FERMEE.
     *
     * @param facture la facture à modifier
     * @throws FactureException si la transition est interdite depuis l'état actuel
     */
    void fermer(Facture facture) throws FactureException;

    /**
     * Tente de faire passer la facture à l'état PAYEE.
     *
     * @param facture la facture à modifier
     * @throws FactureException si la transition est interdite depuis l'état actuel
     */
    void payer(Facture facture) throws FactureException;
}