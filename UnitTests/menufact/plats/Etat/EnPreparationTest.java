//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package UnitTests.menufact.plats.Etat;

import menufact.plats.Etat.EnPreparation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EnPreparationTest {
    EnPreparationTest() {
    }

    @Test
    void testGetNom() {
        EnPreparation etat = new EnPreparation();
        Assertions.assertEquals("En préparation", etat.getNom());
    }
}
