package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

/**
 * Représente l'état FERMEE d'une facture.
 * Interdit l'ajout de plats. Permet la réouverture ou le paiement.
 */
public class Fermee implements FactureEtat {
    @Override
    public void ajoutePlat(Facture facture, PlatChoisi p) throws FactureException {
        throw new FactureException("On peut ajouter un plat seulement sur une facture OUVERTE.");
    }

    @Override
    public void ouvrir(Facture facture) {
        facture.setEtat(new Ouverte());
    }

    @Override
    public void fermer(Facture facture) {
        // Déjà fermée, aucune action requise
    }

    @Override
    public void payer(Facture facture) {
        facture.setEtat(new Payee());
    }

    @Override
    public String toString() {
        return "FERMEE";
    }
}