package com.turkeydash.dishmodel;

import com.turkeydash.model.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Eggnog extends Dish {
    private final List<Ingredient> ingredients;

    public Eggnog() {
        this.ingredients = new ArrayList<Ingredient>(Arrays.asList(Ingredient.RUM, Ingredient.CINNAMON, Ingredient.WHISKEY));
    }

    @Override
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String getDishName(){
        return Eggnog.class.getSimpleName();
    }
}
