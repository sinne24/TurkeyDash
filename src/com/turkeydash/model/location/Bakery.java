package com.turkeydash.model.location;

import com.turkeydash.model.dish.Dish;
import com.turkeydash.model.dish.Dishes;

import java.util.ArrayList;
import java.util.List;

public class Bakery extends Location{
    private final Dish applePie;
    private final Dish macAndCheese;
    private final Dish garlicBread;
    private final List<Dish> grains;

    public Bakery() {
        this.applePie = Dishes.get("Apple Pie");
        this.macAndCheese = Dishes.get("Mac n Cheese");
        this.garlicBread = Dishes.get("Garlic Bread");
        grains = new ArrayList<>();
        grains.add(applePie);
        grains.add(macAndCheese);
        grains.add(garlicBread);
    }

    @Override
    public List<Dish> getDishes() {
        return grains;
    }

    @Override
    public List<String> getDishNames() {
        List<String> grainStrings = new ArrayList<>();
        for (Dish grain: grains) {
            grainStrings.add(grain.getName());
        }
        return grainStrings;
    }
}
