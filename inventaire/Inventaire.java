package inventaire;

import ingredients.Ingredient;

import java.util.ArrayList;

/**
 * Classe gérant un inventaire d'ingrédients.
 */
public class Inventaire {

    /** Liste d'ingrédients utilisée pour gérer l'inventaire */
    private ArrayList<Ingredient> lesIngredients = new ArrayList<Ingredient>();


    /**
     * Ajoute un ingrédient à la liste
     *
     * @param ingredient l'ingrédient à ajouter
     */
    public void ajouter (Ingredient ingredient)
    {
        lesIngredients.add(ingredient);
    }

    /**
     * Retourne le nombre d'ingrédients dans la liste
     *
     * @return le nombre d'ingrédients dans la liste
     */
    public int size() {
        return  lesIngredients.size();
    }

    /**
     * Obtient l'ingrédient à un index donné
     *
     * @param index l'index de l'ingrédient qu'on veut obtenir
     * @return l'objet à l'index
     */
    public Ingredient get(int index) {
        return lesIngredients.get(index);
    }
}
