package com.turkeydash.dishmodel;

import com.turkeydash.model.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreenBeanCasserole extends Dish {
    private final List<Ingredient> ingredients;

    public GreenBeanCasserole() {
        this.ingredients = new ArrayList<Ingredient>(Arrays.asList(Ingredient.CREAM_OF_MUSHROOM, Ingredient.FRIED_ONIONS, Ingredient.CHEESE));
    }

    @Override
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String getDishName(){
        return GreenBeanCasserole.class.getSimpleName();
    }
}
