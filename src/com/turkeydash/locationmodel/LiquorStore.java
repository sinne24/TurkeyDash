package com.turkeydash.locationmodel;

import com.turkeydash.dishmodel.Dish;
import com.turkeydash.model.Proprietor;

import java.util.List;

public class LiquorStore extends Location{
    Dish dish;
    Proprietor proprietor;

    @Override
    public List<Dish> getDishes() {
        return null;
    }

}
