package menufact.plats.Etat;

import menufact.plats.PlatChoisi;

public class Termine implements PlatEtat {
    @Override
    public String getNom() {
        return "Terminé";
    }

    @Override
    public void avancer(PlatChoisi plat) {
        plat.setEtat(new Servi());
    }
}