package UnitTests.ingredients;


import ingredients.Ingredient;
import ingredients.IngredientInventaire;
import ingredients.exceptions.IngredientException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IngredientInventaireTest {
    IngredientInventaireTest() {
    }

    @Test
    void constructor_shouldSetValues() {
        Ingredient ingredient = new Ingredient("Tomate");
        IngredientInventaire inv = new IngredientInventaire(ingredient, 5);
        Assertions.assertEquals(ingredient, inv.getIngredient());
        Assertions.assertEquals(5, inv.getQuantite());
    }

    @Test
    void getQuantite_shouldReturnCorrectValue() {
        Ingredient ingredient = new Ingredient("Tomate");
        IngredientInventaire inv = new IngredientInventaire(ingredient, 10);
        Assertions.assertEquals(10, inv.getQuantite());
    }

    @Test
    void setQuantite_shouldUpdateValue_whenValid() throws IngredientException, ingredients.exceptions.IngredientException {
        Ingredient ingredient = new Ingredient("Tomate");
        IngredientInventaire inv = new IngredientInventaire(ingredient, 5);
        inv.setQuantite(12);
        Assertions.assertEquals(12, inv.getQuantite());
    }

    @Test
    void setQuantite_shouldAllowZero() throws IngredientException, ingredients.exceptions.IngredientException {
        Ingredient ingredient = new Ingredient("Tomate");
        IngredientInventaire inv = new IngredientInventaire(ingredient, 5);
        inv.setQuantite(0);
        Assertions.assertEquals(0, inv.getQuantite());
    }
}
