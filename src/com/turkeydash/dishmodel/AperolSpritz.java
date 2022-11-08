package com.turkeydash.dishmodel;

import com.turkeydash.model.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AperolSpritz extends Dish {
    List<Ingredient> ingredients;

    public AperolSpritz() {
        this.ingredients = new ArrayList<Ingredient>(Arrays.asList(Ingredient.PROSECCO, Ingredient.APEROL, Ingredient.CLUB_SODA));
    }

    void isComplete() {
    }

    @Override
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String getDishName(){
        return AperolSpritz.class.getSimpleName();
    }
}
