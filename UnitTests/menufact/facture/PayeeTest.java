//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package UnitTests.menufact.facture;

import menufact.facture.Facture;
import menufact.facture.Payee;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PayeeTest {
    PayeeTest() {
    }

    @Test
    void testToString() {
        Payee etat = new Payee();
        Assertions.assertEquals("PAYEE", etat.toString());
    }

    @Test
    void testAjoutePlat_throwsException() {
        Payee etat = new Payee();
        Facture facture = new Facture("Test");
        PlatAuMenu platAuMenu = new PlatAuMenu(1, "Pizza", (double)10.0F);
        PlatChoisi platChoisi = new PlatChoisi(platAuMenu, 1);
        FactureException ex = (FactureException)Assertions.assertThrows(FactureException.class, () -> etat.ajoutePlat(facture, platChoisi));
    }

    @Test
    void testOuvrir_throwsException() {
        Payee etat = new Payee();
        Facture facture = new Facture("Test");
        FactureException ex = (FactureException)Assertions.assertThrows(FactureException.class, () -> etat.ouvrir(facture));
    }

    @Test
    void testFermer_throwsException() {
        Payee etat = new Payee();
        Facture facture = new Facture("Test");
        FactureException ex = (FactureException)Assertions.assertThrows(FactureException.class, () -> etat.fermer(facture));
    }

    @Test
    void testPayer_doesNothing() {
        Payee etat = new Payee();
        Facture facture = new Facture("Test");
        Assertions.assertDoesNotThrow(() -> etat.payer(facture));
    }
}
