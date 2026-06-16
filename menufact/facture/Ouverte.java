package menufact.facture;

import ingredients.IngredientInventaire;
import inventaire.Inventaire;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

/**
 * Représente l'état OUVERTE d'une facture.
 * Permet l'ajout de plats et la fermeture de la facture.
 */
public class Ouverte implements FactureEtat {

    @Override
    public void ajoutePlat(Facture facture, PlatChoisi p) throws FactureException {

        Inventaire inventaire = Inventaire.getInstance();

        ArrayList<IngredientInventaire> recette = p.getPlat().getRecette();

        if (!inventaire.verifierDisponibilite(recette)) {
            throw new FactureException("Ajout refusé : Ingrédients insuffisants en inventaire.");
        }

        try {
            inventaire.consommerIngredients(recette);
        } catch (Exception e) {
            throw new FactureException("Erreur lors de la consommation des stocks.");
        }

        facture.getPlatchoisi().add(p);
    }

    @Override
    public void ouvrir(Facture facture) {
        // Déjà ouverte, aucune action requise
    }

    @Override
    public void fermer(Facture facture) {
        facture.setEtat(new Fermee());
    }

    @Override
    public void payer(Facture facture) throws FactureException {
        throw new FactureException("Impossible de régler une facture ouverte. Fermez-la d'abord.");
    }

    @Override
    public String toString() {
        return "OUVERTE";
    }
}