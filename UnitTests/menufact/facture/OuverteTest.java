//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package UnitTests.menufact.facture;

import menufact.facture.Ouverte;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OuverteTest {
    OuverteTest() {
    }

    @Test
    void testToString() {
        Ouverte etat = new Ouverte();
        Assertions.assertEquals("OUVERTE", etat.toString());
    }
}
