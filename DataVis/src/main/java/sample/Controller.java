package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import sample.RecipeInfo.Recipes;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    Recipes recipes;
    ArrayList<Integer> caloriesSum = new ArrayList<>();
    ArrayList<Integer> priceSum = new ArrayList<>();
    ArrayList<String> recipesNames = new ArrayList<>();

    @FXML
    PieChart pieChart;

    @FXML
    BarChart barChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            initData();
            setPieData();
            setBarChartData();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setBarChartData() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        barChart.setTitle("Price per recipe");
        xAxis.setLabel("Recipe name");
        yAxis.setLabel("Recipe price");
        XYChart.Series series1 = new XYChart.Series();
        series1.getData().add(new XYChart.Data(recipesNames.get(0), priceSum.get(0)));
        XYChart.Series series2 = new XYChart.Series();
        series1.getData().add(new XYChart.Data(recipesNames.get(1), priceSum.get(1)));
        XYChart.Series series3 = new XYChart.Series();
        series1.getData().add(new XYChart.Data(recipesNames.get(2), priceSum.get(2)));
        XYChart.Series series4 = new XYChart.Series();
        series1.getData().add(new XYChart.Data(recipesNames.get(3), priceSum.get(3)));
        barChart.getData().addAll(series1, series2, series3, series4);
    }

    private void setPieData() {
        pieChart.setTitle("Calories per recipe");
        pieChart.setData(FXCollections.observableArrayList(
            new PieChart.Data(recipesNames.get(0), caloriesSum.get(0)),
            new PieChart.Data(recipesNames.get(1), caloriesSum.get(1)),
            new PieChart.Data(recipesNames.get(2), caloriesSum.get(2)),
            new PieChart.Data(recipesNames.get(3), caloriesSum.get(3))));
    }

    private void initData() throws Exception {
        DataParser dt = new DataParser();
        recipes = dt.getRecipes();
        recipesNames = recipes.getRecipeNames();
        caloriesSum = RecipesAnalyzer.getRecipesCalories(recipes);
        priceSum = RecipesAnalyzer.getRecipesPrices(recipes);
    }




}
