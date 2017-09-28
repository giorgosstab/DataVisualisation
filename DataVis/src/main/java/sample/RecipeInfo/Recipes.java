package sample.RecipeInfo;

import sample.DataParser;

import java.util.ArrayList;

/**
 * Created by exil33t on 12/4/16.
 */
public class Recipes {

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }

    ArrayList<Recipe> recipes = new ArrayList<>();

    public Recipes() {
    }


    private void initRecipes(){
    }

    public Recipe getRecipeByIndex(Integer i){
        if(i < recipes.size()){
            return recipes.get(i);
        }else{
            return null;
        }
    }

    public void printRecipes(){
        for(Recipe r : recipes){
            System.out.println(r.toString());
        }
    }

    public ArrayList<String> getRecipeNames(){
        ArrayList<String> s = new ArrayList<>();
        for(Recipe r : recipes){
            s.add(r.getRecipeName());
        }
        return s;
    }

    public void addRecipe(Recipe r){
        this.recipes.add(r);
    }
}
