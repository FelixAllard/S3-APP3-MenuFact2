

package UnitTests.inventaire;

import ingredients.Ingredient;
import inventaire.Inventaire;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InventaireTest {
    InventaireTest() {
    }

    @Test
    void ajouter_shouldIncreaseSize() {
        Inventaire inventaire = new Inventaire();
        inventaire.ajouter(new Ingredient("Tomate"));
        Assertions.assertEquals(1, inventaire.size());
    }

    @Test
    void ajouter_shouldStoreCorrectIngredient() {
        Inventaire inventaire = new Inventaire();
        inventaire.ajouter(new Ingredient("Carotte"));
        Assertions.assertEquals("Carotte", inventaire.get(0).getNom());
    }

    @Test
    void ajouter_shouldPreserveOrder() {
        Inventaire inventaire = new Inventaire();
        inventaire.ajouter(new Ingredient("A"));
        inventaire.ajouter(new Ingredient("B"));
        Assertions.assertEquals("A", inventaire.get(0).getNom());
        Assertions.assertEquals("B", inventaire.get(1).getNom());
    }
}
