//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package UnitTests.menufact.plats.Etat;

import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.Etat.Commande;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CommandeTest {
    CommandeTest() {
    }

    @Test
    void testGetNom() {
        Commande etat = new Commande();
        Assertions.assertEquals("Commandé", etat.getNom());
    }

    @Test
    void testAvancer_changesStateToEnPreparation() {
        PlatAuMenu platAuMenu = new PlatAuMenu(1, "Pizza", (double)12.0F);
        PlatChoisi platChoisi = new PlatChoisi(platAuMenu, 2);
        Assertions.assertTrue(platChoisi.getEtat() instanceof Commande);
        platChoisi.getEtat().avancer(platChoisi);
    }
}
