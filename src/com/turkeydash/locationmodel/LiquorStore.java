package com.turkeydash.locationmodel;

import com.turkeydash.dishmodel.*;

import java.util.ArrayList;
import java.util.List;

public class LiquorStore extends Location{
    private final Eggnog eggnog;
    private final AperolSpritz aperolSpritz;
    private final Sangria sangria;
    private final List<Dish> drinks;

    public LiquorStore() {
        this.eggnog = new Eggnog();
        this.aperolSpritz = new AperolSpritz();
        this.sangria = new Sangria();
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
            drinkStrings.add(drink.getDishName());
        }
        return drinkStrings;
    }
}
