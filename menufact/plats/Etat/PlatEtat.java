package menufact.plats.Etat;

import menufact.plats.PlatChoisi;

/**
 * Interface représentant un état dans le cycle de vie d'un plat
 * choisi (Design Pattern State).
 * <p>
 * Chaque état concret implémentant cette interface définit son nom
 * ainsi que la transition vers l'état suivant valide. La gestion
 * des transitions est ainsi déléguée à l'état courant plutôt qu'à
 * une logique conditionnelle centralisée.
 *
 * @author Émile Lefort
 * @version 2.0
 */
public interface PlatEtat {

    /**
     * Retourne le nom de l'état courant.
     *
     * @return le nom de l'état
     */
    String getNom();

    /**
     * Fait avancer le plat vers son prochain état valide.
     *
     * @param plat le plat choisi dont l'état doit être avancé
     */
    void avancer(PlatChoisi plat);
}