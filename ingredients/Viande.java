package ingredients;

public class Viande extends Ingredient{
    public Viande(String nom) {
        super(nom);
        this.setTypeIngredient(TypeIngredient.VIANDE);
    }
}
