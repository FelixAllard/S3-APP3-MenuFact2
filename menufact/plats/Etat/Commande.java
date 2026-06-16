package menufact.plats.Etat;

import menufact.plats.PlatChoisi;

public class Commande implements PlatEtat {
    @Override
    public String getNom() {
        return "Commandé";
    }

    @Override
    public void avancer(PlatChoisi plat) {
        plat.setEtat(new EnPreparation());
    }
}