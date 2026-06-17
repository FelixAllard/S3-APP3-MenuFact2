//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package UnitTests.menufact.plats;

import menufact.plats.PlatEnfant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlatEnfantTest {
    PlatEnfantTest() {
    }

    @Test
    void testConstructorAndGetters() {
        PlatEnfant plat = new PlatEnfant(1, "Pizza enfant", (double)10.0F, (double)0.5F);
        Assertions.assertEquals((double)0.5F, plat.getProportion());
        Assertions.assertEquals(1, plat.getCode());
        Assertions.assertEquals("Pizza enfant", plat.getDescription());
        Assertions.assertEquals((double)10.0F, plat.getPrix());
    }

    @Test
    void testDefaultConstructor() {
        PlatEnfant plat = new PlatEnfant();
        Assertions.assertNotNull(plat);
        Assertions.assertEquals((double)0.0F, plat.getProportion());
    }

    @Test
    void testToString_containsParentAndChildData() {
        PlatEnfant plat = new PlatEnfant(2, "Burger enfant", (double)8.0F, (double)0.75F);
        String result = plat.toString();
        Assertions.assertTrue(result.contains("0.75"));
        Assertions.assertTrue(result.contains("Burger enfant"));
        Assertions.assertTrue(result.contains("8.0"));
    }
}
