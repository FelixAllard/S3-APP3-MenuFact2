//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package UnitTests.menufact.plats;

import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.Etat.Commande;
import menufact.plats.Etat.EnPreparation;
import menufact.plats.Etat.PlatEtat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlatChoisiTest {
    PlatChoisiTest() {
    }

    @Test
    void testConstructor_initialStateIsCommande() {
        PlatAuMenu platAuMenu = new PlatAuMenu(1, "Pizza", (double)12.0F);
        PlatChoisi platChoisi = new PlatChoisi(platAuMenu, 2);
        Assertions.assertTrue(platChoisi.getEtat() instanceof Commande);
        Assertions.assertEquals(2, platChoisi.getQuantite());
        Assertions.assertEquals(platAuMenu, platChoisi.getPlat());
    }

    @Test
    void testSetQuantite() {
        PlatAuMenu platAuMenu = new PlatAuMenu(1, "Burger", (double)10.0F);
        PlatChoisi platChoisi = new PlatChoisi(platAuMenu, 1);
        platChoisi.setQuantite(5);
        Assertions.assertEquals(5, platChoisi.getQuantite());
    }

    @Test
    void testSetEtat() {
        PlatAuMenu platAuMenu = new PlatAuMenu(1, "Pasta", (double)15.0F);
        PlatChoisi platChoisi = new PlatChoisi(platAuMenu, 1);
        PlatEtat newEtat = new EnPreparation();
        platChoisi.setEtat(newEtat);
        Assertions.assertTrue(platChoisi.getEtat() instanceof EnPreparation);
    }

    @Test
    void testAvancerEtat_changesState() {
        PlatAuMenu platAuMenu = new PlatAuMenu(1, "Pizza", (double)12.0F);
        PlatChoisi platChoisi = new PlatChoisi(platAuMenu, 1);
        PlatEtat initial = platChoisi.getEtat();
        platChoisi.avancerEtat();
        Assertions.assertNotEquals(initial.getClass(), platChoisi.getEtat().getClass());
    }
}
