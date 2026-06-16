package inventaire;

import ingredients.Ingredient;
import ingredients.IngredientInventaire;
import ingredients.exceptions.IngredientException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InventaireService {
    private static InventaireService instance;
    private List<IngredientInventaire> ingredient = new ArrayList<IngredientInventaire>();

    private InventaireService(){}

    public static InventaireService getInstance(){
        if(instance == null){
            instance = new InventaireService();
        }
        return instance;
    }

    public void ajouterIngredientInventaire(IngredientInventaire ingredientInventaire) {

        Optional<IngredientInventaire> existant = ingredient.stream()
                .filter(i -> i.getIngredient().getNom()
                        .equals(ingredientInventaire.getIngredient().getNom()))
                .findFirst();

        if (existant.isPresent()) {
            IngredientInventaire ingredientExistant = existant.get();
            try {
                ingredientExistant.setQuantite(
                        ingredientExistant.getQuantite()
                                + ingredientInventaire.getQuantite()
                );
            } catch (IngredientException e) {
                throw new RuntimeException(e);
            }
        } else {
            ingredient.add(ingredientInventaire);
        }
    }
    public boolean verifierDisponibiliteIngredient(IngredientInventaire ingredientInventaire){
        return ingredient.stream()
                .anyMatch(i ->
                        i.getIngredient().getNom()
                                .equals(ingredientInventaire.getIngredient().getNom())
                                &&
                                i.getQuantite() >= ingredientInventaire.getQuantite()
                );
    }
    public boolean verifierDisponibiliteIngredient(List<IngredientInventaire> ingredientsInventaire){


        for(IngredientInventaire ingredientInventaire : ingredientsInventaire){
            if(!ingredient.stream()
                    .anyMatch(i ->
                            i.getIngredient().getNom()
                                    .equals(ingredientInventaire.getIngredient().getNom())
                                    &&
                                    i.getQuantite() >= ingredientInventaire.getQuantite()
                    ))
                return false;
        }
        return true;

    }
    public void consommerIngredientInventaire(List<IngredientInventaire> ingredientsInventaire) {

        if (!verifierDisponibiliteIngredient(ingredientsInventaire)) {
            throw new IllegalStateException("Quantité insuffisante dans l'inventaire");
        }

        for (IngredientInventaire ingredientAConsommer : ingredientsInventaire) {
                ingredient.stream()
                        .filter(i -> i.getIngredient().getNom()
                                .equals(ingredientAConsommer.getIngredient().getNom()))
                        .findFirst()
                        .ifPresent(i ->
                                {
                                    try {
                                        i.setQuantite(
                                                i.getQuantite() - ingredientAConsommer.getQuantite()
                                        );
                                    } catch (IngredientException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                        );

        }

        ingredient.removeIf(i -> i.getQuantite() <= 0);
    }
}
