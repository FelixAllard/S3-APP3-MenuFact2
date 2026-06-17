package inventaire;

import ingredients.Ingredient;

import java.util.ArrayList;

public class Inventaire {
    private ArrayList<Ingredient> lesIngredients = new ArrayList<Ingredient>();

    public void ajouter (Ingredient ingredient)
    {
        lesIngredients.add(ingredient);
    }

    public int size() {
        return  lesIngredients.size();
    }

    public Ingredient get(int index) {
        return lesIngredients.get(index);
    }
}
