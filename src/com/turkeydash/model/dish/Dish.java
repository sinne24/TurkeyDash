package com.turkeydash.model.dish;

import com.turkeydash.model.Ingredient;

import java.util.List;

public class Dish {
    private String name;
    private List<Ingredient> ingredients;

    public Dish(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public Dish(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
