package menufact.plats.Etat;

import menufact.plats.PlatChoisi;

public class ImpossibleServir implements PlatEtat {
    @Override
    public String getNom() {
        return "Impossible de servir (manque d'ingrédients)";
    }

    @Override
    public void avancer(PlatChoisi plat) {
        // Rien :)
    }
}