package menufact;

import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;
import java.util.ArrayList;
/**
 * Représente un menu contenant une liste de plats disponibles.
 * Permet de stocker des {@link PlatAuMenu}, de naviguer dans la liste
 * et d’accéder au plat courant via un index interne.
 */
public class Menu {
    private String description;
    private int courant;
    private ArrayList<PlatAuMenu> plat = new ArrayList<PlatAuMenu>();
    /**
     * Construit un menu avec une description.
     *
     * @param description la description du menu
     */
    public Menu(String description) {
        this.description = description;
    }
    /**
     * Ajoute un plat au menu.
     *
     * @param p le plat à ajouter
     */
    public void ajoute(PlatAuMenu p)
    {
        plat.add(p);
    }
    /**
     * Retourne un itérateur pour parcourir les plats du menu.
     *
     * @return un {@link IteratorPlatAuMenu}
     */
    public IteratorPlatAuMenu iterator() {
        return new MenuIterator(this.plat);
    }
    /**
     * Définit la position courante dans le menu.
     *
     * @param i l’index du plat courant
     */
    public void position(int i)
    {
        courant = i;
    }
    /**
     * Retourne le plat courant selon la position interne.
     *
     * @return PlatAuMenu courant
     * @throws IndexOutOfBoundsException si l’index est invalide
     */
    public PlatAuMenu platCourant()
    {
        return plat.get(courant);
    }
    /**
     * Passe au plat suivant (méthode dépréciée).
     *
     * @throws MenuException si la fin du menu est atteinte
     * @deprecated utiliser {@link MenuIterator} à la place
     */
    @Deprecated
    public void positionSuivante() throws MenuException
    {
        if (courant+1 >= plat.size())
            throw new MenuException("On depasse le nombre maximale de plats.");
        else
            courant++;
    }
    /**
     * Passe au plat précédent (méthode dépréciée).
     *
     * @throws MenuException si le début du menu est atteint
     * @deprecated utiliser {@link MenuIterator} à la place
     */
    @Deprecated
    public void positionPrecedente() throws MenuException
    {
        if (courant-1 < 0)
            throw new MenuException("On depasse le nombre minimale de plats");
        else
            courant--;
    }

    /**
     * Représentation textuelle du menu.
     *
     * @return une chaîne contenant la description et les plats du menu
     */
    @Override
    public String toString() {
        return "menufact.Menu{" +
                "description='" + description + '\'' +
                ", courant=" + courant +
                ", plat=" + "\n" + plat +
                '}';
    }
}
