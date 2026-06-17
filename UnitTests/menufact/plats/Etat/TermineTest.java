//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package UnitTests.menufact.plats.Etat;

import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.Etat.Servi;
import menufact.plats.Etat.Termine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TermineTest {
    TermineTest() {
    }

    @Test
    void testGetNom() {
        Termine etat = new Termine();
        Assertions.assertEquals("Terminé", etat.getNom());
    }

    @Test
    void testAvancer_changesStateToServi() {
        PlatAuMenu platAuMenu = new PlatAuMenu(1, "Pizza", (double)12.0F);
        PlatChoisi platChoisi = new PlatChoisi(platAuMenu, 1);
        platChoisi.setEtat(new Termine());
        Assertions.assertTrue(platChoisi.getEtat() instanceof Termine);
        platChoisi.getEtat().avancer(platChoisi);
        Assertions.assertTrue(platChoisi.getEtat() instanceof Servi);
    }

    @Test
    void testAvancer_onlyOnceChangesState() {
        PlatAuMenu platAuMenu = new PlatAuMenu(1, "Burger", (double)10.0F);
        PlatChoisi platChoisi = new PlatChoisi(platAuMenu, 1);
        platChoisi.setEtat(new Termine());
        platChoisi.getEtat().avancer(platChoisi);
        Assertions.assertTrue(platChoisi.getEtat() instanceof Servi);
    }
}
