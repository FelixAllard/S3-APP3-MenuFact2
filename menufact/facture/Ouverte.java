package menufact.facture;

import ingredients.IngredientInventaire;
import inventaire.Inventaire;
import inventaire.InventaireService;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

/**
 * Représente l'état OUVERTE d'une facture.
 * Permet l'ajout de plats et la fermeture de la facture.
 *
 * @author Émile Lefort
 * @version 2.0
 */
public class Ouverte implements FactureEtat {

    /**
     * Ajoute un plat choisi à la facture, après avoir vérifié
     * que l'inventaire dispose des ingrédients nécessaires
     * à sa préparation.
     *
     * @param facture la facture à laquelle ajouter le plat
     * @param p le plat choisi à ajouter
     * @throws FactureException si les ingrédients requis sont
     *         insuffisants en inventaire, ou si une erreur survient
     *         lors de la vérification des stocks
     */
    @Override
    public void ajoutePlat(Facture facture, PlatChoisi p) throws FactureException {

        InventaireService inventaire = InventaireService.getInstance();

        ArrayList<IngredientInventaire> recette = p.getPlat().getRecette();

        if (!inventaire.verifierDisponibiliteIngredient(recette)) {
            throw new FactureException("Ajout refusé : Ingrédients insuffisants en inventaire.");
        }

        try {
            inventaire.verifierDisponibiliteIngredient(recette);
        } catch (Exception e) {
            throw new FactureException("Erreur lors de la consommation des stocks.");
        }

        facture.getPlatchoisi().add(p);
    }

    /**
     * Ne fait rien, puisque la facture est déjà à l'état OUVERTE.
     *
     * @param facture la facture concernée (non modifiée)
     */
    @Override
    public void ouvrir(Facture facture) {
        // Déjà ouverte, aucune action requise
    }

    /**
     * Fait passer la facture à l'état FERMEE.
     *
     * @param facture la facture dont l'état doit être modifié
     */
    @Override
    public void fermer(Facture facture) {
        facture.setEtat(new Fermee());
    }

    /**
     * Refuse le paiement d'une facture ouverte, puisqu'elle
     * doit d'abord être fermée.
     *
     * @param facture la facture concernée
     * @throws FactureException systématiquement, puisqu'une facture
     *         doit être fermée avant d'être payée
     */
    @Override
    public void payer(Facture facture) throws FactureException {
        throw new FactureException("Impossible de régler une facture ouverte. Fermez-la d'abord.");
    }

    /**
     * Retourne une représentation textuelle de l'état.
     *
     * @return la chaîne "OUVERTE"
     */
    @Override
    public String toString() {
        return "OUVERTE";
    }
}