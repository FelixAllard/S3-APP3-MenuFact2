
package UnitTests.inventaire;

import ingredients.Ingredient;
import ingredients.IngredientInventaire;
import inventaire.InventaireService;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InventaireServiceTest {
    private InventaireService service;

    InventaireServiceTest() {
    }

    @BeforeEach
    void setup() throws Exception {
        this.service = InventaireService.getInstance();
        Field field = InventaireService.class.getDeclaredField("ingredient");
        field.setAccessible(true);
        ((List)field.get(this.service)).clear();
    }

    @Test
    void getInstance_shouldAlwaysReturnSameInstance() {
        InventaireService service1 = InventaireService.getInstance();
        InventaireService service2 = InventaireService.getInstance();
        Assertions.assertSame(service1, service2);
    }

    @Test
    void ajouterIngredientInventaire_shouldAddIngredientWhenNotPresent() {
        Ingredient tomate = new Ingredient("Tomate");
        this.service.ajouterIngredientInventaire(new IngredientInventaire(tomate, 5));
        Assertions.assertTrue(this.service.verifierDisponibiliteIngredient(new IngredientInventaire(tomate, 5)));
    }

    @Test
    void ajouterIngredientInventaire_shouldMergeQuantitiesWhenAlreadyPresent() {
        Ingredient tomate = new Ingredient("Tomate");
        this.service.ajouterIngredientInventaire(new IngredientInventaire(tomate, 5));
        this.service.ajouterIngredientInventaire(new IngredientInventaire(tomate, 3));
        Assertions.assertTrue(this.service.verifierDisponibiliteIngredient(new IngredientInventaire(tomate, 8)));
    }

    @Test
    void verifierDisponibiliteIngredient_shouldReturnTrueWhenEnoughQuantityExists() {
        Ingredient tomate = new Ingredient("Tomate");
        this.service.ajouterIngredientInventaire(new IngredientInventaire(tomate, 10));
        boolean disponible = this.service.verifierDisponibiliteIngredient(new IngredientInventaire(tomate, 5));
        Assertions.assertTrue(disponible);
    }

    @Test
    void verifierDisponibiliteIngredient_shouldReturnFalseWhenQuantityInsufficient() {
        Ingredient tomate = new Ingredient("Tomate");
        this.service.ajouterIngredientInventaire(new IngredientInventaire(tomate, 2));
        boolean disponible = this.service.verifierDisponibiliteIngredient(new IngredientInventaire(tomate, 5));
        Assertions.assertFalse(disponible);
    }

    @Test
    void verifierDisponibiliteIngredientList_shouldReturnTrueWhenAllIngredientsAvailable() {
        Ingredient tomate = new Ingredient("Tomate");
        Ingredient fromage = new Ingredient("Fromage");
        this.service.ajouterIngredientInventaire(new IngredientInventaire(tomate, 10));
        this.service.ajouterIngredientInventaire(new IngredientInventaire(fromage, 5));
        List<IngredientInventaire> requis = List.of(new IngredientInventaire(tomate, 5), new IngredientInventaire(fromage, 2));
        Assertions.assertTrue(this.service.verifierDisponibiliteIngredient(requis));
    }

    @Test
    void verifierDisponibiliteIngredientList_shouldReturnFalseWhenOneIngredientMissing() {
        Ingredient tomate = new Ingredient("Tomate");
        Ingredient fromage = new Ingredient("Fromage");
        this.service.ajouterIngredientInventaire(new IngredientInventaire(tomate, 10));
        List<IngredientInventaire> requis = List.of(new IngredientInventaire(tomate, 5), new IngredientInventaire(fromage, 2));
        Assertions.assertFalse(this.service.verifierDisponibiliteIngredient(requis));
    }

    @Test
    void consommerIngredientInventaire_shouldReduceQuantities() {
        Ingredient tomate = new Ingredient("Tomate");
        this.service.ajouterIngredientInventaire(new IngredientInventaire(tomate, 10));
        this.service.consommerIngredientInventaire(List.of(new IngredientInventaire(tomate, 4)));
        Assertions.assertTrue(this.service.verifierDisponibiliteIngredient(new IngredientInventaire(tomate, 6)));
        Assertions.assertFalse(this.service.verifierDisponibiliteIngredient(new IngredientInventaire(tomate, 7)));
    }

    @Test
    void consommerIngredientInventaire_shouldRemoveIngredientWhenQuantityBecomesZero() {
        Ingredient tomate = new Ingredient("Tomate");
        this.service.ajouterIngredientInventaire(new IngredientInventaire(tomate, 5));
        this.service.consommerIngredientInventaire(List.of(new IngredientInventaire(tomate, 5)));
        Assertions.assertFalse(this.service.verifierDisponibiliteIngredient(new IngredientInventaire(tomate, 1)));
    }

    @Test
    void consommerIngredientInventaire_shouldThrowExceptionWhenStockInsufficient() {
        Ingredient tomate = new Ingredient("Tomate");
        this.service.ajouterIngredientInventaire(new IngredientInventaire(tomate, 2));
        Assertions.assertThrows(IllegalStateException.class, () -> this.service.consommerIngredientInventaire(List.of(new IngredientInventaire(tomate, 5))));
    }
}
