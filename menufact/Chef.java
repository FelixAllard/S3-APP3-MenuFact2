package menufact;

import menufact.facture.FactureObserver;

import menufact.plats.Etat.EnPreparation;
import menufact.plats.PlatChoisi;
import org.jspecify.annotations.NonNull;

/**
 * Classe pour un chef de cuisine
 *
 * <p>
 *     Le chef de cuisine reçoit des notifications pour les nouveaux plats à préparer
 * </p>
 */
public class Chef implements FactureObserver {

    /** Nom du chef */
    private String nom;

    /**
     * Constructeur de chef.
     * @param nom nom du chef.
     */
    public Chef(String nom) {
        this.nom = nom;
    }


    /**
     * Met à jour la commande
     *
     * <p>
     *     Ajout de plats à la facture, modifie l'état des plats.
     * </p>
     * @param plat plat à préparer
     */
    @Override
    public void mettreAJour(@NonNull PlatChoisi plat) {
        System.out.println("[CUISINE - " + nom + "] Préparation demandée pour : "
                + plat.getPlat().getDescription() + " (Qté: " + plat.getQuantite() + ")");

        plat.setEtat(new EnPreparation());
    }

    /**
     * Obtenir le nom du chef
     * @return le nom du chef
     */
    public String getNom() {
        return nom;
    }
}