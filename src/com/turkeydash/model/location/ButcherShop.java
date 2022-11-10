package com.turkeydash.model.location;

import com.turkeydash.model.dish.Dishes;
import com.turkeydash.model.dish.Dish;

import java.util.ArrayList;
import java.util.List;

public class ButcherShop extends Location{
    private final Dish turkey;
    private final Dish ham;
    private final Dish chicken;
    private final List<Dish> meats;

    public ButcherShop() {
        this.turkey = Dishes.get("Turkey");
        this.ham = Dishes.get("Ham");
        this.chicken = Dishes.get("Chicken");
        meats = new ArrayList<>();
        meats.add(turkey);
        meats.add(ham);
        meats.add(chicken);
    }

    @Override
    public List<String> getDishNames() {
        List<String> meatStrings = new ArrayList<>();
        for (Dish meat: meats) {
            meatStrings.add(meat.getName());
        }
        return meatStrings;
    }
}
