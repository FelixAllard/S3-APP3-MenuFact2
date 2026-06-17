//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package UnitTests.menufact.plats.Etat;

import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.Etat.Servi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ServiTest {
    ServiTest() {
    }

    @Test
    void testGetNom() {
        Servi etat = new Servi();
        Assertions.assertEquals("Servi", etat.getNom());
    }

    @Test
    void testAvancer_doesNotChangeState() {
        PlatAuMenu platAuMenu = new PlatAuMenu(1, "Pizza", (double)12.0F);
        PlatChoisi platChoisi = new PlatChoisi(platAuMenu, 1);
        Servi servi = new Servi();
        platChoisi.setEtat(servi);
        platChoisi.getEtat().avancer(platChoisi);
        Assertions.assertTrue(platChoisi.getEtat() instanceof Servi);
    }

    @Test
    void testAvancer_multipleCalls_stillServi() {
        PlatAuMenu platAuMenu = new PlatAuMenu(1, "Burger", (double)10.0F);
        PlatChoisi platChoisi = new PlatChoisi(platAuMenu, 1);
        platChoisi.setEtat(new Servi());
        platChoisi.getEtat().avancer(platChoisi);
        platChoisi.getEtat().avancer(platChoisi);
        platChoisi.getEtat().avancer(platChoisi);
        Assertions.assertTrue(platChoisi.getEtat() instanceof Servi);
    }
}
