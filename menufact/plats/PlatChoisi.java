package menufact.plats;

import menufact.plats.Etat.Commande;
import menufact.plats.Etat.PlatEtat;
import menufact.plats.PlatAuMenu;

/**
 * Représente un plat choisi par un client, c'est-à-dire un plat
 * du menu associé à une quantité et à un état de préparation.
 * <p>
 * Un PlatChoisi évolue à travers un cycle d'états (Design Pattern
 * State) débutant à Commande, et progressant jusqu'à Servi ou
 * ImpossibleServir selon la disponibilité des ingrédients. La
 * gestion des transitions est déléguée à l'état courant.
 *
 * @author Félix Allard
 * @version 2.0
 */
public class PlatChoisi {
    private PlatAuMenu plat;
    private int quantite;
    private PlatEtat etat;

    /**
     * Construit un plat choisi avec un plat du menu et une quantité,
     * en l'initialisant à l'état Commande.
     *
     * @param plat le plat du menu sélectionné
     * @param quantite la quantité commandée de ce plat
     */
    public PlatChoisi(PlatAuMenu plat, int quantite) {
        this.plat = plat;
        this.quantite = quantite;
        this.etat = new Commande();
    }

    /**
     * Retourne l'état courant du plat choisi.
     *
     * @return l'état courant du plat
     */
    public PlatEtat getEtat() {
        return etat;
    }

    /**
     * Modifie l'état du plat choisi.
     *
     * @param etat le nouvel état du plat
     */
    public void setEtat(PlatEtat etat) {
        this.etat = etat;
    }

    /**
     * Fait avancer le plat choisi vers son prochain état valide,
     * en déléguant la transition à l'état courant.
     */
    public void avancerEtat() {
        this.etat.avancer(this);
    }

    /**
     * Retourne une représentation textuelle du plat choisi,
     * incluant la quantité, le plat associé et le nom de l'état courant.
     *
     * @return une chaîne de caractères décrivant le plat choisi
     */
    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", plat=" + plat +
                ", etat=" + etat.getNom() +
                '}';
    }

    /**
     * Retourne la quantité commandée du plat.
     *
     * @return la quantité commandée
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Modifie la quantité commandée du plat.
     *
     * @param quantite la nouvelle quantité commandée
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /**
     * Retourne le plat du menu associé.
     *
     * @return le plat du menu sélectionné
     */
    public PlatAuMenu getPlat() {
        return plat;
    }
}