package com.turkeydash.model.location;

import com.turkeydash.model.dish.Dish;
import com.turkeydash.model.dish.Dishes;

import java.util.ArrayList;
import java.util.List;

public class LiquorStore extends Location{
    private final Dish eggnog;
    private final Dish aperolSpritz;
    private final Dish sangria;
    private final List<Dish> drinks;

    public LiquorStore() {
        this.eggnog = Dishes.get("Eggnog");
        this.aperolSpritz = Dishes.get("Aperol Spritz");
        this.sangria = Dishes.get("Sangria");
        drinks = new ArrayList<>();
        drinks.add(eggnog);
        drinks.add(aperolSpritz);
        drinks.add(sangria);
    }

    @Override
    public List<Dish> getDishes() {
        return drinks;
    }

    @Override
    public List<String> getDishNames() {
        List<String> drinkStrings = new ArrayList<>();
        for (Dish drink: drinks) {
            drinkStrings.add(drink.getName());
        }
        return drinkStrings;
    }
}
