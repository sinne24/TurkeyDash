package com.turkeydash.dishmodel;

import com.turkeydash.model.Ingredient;

import java.util.List;

public class Dish {
    private List<Ingredient> ingredients;

    public String getDishName(){
        return "dish name";
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
