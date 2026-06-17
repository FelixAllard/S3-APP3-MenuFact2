package menufact.plats.Etat;

import menufact.plats.PlatChoisi;

/**
 * État représentant un plat actuellement en cours de préparation
 * par le chef.
 * <p>
 * La transition valide à partir de cet état est le passage
 * à l'état Termine, une fois la préparation du plat achevée.
 *
 * @author Émile Lefort
 * @version 2.0
 */
public class EnPreparation implements PlatEtat {

    /**
     * Retourne le nom de l'état.
     *
     * @return le nom de l'état "En préparation"
     */
    @Override
    public String getNom() {
        return "En préparation";
    }

    /**
     * Fait avancer le plat vers l'état Termine, indiquant
     * que sa préparation est achevée.
     *
     * @param plat le plat choisi dont l'état doit être avancé
     */
    @Override
    public void avancer(PlatChoisi plat) {
        plat.setEtat(new Termine());
    }
}