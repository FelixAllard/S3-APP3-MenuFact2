//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package UnitTests.menufact.plats.Etat;

import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.Etat.ImpossibleServir;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ImpossibleServirTest {
    ImpossibleServirTest() {
    }

    @Test
    void testGetNom() {
        ImpossibleServir etat = new ImpossibleServir();
        Assertions.assertEquals("Impossible de servir (manque d'ingrédients)", etat.getNom());
    }

    @Test
    void testAvancer_multipleCalls_stillSameState() {
        PlatAuMenu platAuMenu = new PlatAuMenu(1, "Burger", (double)10.0F);
        PlatChoisi platChoisi = new PlatChoisi(platAuMenu, 1);
        platChoisi.setEtat(new ImpossibleServir());
        platChoisi.getEtat().avancer(platChoisi);
        platChoisi.getEtat().avancer(platChoisi);
        platChoisi.getEtat().avancer(platChoisi);
        Assertions.assertTrue(platChoisi.getEtat() instanceof ImpossibleServir);
    }
}
