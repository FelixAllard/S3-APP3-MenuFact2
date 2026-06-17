package menufact.facture;

import menufact.plats.PlatChoisi;

/**
 * Observateur de la facture pour notifier les abonnés d'un changement
 */
public interface FactureObserver {

    /**
     * Envoyer la notification aux abonnés (Chef)
     * @param plat le plat qui a été ajouté ou modifier
     */
    void mettreAJour(PlatChoisi plat);
}