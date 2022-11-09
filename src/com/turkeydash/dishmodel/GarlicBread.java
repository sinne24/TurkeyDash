package com.turkeydash.dishmodel;

import com.turkeydash.model.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GarlicBread extends Dish {
    private final List<Ingredient> ingredients;

    public GarlicBread() {
        this.ingredients = new ArrayList<Ingredient>(Arrays.asList(Ingredient.OLIVE_OIL, Ingredient.GARLIC, Ingredient.BUTTER));
    }

    @Override
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String getDishName(){
        return GarlicBread.class.getSimpleName();
    }
}
