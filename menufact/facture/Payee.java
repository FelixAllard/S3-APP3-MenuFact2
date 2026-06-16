package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

/**
 * Représente l'état PAYEE d'une facture.
 * Cet état est final. Aucune modification ou transition n'est permise.
 */
public class Payee implements FactureEtat {
    @Override
    public void ajoutePlat(Facture facture, PlatChoisi p) throws FactureException {
        throw new FactureException("On peut ajouter un plat seulement sur une facture OUVERTE.");
    }

    @Override
    public void ouvrir(Facture facture) throws FactureException {
        throw new FactureException("La facture ne peut pas être reouverte.");
    }

    @Override
    public void fermer(Facture facture) throws FactureException {
        throw new FactureException("La facture est déjà réglée et fermée.");
    }

    @Override
    public void payer(Facture facture) {
        // Déjà payée, aucune action requise
    }

    @Override
    public String toString() {
        return "PAYEE";
    }
}