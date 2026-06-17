package UnitTests.ingredients;

import ingredients.Ingredient;
import ingredients.TypeIngredient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IngredientTest {
    IngredientTest() {
    }

    @Test
    void constructor_shouldSetNom() {
        Ingredient ingredient = new Ingredient("Tomate");
        Assertions.assertEquals("Tomate", ingredient.getNom());
    }

    @Test
    void description_shouldBeNullByDefault() {
        Ingredient ingredient = new Ingredient("Tomate");
        Assertions.assertNull(ingredient.getDescription());
    }

    @Test
    void type_shouldBeNullByDefault() {
        Ingredient ingredient = new Ingredient("Tomate");
        Assertions.assertNull(ingredient.getTypeIngredient());
    }

    @Test
    void setNom_shouldUpdateName() {
        Ingredient ingredient = new Ingredient("Tomate");
        ingredient.setNom("Carotte");
        Assertions.assertEquals("Carotte", ingredient.getNom());
    }

    @Test
    void setDescription_shouldUpdateDescription() {
        Ingredient ingredient = new Ingredient("Tomate");
        ingredient.setDescription("Fruit rouge");
        Assertions.assertEquals("Fruit rouge", ingredient.getDescription());
    }

    @Test
    void setTypeIngredient_shouldUpdateType() {
        Ingredient ingredient = new Ingredient("Tomate");
        ingredient.setTypeIngredient(TypeIngredient.FRUIT);
        Assertions.assertEquals(TypeIngredient.FRUIT, ingredient.getTypeIngredient());
    }

    @Test
    void fullStateUpdate_shouldWorkTogether() {
        Ingredient ingredient = new Ingredient("Tomate");
        ingredient.setDescription("Légume rouge");
        ingredient.setTypeIngredient(TypeIngredient.FRUIT);
        ingredient.setNom("Tomate cerise");
        Assertions.assertEquals("Tomate cerise", ingredient.getNom());
        Assertions.assertEquals("Légume rouge", ingredient.getDescription());
        Assertions.assertEquals(TypeIngredient.FRUIT, ingredient.getTypeIngredient());
    }
}
