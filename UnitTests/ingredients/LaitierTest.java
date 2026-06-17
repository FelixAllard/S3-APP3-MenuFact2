
package UnitTests.ingredients;

import ingredients.Laitier;
import ingredients.TypeIngredient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LaitierTest {
    LaitierTest() {
    }

    @Test
    void constructor_shouldSetName() {
        Laitier laitier = new Laitier("Lait");
        Assertions.assertEquals("Lait", laitier.getNom());
    }

    @Test
    void constructor_shouldSetTypeToLaitier() {
        Laitier laitier = new Laitier("Lait");
        Assertions.assertEquals(TypeIngredient.LAITIER, laitier.getTypeIngredient());
    }

    @Test
    void object_shouldBeProperlyInitialized() {
        Laitier laitier = new Laitier("Fromage");
        Assertions.assertNotNull(laitier);
        Assertions.assertEquals("Fromage", laitier.getNom());
        Assertions.assertEquals(TypeIngredient.LAITIER, laitier.getTypeIngredient());
    }
}
