package com.turkeydash.model.location;

import com.turkeydash.model.dish.Dish;
import com.turkeydash.model.dish.Dishes;

import java.util.ArrayList;
import java.util.List;

public class FarmersMarket extends Location{
    private final Dish greenBeanCasserole;
    private final Dish corn;
    private final Dish candiedSweetPotatoes;
    private final List<Dish> vegetables;

    public FarmersMarket() {
        this.greenBeanCasserole = Dishes.get("Green Bean Casserole");
        this.corn = Dishes.get("Roasted Corn");
        this.candiedSweetPotatoes = Dishes.get("Candied Sweet Potato");
        vegetables = new ArrayList<>();
        vegetables.add(greenBeanCasserole);
        vegetables.add(corn);
        vegetables.add(candiedSweetPotatoes);
    }

    @Override
    public List<Dish> getDishes() {
        return vegetables;
    }

    @Override
    public List<String> getDishNames() {
        List<String> grainStrings = new ArrayList<>();
        for (Dish vegetable: vegetables) {
            grainStrings.add(vegetable.getName());
        }
        return grainStrings;
    }

}
