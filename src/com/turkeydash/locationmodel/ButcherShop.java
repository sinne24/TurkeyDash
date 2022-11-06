package com.turkeydash.locationmodel;

import com.turkeydash.dishmodel.Chicken;
import com.turkeydash.dishmodel.Ham;
import com.turkeydash.dishmodel.Turkey;
import com.turkeydash.model.Proprietor;
import com.turkeydash.dishmodel.Dish;

import java.util.ArrayList;
import java.util.List;

public class ButcherShop extends Location{
    Turkey turkey;
    Ham ham;
    Chicken chicken;
    List<Dish> meats;

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
    public List<Dish> getDishes() {
        return meats;
    }
}
