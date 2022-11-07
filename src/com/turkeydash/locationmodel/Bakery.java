package com.turkeydash.locationmodel;

import com.turkeydash.dishmodel.*;

import java.util.ArrayList;
import java.util.List;

public class Bakery extends Location{
    ApplePie applePie;
    MacAndCheese macAndCheese;
    GarlicBread garlicBread;
    List<Dish> grains;

    public Bakery() {
        this.applePie = new ApplePie();
        this.macAndCheese = new MacAndCheese();
        this.garlicBread = new GarlicBread();
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
            grainStrings.add(grain.getDishName());
        }
        return grainStrings;
    }
}
