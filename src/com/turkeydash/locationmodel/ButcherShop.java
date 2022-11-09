package com.turkeydash.locationmodel;

import com.turkeydash.dishmodel.Chicken;
import com.turkeydash.dishmodel.Ham;
import com.turkeydash.dishmodel.Turkey;
import com.turkeydash.dishmodel.Dish;

import java.util.ArrayList;
import java.util.List;

public class ButcherShop extends Location{
    private final Turkey turkey;
    private final Ham ham;
    private final Chicken chicken;
    private final List<Dish> meats;

    public ButcherShop() {
        this.turkey = new Turkey();
        this.ham = new Ham();
        this.chicken = new Chicken();
        meats = new ArrayList<>();
        meats.add(turkey);
        meats.add(ham);
        meats.add(chicken);
    }

    @Override
    public List<String> getDishNames() {
        List<String> meatStrings = new ArrayList<>();
        for (Dish meat: meats) {
            meatStrings.add(meat.getDishName());
        }
        return meatStrings;
    }
}
