package menufact.plats.Etat;

import menufact.plats.PlatChoisi;

/**
 * État représentant un plat qui a été servi au client.
 * <p>
 * Il s'agit d'un état final du cycle de vie normal d'un plat :
 * aucune transition supplémentaire n'est possible une fois
 * le plat servi.
 *
 * @author Émile Lefort
 * @version 2.0
 */
public class Servi implements PlatEtat {

    /**
     * Retourne le nom de l'état.
     *
     * @return le nom de l'état "Servi"
     */
    @Override
    public String getNom() {
        return "Servi";
    }

    /**
     * Affiche un message indiquant qu'aucune transition
     * supplémentaire n'est possible, puisqu'il s'agit
     * d'un état final.
     *
     * @param plat le plat choisi (non utilisé pour la transition)
     */
    @Override
    public void avancer(PlatChoisi plat) {
        // État final, on ne peut plus avancer
        System.out.println("Le plat a déjà été servi au client.");
    }
}