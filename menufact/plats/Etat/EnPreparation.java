package menufact.plats.Etat;


import menufact.plats.PlatChoisi;

public class EnPreparation implements PlatEtat {
    @Override
    public String getNom() {
        return "En préparation";
    }

    @Override
    public void avancer(PlatChoisi plat) {
        plat.setEtat(new Termine());
    }
}