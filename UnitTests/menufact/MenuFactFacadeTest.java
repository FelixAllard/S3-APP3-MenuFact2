//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package UnitTests.menufact;

import menufact.Client;
import menufact.Menu;
import menufact.MenuFactFacade;
import menufact.facture.Facture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuFactFacadeTest {
    MenuFactFacadeTest() {
    }

    @Test
    void testPreparerNouvelleFacture_notNull() {
        MenuFactFacade facade = new MenuFactFacade();
        Client client = new Client(1, "Alice", "1234");
        Menu menu = new Menu("Menu midi");
        Facture facture = facade.preparerNouvelleFacture(client, menu);
        Assertions.assertNotNull(facture);
    }

    @Test
    void testPreparerNouvelleFacture_hasCorrectDescription() {
        MenuFactFacade facade = new MenuFactFacade();
        Client client = new Client(1, "Alice", "1234");
        Menu menu = new Menu("Menu midi");
        Facture facture = facade.preparerNouvelleFacture(client, menu);
        Assertions.assertEquals("Commande Facade", facture.getDescription());
    }

    @Test
    void testPreparerNouvelleFacture_associatesClient() {
        MenuFactFacade facade = new MenuFactFacade();
        Client client = new Client(1, "Alice", "1234");
        Menu menu = new Menu("Menu midi");
        Facture facture = facade.preparerNouvelleFacture(client, menu);
        Assertions.assertEquals(client, facture.getClient());
    }
}
