package UnitTests.ingredients;

import ingredients.Fruit;
import ingredients.TypeIngredient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FruitTest {
    FruitTest() {
    }

    @Test
    void constructor_shouldSetName() {
        Fruit fruit = new Fruit("Pomme");
        Assertions.assertEquals("Pomme", fruit.getNom());
    }

    @Test
    void constructor_shouldSetTypeToFruit() {
        Fruit fruit = new Fruit("Pomme");
        Assertions.assertEquals(TypeIngredient.FRUIT, fruit.getTypeIngredient());
    }

    @Test
    void object_shouldBeProperlyInitialized() {
        Fruit fruit = new Fruit("Banane");
        Assertions.assertNotNull(fruit);
        Assertions.assertEquals("Banane", fruit.getNom());
        Assertions.assertEquals(TypeIngredient.FRUIT, fruit.getTypeIngredient());
    }
}
