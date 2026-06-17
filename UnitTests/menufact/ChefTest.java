
package UnitTests.menufact;

import menufact.Chef;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.Etat.EnPreparation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ChefTest {
    ChefTest() {
    }

    @Test
    void testGetNom() {
        Chef chef = new Chef("Bob");
        Assertions.assertEquals("Bob", chef.getNom());
    }

    @Test
    void testMettreAJour_changesEtatToEnPreparation() {
        Chef chef = new Chef("Gordon");
        PlatAuMenu platAuMenu = new PlatAuMenu(0, "Pizza", (double)20.0F);
        PlatChoisi platChoisi = new PlatChoisi(platAuMenu, 2);
        chef.mettreAJour(platChoisi);
        Assertions.assertTrue(platChoisi.getEtat() instanceof EnPreparation);
    }
}
