package com.turkeydash.dishmodel;

import com.turkeydash.model.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GarlicBread extends Dish {
    List<Ingredient> ingredients;

    public GarlicBread() {
        this.ingredients = new ArrayList<Ingredient>(Arrays.asList(Ingredient.OLIVE_OIL, Ingredient.GARLIC, Ingredient.BUTTER));
    }

    //TODO: map list of associated ingredients to this class
    void isComplete() {}

    @Override
    public String getDishName(){
        return GarlicBread.class.getSimpleName();
    }
}
