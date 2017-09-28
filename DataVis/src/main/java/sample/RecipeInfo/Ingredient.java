package sample.RecipeInfo;

/**
 * Created by exil33t on 12/3/16.
 */
public class Ingredient {
    private String name;
    private Integer price;
    private Integer calories;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }


    public Ingredient() {
    }

    public Ingredient(String name, Integer price, Integer calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    @Override
    public String toString(){
        return "Ingredient name: " + this.name + " price: " + this.price + " calories: "+this.calories;
    }
}
