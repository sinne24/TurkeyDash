package com.turkeydash.dishmodel;

import com.turkeydash.model.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MacAndCheese extends Dish {
    private final List<Ingredient> ingredients;

    public MacAndCheese() {
        this.ingredients = new ArrayList<Ingredient>(Arrays.asList(Ingredient.CHEESE, Ingredient.MILK, Ingredient.BREADCRUMBS));
    }

    @Override
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String getDishName(){
        return MacAndCheese.class.getSimpleName();
    }
}

