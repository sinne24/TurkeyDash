package com.turkeydash.dishmodel;

import com.turkeydash.model.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chicken extends Dish{
    List<Ingredient> ingredients;

    public Chicken() {
        this.ingredients = new ArrayList<Ingredient>(Arrays.asList(Ingredient.FLOUR, Ingredient.EGG, Ingredient.MILK));
    }

    //TODO: map list of associated ingredients to this class
    void isComplete() {

    }

    @Override
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String getDishName(){
        return Chicken.class.getSimpleName();
    }
}
