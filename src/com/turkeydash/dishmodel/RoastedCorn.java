package com.turkeydash.dishmodel;

import com.turkeydash.model.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoastedCorn extends Dish {
    private final List<Ingredient> ingredients;

    public RoastedCorn() {
        this.ingredients = new ArrayList<Ingredient>(Arrays.asList(Ingredient.BUTTER, Ingredient.MAYONNAISE, Ingredient.SAVORY_SEASONING));
    }

    @Override
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String getDishName(){
        return RoastedCorn.class.getSimpleName();
    }
}
