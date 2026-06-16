package menufact.plats;

import menufact.plats.Etat.Commande;
import menufact.plats.Etat.PlatEtat;
import menufact.plats.PlatAuMenu;

public class PlatChoisi {
    private PlatAuMenu plat;
    private int quantite;
    private PlatEtat etat;

    public PlatChoisi(PlatAuMenu plat, int quantite) {
        this.plat = plat;
        this.quantite = quantite;
        this.etat = new Commande();
    }

    public PlatEtat getEtat() {
        return etat;
    }

    public void setEtat(PlatEtat etat) {
        this.etat = etat;
    }

    public void avancerEtat() {
        this.etat.avancer(this);
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", plat=" + plat +
                ", etat=" + etat.getNom() +
                '}';
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public PlatAuMenu getPlat() {
        return plat;
    }
}