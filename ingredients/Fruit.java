package ingredients;

public class Fruit extends Ingredient{
    public Fruit(String nom) {
        super(nom);
        this.setTypeIngredient(TypeIngredient.FRUIT);
    }
}
