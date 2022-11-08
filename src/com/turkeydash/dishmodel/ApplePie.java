package com.turkeydash.dishmodel;

import com.turkeydash.model.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplePie extends Dish {
    List<Ingredient> ingredients;

    public ApplePie() {
        this.ingredients = new ArrayList<Ingredient>(Arrays.asList(Ingredient.APPLES, Ingredient.NUTMEG, Ingredient.CINNAMON));
    }

    //TODO: map list of associated ingredients to this class
    void isComplete() {}

    @Override
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String getDishName(){
        return ApplePie.class.getSimpleName();
    }
}
