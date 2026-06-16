package menufact.plats.Etat;

import menufact.plats.PlatChoisi;
public class Servi implements PlatEtat {
    @Override
    public String getNom() {
        return "Servi";
    }

    @Override
    public void avancer(PlatChoisi plat) {
        // État final, on ne peut plus avancer
        System.out.println("Le plat a déjà été servi au client.");
    }
}