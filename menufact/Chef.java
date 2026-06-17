package menufact;

import menufact.facture.FactureObserver;

import menufact.plats.Etat.EnPreparation;
import menufact.plats.PlatChoisi;

public class Chef implements FactureObserver {
    private String nom;

    public Chef(String nom) {
        this.nom = nom;
    }


    @Override
    public void mettreAJour(PlatChoisi plat) {
        System.out.println("[CUISINE - " + nom + "] Préparation demandée pour : "
                + plat.getPlat().getDescription() + " (Qté: " + plat.getQuantite() + ")");

        plat.setEtat(new EnPreparation());
    }

    public String getNom() {
        return nom;
    }
}