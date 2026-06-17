package menufact.plats.Etat;

import menufact.plats.PlatChoisi;

/**
 * État représentant un plat qu'il est impossible de servir,
 * généralement en raison d'un manque d'ingrédients dans l'inventaire.
 * <p>
 * Il s'agit d'un état final : aucune transition n'est possible
 * à partir de cet état.
 *
 * @author Émile Lefort
 * @version 2.0
 */
public class ImpossibleServir implements PlatEtat {

    /**
     * Retourne le nom de l'état.
     *
     * @return le nom de l'état "Impossible de servir (manque d'ingrédients)"
     */
    @Override
    public String getNom() {
        return "Impossible de servir (manque d'ingrédients)";
    }

    /**
     * Ne fait rien, puisqu'il s'agit d'un état final
     * sans transition possible.
     *
     * @param plat le plat choisi (non utilisé)
     */
    @Override
    public void avancer(PlatChoisi plat) {
        // Rien :)
    }
}