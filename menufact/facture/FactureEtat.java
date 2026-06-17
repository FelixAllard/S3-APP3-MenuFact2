package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

/**
 * Interface représentant un état dans le cycle de vie d'une facture
 * (Design Pattern State)
 * <p>
 * Chaque état concret implémentant cette interface définit son propre
 * comportement pour les opérations d'ajout de plat, d'ouverture, de
 * fermeture et de paiement de la facture. La gestion des transitions
 * et des restrictions est ainsi déléguée à l'état courant plutôt
 * qu'à une logique conditionnelle centralisée.
 *
 * @author Émile Lefort
 * @version 2.0
 */
public interface FactureEtat {

    /**
     * Ajoute un plat choisi à la facture, si l'état courant le permet.
     *
     * @param facture la facture à laquelle ajouter le plat
     * @param p le plat choisi à ajouter
     * @throws FactureException si l'ajout n'est pas permis dans l'état courant
     */
    void ajoutePlat(Facture facture, PlatChoisi p) throws FactureException;

    /**
     * Fait passer la facture à l'état OUVERTE, si l'état courant le permet.
     *
     * @param facture la facture dont l'état doit être modifié
     * @throws FactureException si la réouverture n'est pas permise dans l'état courant
     */
    void ouvrir(Facture facture) throws FactureException;

    /**
     * Fait passer la facture à l'état FERMEE, si l'état courant le permet.
     *
     * @param facture la facture dont l'état doit être modifié
     * @throws FactureException si la fermeture n'est pas permise dans l'état courant
     */
    void fermer(Facture facture) throws FactureException;

    /**
     * Fait passer la facture à l'état PAYEE, si l'état courant le permet.
     *
     * @param facture la facture dont l'état doit être modifié
     * @throws FactureException si le paiement n'est pas permis dans l'état courant
     */
    void payer(Facture facture) throws FactureException;
}