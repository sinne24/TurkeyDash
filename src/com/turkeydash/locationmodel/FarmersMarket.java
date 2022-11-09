package com.turkeydash.locationmodel;

import com.turkeydash.dishmodel.*;

import java.util.ArrayList;
import java.util.List;

public class FarmersMarket extends Location{
    private final GreenBeanCasserole greenBeanCasserole;
    private final RoastedCorn corn;
    private final CandiedSweetPotatoes candiedSweetPotatoes;
    private final List<Dish> vegetables;

    public FarmersMarket() {
        this.greenBeanCasserole = new GreenBeanCasserole();
        this.corn = new RoastedCorn();
        this.candiedSweetPotatoes = new CandiedSweetPotatoes();
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
            grainStrings.add(vegetable.getDishName());
        }
        return grainStrings;
    }

}
