package sample.RecipeInfo;

import java.util.ArrayList;

/**
 * Created by exil33t on 12/4/16.
 */
public class Ingredients {
    private static ArrayList<Ingredient> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient i){
        ingredients.add(i);
    }

    public void printIngredients(){
        for(Ingredient ing : ingredients){
            System.out.println(ing.toString());
        }
    }

    public static Ingredient getIngredientByName(String iName){
        for(Ingredient i : ingredients){
            if(i.getName().equals(iName)){
                return i;
            }
        }
        return null;
    }
}
