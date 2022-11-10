package com.turkeydash.model.dish;

import com.turkeydash.model.Ingredient;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.turkeydash.model.Ingredient.*;

public class Dishes {
    private static final Map<String,List<Ingredient>> dishMap = new HashMap<>();

    public static Dish get(String name) {
        return new Dish(name, dishMap.get(name));
    }

    // populates dishMap when .class file is loaded by the ClassLoader
    static {
        dishMap.put("Ham", List.of(HONEY, PINEAPPLE, CLOVES));
        dishMap.put("Chicken", List.of(FLOUR, EGG, MILK));
        dishMap.put("Turkey", List.of(STUFFING, CRANBERRIES, BEER));
        dishMap.put("Apple Pie", List.of(APPLES, NUTMEG, CINNAMON));
        dishMap.put("Mac n Cheese", List.of(CHEESE, MILK, BREADCRUMBS));
        dishMap.put("Garlic Bread", List.of(OLIVE_OIL, GARLIC, BUTTER));
        dishMap.put("Green Bean Casserole", List.of(CREAM_OF_MUSHROOM, FRIED_ONIONS, CHEESE));
        dishMap.put("Candied Sweet Potato", List.of(MARSHMALLOWS, BROWN_SUGAR, ORANGE_JUICE));
        dishMap.put("Roasted Corn", List.of(BUTTER, MAYONNAISE, SAVORY_SEASONING));
        dishMap.put("Aperol Spritz", List.of(PROSECCO, APEROL, CLUB_SODA));
        dishMap.put("Eggnog", List.of(RUM, CINNAMON, WHISKEY));
        dishMap.put("Sangria", List.of(ORANGES, APPLES, SUGAR));
    }
}