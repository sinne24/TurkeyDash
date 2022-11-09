package com.turkeydash.dishmodel;

import com.turkeydash.model.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sangria extends Dish {
    private final List<Ingredient> ingredients;

    public Sangria() {
        this.ingredients = new ArrayList<Ingredient>(Arrays.asList(Ingredient.ORANGES, Ingredient.APPLES, Ingredient.SUGAR));
    }

    @Override
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String getDishName(){
        return Sangria.class.getSimpleName();
    }
}
