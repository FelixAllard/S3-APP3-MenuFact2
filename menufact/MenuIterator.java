package menufact;

import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;
import java.util.ArrayList;

/**
 * Itérateur pour parcourir une liste de {@link PlatAuMenu}.
 * <p>
 * Permet de naviguer dans les plats du menu de manière séquentielle
 * vers l’avant et vers l’arrière. L’itérateur maintient un index
 * interne pour suivre la position courante.
 */
public class MenuIterator implements IteratorPlatAuMenu {
    private final ArrayList<PlatAuMenu> listePlats;
    private int index = 0;

    /**
     * Construit un itérateur pour la liste de plats donnée.
     *
     * @param listePlats la liste de {@link PlatAuMenu} à parcourir
     */
    MenuIterator(ArrayList<PlatAuMenu> listePlats) {
        this.listePlats = listePlats;
    }

    /**
     * Indique s’il existe un élément suivant dans la liste.
     *
     * @return true s’il reste au moins un élément après la position courante, false sinon
     */
    @Override
    public boolean hasNext() {
        return index < listePlats.size();
    }

    /**
     * Indique s’il existe un élément suivant dans la liste.
     *
     * @return true s’il reste au moins un élément après la position courante, false sinon
     */
    @Override
    public PlatAuMenu next() throws MenuException {
        if (!hasNext()) {
            throw new MenuException("On depasse le nombre maximale de plats.");
        }
        return listePlats.get(index++);
    }
    /**
     * Indique s’il existe un élément précédent dans la liste.
     *
     * @return true si l’on peut reculer, false sinon
     */
    @Override
    public boolean hasPrevious() {
        return index > 0;
    }

    /**
     * Retourne le plat précédent dans l’itération.
     *
     * @return le plat précédent dans la liste
     * @throws MenuException si aucun élément précédent n’est disponible
     */
    @Override
    public PlatAuMenu previous() throws MenuException {
        if (!hasPrevious()) {
            throw new MenuException("On depasse le nombre minimale de plats");
        }
        return listePlats.get(--index);
    }
}