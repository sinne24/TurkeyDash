package com.turkeydash.dishmodel;

import com.turkeydash.model.Ingredient;

import java.util.List;

public class Sangria extends Dish {
    List<Ingredient> ingredients;

    //TODO: map list of associated ingredients to this class
    void isComplete() {}

    @Override
    public String getDishName(){
        return Sangria.class.getSimpleName();
    }
}
