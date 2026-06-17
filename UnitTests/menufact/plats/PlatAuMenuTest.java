//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package UnitTests.menufact.plats;

import ingredients.Ingredient;
import menufact.plats.PlatAuMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlatAuMenuTest {
    PlatAuMenuTest() {
    }

    @Test
    void testConstructorAndGetters() {
        PlatAuMenu plat = new PlatAuMenu(1, "Pizza", (double)12.5F);
        Assertions.assertEquals(1, plat.getCode());
        Assertions.assertEquals("Pizza", plat.getDescription());
        Assertions.assertEquals((double)12.5F, plat.getPrix());
    }

    @Test
    void testSetters() {
        PlatAuMenu plat = new PlatAuMenu();
        plat.setCode(10);
        plat.setDescription("Burger");
        plat.setPrix(8.99);
        Assertions.assertEquals(10, plat.getCode());
        Assertions.assertEquals("Burger", plat.getDescription());
        Assertions.assertEquals(8.99, plat.getPrix());
    }

    @Test
    void testToString_containsFields() {
        PlatAuMenu plat = new PlatAuMenu(2, "Pasta", (double)15.0F);
        String result = plat.toString();
        Assertions.assertTrue(result.contains("2"));
        Assertions.assertTrue(result.contains("Pasta"));
        Assertions.assertTrue(result.contains("15.0"));
    }

    @Test
    void testRecette_isEmptyInitially() {
        PlatAuMenu plat = new PlatAuMenu(1, "Pizza", (double)10.0F);
        Assertions.assertNotNull(plat.getRecette());
        Assertions.assertEquals(0, plat.getRecette().size());
    }

    @Test
    void testAjouterIngredientRecette_addsIngredient() throws Exception {
        PlatAuMenu plat = new PlatAuMenu(1, "Pizza", (double)10.0F);
        Ingredient ingredient = new Ingredient("Tomato");
        plat.ajouterIngredientRecette(ingredient, 2);
        Assertions.assertEquals(1, plat.getRecette().size());
    }
}
