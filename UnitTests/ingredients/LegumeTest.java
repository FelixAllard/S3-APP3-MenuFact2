

package UnitTests.ingredients;

import ingredients.Legume;
import ingredients.TypeIngredient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LegumeTest {
    LegumeTest() {
    }

    @Test
    void constructor_shouldSetName() {
        Legume legume = new Legume("Carotte");
        Assertions.assertEquals("Carotte", legume.getNom());
    }

    @Test
    void constructor_shouldSetTypeToLegume() {
        Legume legume = new Legume("Carotte");
        Assertions.assertEquals(TypeIngredient.LEGUME, legume.getTypeIngredient());
    }

    @Test
    void object_shouldBeProperlyInitialized() {
        Legume legume = new Legume("Courgette");
        Assertions.assertNotNull(legume);
        Assertions.assertEquals("Courgette", legume.getNom());
        Assertions.assertEquals(TypeIngredient.LEGUME, legume.getTypeIngredient());
    }
}
