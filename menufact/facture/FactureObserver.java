package menufact.facture;

import menufact.plats.PlatChoisi;

public interface FactureObserver {
    void mettreAJour(PlatChoisi plat);
}