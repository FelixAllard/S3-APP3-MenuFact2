package menufact.plats;

import menufact.exceptions.MenuException;

/**
 * Fabrique de plats au menu (Design Pattern Factory Method)
 * <p>
 * Centralise la création des différents types de plats (PlatAuMenu,
 * PlatSante, PlatEnfant) à partir d'un type énuméré, découplant ainsi
 * le code client des classes concrètes de plats. Le nombre et la
 * signification des paramètres variables ({@code args}) dépendent
 * du type de plat demandé.
 *
 * @author Émile Lefort
 * @version 2.0
 */
public class PlatFactory {

    /**
     * Crée un plat au menu selon le type spécifié.
     * <p>
     * Selon la valeur de {@code type}, des paramètres supplémentaires
     * doivent être fournis dans {@code args} :
     * <ul>
     *   <li>{@code PLAT_MENU} : aucun paramètre supplémentaire requis</li>
     *   <li>{@code PLAT_SANTE} : 3 valeurs requises, dans l'ordre kcal, chol, gras</li>
     *   <li>{@code PLAT_ENFANT} : 1 valeur requise, la proportion</li>
     * </ul>
     *
     * @param type le type de plat à créer (PLAT_MENU, PLAT_SANTE ou PLAT_ENFANT)
     * @param code le code unique du plat
     * @param description la description du plat
     * @param prix le prix du plat
     * @param args paramètres supplémentaires variables selon le type de plat
     * @return une nouvelle instance de PlatAuMenu, PlatSante ou PlatEnfant selon le type
     * @throws MenuException si le code ou le prix est négatif, si les paramètres
     *         supplémentaires requis sont manquants, ou si le type est invalide
     */
    public static PlatAuMenu creerPlat(PlatType type, int code, String description, double prix, double... args) throws MenuException {

        if (code < 0 || prix < 0) {
            throw new MenuException("Le code et le prix ne peuvent pas être négatifs.");
        }

        switch (type) {
            case PLAT_MENU:
                return new PlatAuMenu(code, description, prix);

            case PLAT_SANTE:
                if (args == null || args.length < 3) {
                    throw new MenuException("Un PlatSante requiert 3 valeurs diététiques : kcal, chol, gras.");
                }
                return new PlatSante(code, description, prix, args[0], args[1], args[2]);

            case PLAT_ENFANT:
                if (args == null || args.length < 1) {
                    throw new MenuException("Un PlatEnfant requiert une valeur de proportion.");
                }
                return new PlatEnfant(code, description, prix, args[0]);

            default:
                throw new MenuException("Type de plat invalide.");
        }
    }
}
