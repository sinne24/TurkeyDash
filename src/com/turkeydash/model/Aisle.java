package com.turkeydash.model;

import java.util.ArrayList;
import java.util.List;

public class Aisle {
    private final Category category;
    List<Ingredient> ingredients = new ArrayList<>(); //ingredients that are DRY_GOODS for instance

    public Aisle(Category category) {
        this.category = category;
//        this.ingredients = Ingredient.byCategory(category);
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public Category getCategory() {
        return category;
    }
}
