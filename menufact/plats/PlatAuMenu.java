package menufact.plats;

import ingredients.Ingredient;
import ingredients.IngredientInventaire;
import ingredients.exceptions.IngredientException;

import java.util.ArrayList;
import java.util.List;

public class PlatAuMenu {
    private int code;
    private String description;
    private double prix;
    private List<IngredientInventaire> ingredientInventaire;

    private ArrayList<IngredientInventaire> recette = new ArrayList<>();

    public PlatAuMenu(int code, String description, double prix) {
        this.code = code;
        this.description = description;
        this.prix = prix;
        ingredientInventaire = new ArrayList<>();
    }

    public PlatAuMenu() {
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatAuMenu{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                "}\n";
    }



    public void ajouterIngredientRecette(Ingredient ingredient, int quantiteRequise) throws IngredientException {
        this.recette.add(new IngredientInventaire(ingredient, quantiteRequise));
    }

    public ArrayList<IngredientInventaire> getRecette() {
        return recette;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
