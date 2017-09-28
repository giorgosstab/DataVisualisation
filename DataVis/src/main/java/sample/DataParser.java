package sample;

import com.jayway.jsonpath.JsonPath;
import sample.RecipeInfo.Ingredient;
import sample.RecipeInfo.Ingredients;
import sample.RecipeInfo.Recipe;
import sample.RecipeInfo.Recipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by exil33t on 12/3/16.
 */
public class DataParser {
    String ingrString;
    String recipesString;
    Ingredients ingr;
    Recipes recipes;


    public DataParser() throws FileNotFoundException {
        parseStringsFromFiles();
        this.ingr = new Ingredients();
        this.recipes = new Recipes();
        makeIngredients();
        makeRecipes();
        this.recipes.printRecipes();
    }



    private void makeRecipes() throws ClassCastException {
        int i = 0;
        List<LinkedHashMap<String, Integer>> obj = JsonPath.read(recipesString, "$.['recipes']");
        for(LinkedHashMap<String, Integer> hsh : obj){
            List<LinkedHashMap<String, Integer>> t = JsonPath.read(hsh.values().toArray()[1], "$.*");
            recipes.addRecipe(new Recipe(hsh.values().toArray()[0]+""));
            for(LinkedHashMap<String, Integer> xd : t){
                recipes.getRecipes().get(i).addNewIngredient(Ingredients.getIngredientByName(xd.values().toArray()[0]+""), (Integer) xd.values().toArray()[1]);
            }
            i++;
        }
    }

    private void makeIngredients() {
        List<LinkedHashMap<String, Integer>> obj = JsonPath.read(ingrString, "$.['ingredients']");
        for(LinkedHashMap<String, Integer> h : obj){
            this.ingr.addIngredient(new Ingredient(
                    (String) h.values().toArray()[0],
                    (Integer) h.values().toArray()[1],
                    (Integer) h.values().toArray()[2]));
        }
    }

    private void parseStringsFromFiles() throws FileNotFoundException {
        Scanner scanner = new Scanner( new File("ingredients.json") );
        String text = scanner.useDelimiter("\\A").next();
        ingrString = text;
        scanner.close();
        Scanner scanner2 = new Scanner( new File("recipes.json") );
        String text2 = scanner2.useDelimiter("\\A").next();
        recipesString = text2;
        scanner2.close();
    }



    public Recipes getRecipes() {
        return recipes;
    }
}
