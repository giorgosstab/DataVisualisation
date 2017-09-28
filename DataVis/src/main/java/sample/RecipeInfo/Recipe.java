package sample.RecipeInfo;

import java.util.*;

/**
 * Created by exil33t on 12/3/16.
 */
public class Recipe {
    private String recipeName;
    private List<AbstractMap.SimpleEntry<Ingredient, Integer>> ingredientInfo = new ArrayList<>();

    public Integer getSumOfCalories(){
        int sum = 0;
        for(AbstractMap.SimpleEntry<Ingredient, Integer> tor : ingredientInfo){
            Integer calories = tor.getKey().getCalories();
            Integer quant = tor.getValue();
            sum += quant * calories;
        }
        return sum;
    }

    public Integer getSumOfPrices() {
        int sum = 0;
        for(AbstractMap.SimpleEntry<Ingredient, Integer> tor : ingredientInfo){
            sum += tor.getKey().getPrice() * tor.getValue() / 7000;
        }
        return sum;
    }

    public Recipe(String name) {
        recipeName = name;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<AbstractMap.SimpleEntry<Ingredient, Integer>> getIngredientInfo() {
        return ingredientInfo;
    }

    public void setIngredientInfo(List<AbstractMap.SimpleEntry<Ingredient, Integer>> ingredientInfo) {
        this.ingredientInfo = ingredientInfo;
    }

    public Recipe() {
    }

    public void addNewIngredient(Ingredient ingr, Integer amount){
        this.ingredientInfo.add((new AbstractMap.SimpleEntry<Ingredient, Integer>(ingr, amount)));
    }

    public Recipe(String recipeName, List<AbstractMap.SimpleEntry<Ingredient, Integer>> ingredientInfo) {
        this.recipeName = recipeName;
        this.ingredientInfo = ingredientInfo;
    }

    @Override
    public String toString() {
        return "Recipe:\n" +
                "recipeName='" + recipeName + '\'' +
                ", ingredientInfo=" + ingredientInfo;
    }



}
