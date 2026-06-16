package menufact.plats;

import menufact.exceptions.MenuException;

public class PlatFactory {
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
