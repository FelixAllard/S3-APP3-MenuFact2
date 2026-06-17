
package UnitTests.menufact.presentation;

import menufact.Client;
import menufact.facture.Facture;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.presentation.FactureView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FactureViewTest {
    FactureViewTest() {
    }

    @Test
    void testGenererFactureTexte_containsBasicInfo() throws FactureException {
        Facture facture = new Facture("Test facture");
        Client client = new Client(1, "Alice", "1234");
        facture.associerClient(client);
        PlatAuMenu platAuMenu = new PlatAuMenu(0, "Pizza", (double)20.0F);
        PlatChoisi plat = new PlatChoisi(platAuMenu, 2);
        facture.ajoutePlat(plat);
        FactureView view = new FactureView();
        String result = view.genererFactureTexte(facture);
        Assertions.assertTrue(result.contains("Test facture"));
        Assertions.assertTrue(result.contains("Alice"));
        Assertions.assertTrue(result.contains("Pizza"));
        Assertions.assertTrue(result.contains("Seq"));
    }

    @Test
    void testGenererFactureTexte_noClient() {
        Facture facture = new Facture("Sans client");
        FactureView view = new FactureView();
        String result = view.genererFactureTexte(facture);
        Assertions.assertTrue(result.contains("Aucun"));
    }

    @Test
    void testGenererFactureTexte_containsTotals() throws FactureException {
        Facture facture = new Facture("Total test");
        PlatAuMenu platAuMenu = new PlatAuMenu(0, "Burger", (double)20.0F);
        PlatChoisi plat = new PlatChoisi(platAuMenu, 1);
        facture.ajoutePlat(plat);
        FactureView view = new FactureView();
        String result = view.genererFactureTexte(facture);
        Assertions.assertTrue(result.contains("TPS"));
        Assertions.assertTrue(result.contains("TVQ"));
        Assertions.assertTrue(result.contains("Le total est de"));
    }
}
