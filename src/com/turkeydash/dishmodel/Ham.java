package com.turkeydash.dishmodel;

import com.turkeydash.model.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ham extends Dish {
    private final List<Ingredient> ingredients;

    public Ham() {
        this.ingredients = new ArrayList<Ingredient>(Arrays.asList(Ingredient.HONEY, Ingredient.PINEAPPLE, Ingredient.CLOVES));
    }

    @Override
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String getDishName(){
        return Ham.class.getSimpleName();
    }
}
