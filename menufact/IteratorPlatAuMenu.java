package menufact;

import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;

/**
 * Interface définissant un itérateur personnalisé pour parcourir
 * une collection de plats au menu (Design Pattern Iterator).
 * <p>
 * Contrairement à l'interface Iterator standard de Java, cet
 * itérateur permet un parcours bidirectionnel de la collection,
 * autant vers l'avant que vers l'arrière.
 *
 * @author Émile Lefort
 * @version 2.0
 */
public interface IteratorPlatAuMenu {

    /**
     * Vérifie s'il existe un plat suivant dans le parcours.
     *
     * @return {@code true} s'il reste un plat suivant, {@code false} sinon
     */
    boolean hasNext();

    /**
     * Retourne le prochain plat dans le parcours et avance la position courante.
     *
     * @return le prochain plat au menu
     * @throws MenuException si aucun plat suivant n'est disponible
     */
    PlatAuMenu next() throws MenuException;

    /**
     * Vérifie s'il existe un plat précédent dans le parcours.
     *
     * @return {@code true} s'il reste un plat précédent, {@code false} sinon
     */
    boolean hasPrevious();

    /**
     * Retourne le plat précédent dans le parcours et recule la position courante.
     *
     * @return le plat précédent au menu
     * @throws MenuException si aucun plat précédent n'est disponible
     */
    PlatAuMenu previous() throws MenuException;
}