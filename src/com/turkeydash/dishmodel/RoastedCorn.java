package com.turkeydash.dishmodel;

import com.turkeydash.model.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoastedCorn extends Dish {
    List<Ingredient> ingredients;

    public RoastedCorn() {
        this.ingredients = new ArrayList<Ingredient>(Arrays.asList(Ingredient.BUTTER, Ingredient.MAYONNAISE, Ingredient.SAVORY_SEASONING));
    }

    //TODO: map list of associated ingredients to this class
    void isComplete() {}

    @Override
    public String getDishName(){
        return RoastedCorn.class.getSimpleName();
    }
}
