package UnitTests.ingredients;



import ingredients.Epice;
import ingredients.TypeIngredient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EpiceTest {
    EpiceTest() {
    }

    @Test
    void constructor_shouldSetName() {
        Epice epice = new Epice("Poivre");
        Assertions.assertEquals("Poivre", epice.getNom());
    }

    @Test
    void constructor_shouldSetTypeToEpice() {
        Epice epice = new Epice("Poivre");
        Assertions.assertEquals(TypeIngredient.EPICE, epice.getTypeIngredient());
    }

    @Test
    void object_shouldBeProperlyInitialized() {
        Epice epice = new Epice("Sel");
        Assertions.assertNotNull(epice);
        Assertions.assertEquals("Sel", epice.getNom());
        Assertions.assertEquals(TypeIngredient.EPICE, epice.getTypeIngredient());
    }
}
