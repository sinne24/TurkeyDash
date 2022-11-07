package com.turkeydash.dishmodel;

import com.turkeydash.model.Category;
import com.turkeydash.model.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Turkey extends Dish{
    List<Ingredient> ingredients;

    public Turkey() {
        this.ingredients = new ArrayList<Ingredient>(Arrays.asList(Ingredient.STUFFING, Ingredient.CRANBERRIES, Ingredient.BEER));
    }

    //TODO: map list of associated ingredients to this class
    void isComplete() {

    }

    @Override
    public String getDishName(){
        return Turkey.class.getSimpleName();
    }
}
