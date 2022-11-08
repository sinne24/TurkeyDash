package com.turkeydash.dishmodel;

import com.turkeydash.model.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CandiedSweetPotatoes extends Dish {
    List<Ingredient> ingredients;

    public CandiedSweetPotatoes() {
        this.ingredients = new ArrayList<Ingredient>(Arrays.asList(Ingredient.MARSHMALLOWS, Ingredient.BROWN_SUGAR, Ingredient.ORANGE_JUICE));
    }

    //TODO: map list of associated ingredients to this class
    void isComplete() {}

    @Override
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String getDishName(){
        return CandiedSweetPotatoes.class.getSimpleName();
    }
}