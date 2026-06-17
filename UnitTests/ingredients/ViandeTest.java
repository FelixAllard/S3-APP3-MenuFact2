
package UnitTests.ingredients;

import ingredients.TypeIngredient;
import ingredients.Viande;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ViandeTest {
    ViandeTest() {
    }

    @Test
    void constructor_shouldSetName() {
        Viande viande = new Viande("Boeuf");
        Assertions.assertEquals("Boeuf", viande.getNom());
    }

    @Test
    void constructor_shouldSetTypeToViande() {
        Viande viande = new Viande("Boeuf");
        Assertions.assertEquals(TypeIngredient.VIANDE, viande.getTypeIngredient());
    }

    @Test
    void object_shouldBeProperlyInitialized() {
        Viande viande = new Viande("Poulet");
        Assertions.assertNotNull(viande);
        Assertions.assertEquals("Poulet", viande.getNom());
        Assertions.assertEquals(TypeIngredient.VIANDE, viande.getTypeIngredient());
    }
}
