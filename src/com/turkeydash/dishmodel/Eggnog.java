package com.turkeydash.dishmodel;

import com.turkeydash.model.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Eggnog extends Dish {
    List<Ingredient> ingredients;

    public Eggnog() {
        this.ingredients = new ArrayList<Ingredient>(Arrays.asList(Ingredient.RUM, Ingredient.CINNAMON, Ingredient.WHISKEY));
    }
    //TODO: map list of associated ingredients to this class
    void isComplete() {}

    @Override
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String getDishName(){
        return Eggnog.class.getSimpleName();
    }
}
