package com.turkeydash.dishmodel;

import com.turkeydash.model.Ingredient;

import java.util.List;

public class Dish {
    List<Ingredient> ingredients;

    public String getDishName(){
        return "dish name";
    }

    void isComplete() {

    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
