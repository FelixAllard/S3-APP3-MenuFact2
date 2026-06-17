package menufact.plats.Etat;

import menufact.plats.PlatChoisi;

/**
 * État représentant un plat dont la préparation est terminée,
 * prêt à être servi au client.
 * <p>
 * La transition valide à partir de cet état est le passage
 * à l'état Servi, une fois le plat livré au client.
 *
 * @author Émile Lefort
 * @version 2.0
 */
public class Termine implements PlatEtat {

    /**
     * Retourne le nom de l'état.
     *
     * @return le nom de l'état "Terminé"
     */
    @Override
    public String getNom() {
        return "Terminé";
    }

    /**
     * Fait avancer le plat vers l'état Servi, indiquant
     * que le plat a été livré au client.
     *
     * @param plat le plat choisi dont l'état doit être avancé
     */
    @Override
    public void avancer(PlatChoisi plat) {
        plat.setEtat(new Servi());
    }
}