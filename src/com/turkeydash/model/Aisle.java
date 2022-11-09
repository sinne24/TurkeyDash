package com.turkeydash.model;

import java.util.ArrayList;
import java.util.List;

public class Aisle {
    private final Category category;
    public List<Ingredient> ingredients = new ArrayList<>();

    public Aisle(Category category) {
        this.category = category;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public Category getCategory() {
        return category;
    }
}
