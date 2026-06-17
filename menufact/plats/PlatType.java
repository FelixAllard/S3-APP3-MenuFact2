package menufact.plats;

/**
 * Énumère les différents types de plats pouvant être créés
 * par la PlatFactory.
 *
 * @author Félix Allard
 * @version 2.0
 */
public enum PlatType {

    /** Plat standard, sans caractéristique particulière. */
    PLAT_MENU,

    /** Plat destiné aux enfants, caractérisé par une proportion réduite. */
    PLAT_ENFANT,

    /** Plat santé, comprenant des informations nutritionnelles supplémentaires. */
    PLAT_SANTE
}