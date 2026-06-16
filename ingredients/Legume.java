package ingredients;

public class Legume extends Ingredient {
    public Legume(String nom) {
        super(nom);
        this.setTypeIngredient(TypeIngredient.LEGUME);
    }
}