package sample;

import sample.RecipeInfo.Recipe;
import sample.RecipeInfo.Recipes;

import java.util.ArrayList;

/**
 * Created by exil33t on 12/5/16.
 */
public class RecipesAnalyzer {
    public static ArrayList<Integer> getRecipesCalories(Recipes r){
        ArrayList<Recipe> recipes = r.getRecipes();
        ArrayList<Integer> sum = new ArrayList<>();
        for(Recipe res : recipes){
            sum.add(res.getSumOfCalories());
        }
        return sum;
    }

    public static ArrayList<Integer> getRecipesPrices(Recipes r) {
        ArrayList<Recipe> recipes = r.getRecipes();
        ArrayList<Integer> sum = new ArrayList<>();
        for(Recipe res : recipes){
            sum.add(res.getSumOfPrices());
        }
        return sum;
    }
}
