package menufact.plats.Etat;

import menufact.plats.PlatChoisi;

/**
 * État représentant un plat qui vient d'être commandé,
 * soit l'état initial dans le cycle de vie d'un plat choisi.
 * <p>
 * La transition valide à partir de cet état est le passage
 * à l'état EnPreparation, lorsque le chef commence à préparer le plat.
 *
 * @author Émile Lefort
 * @version 2.0
 */
public class Commande implements PlatEtat {

    /**
     * Retourne le nom de l'état.
     *
     * @return le nom de l'état "Commandé"
     */
    @Override
    public String getNom() {
        return "Commandé";
    }

    /**
     * Fait avancer le plat vers l'état EnPreparation, indiquant
     * que le chef a débuté la préparation du plat.
     *
     * @param plat le plat choisi dont l'état doit être avancé
     */
    @Override
    public void avancer(PlatChoisi plat) {
        plat.setEtat(new EnPreparation());
    }
}