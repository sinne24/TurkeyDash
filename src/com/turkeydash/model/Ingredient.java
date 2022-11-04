package com.turkeydash.model;

import java.util.Arrays;
import java.util.List;

public enum Ingredient {
    //TODO: Add more??
    STUFFING("stuffing", 5, Category.DRY_GOODS), CRANBERRIES, BEER, HONEY, PINEAPPLE,CLOVES, FLOUR, EGG,
    MILK, CREAM_OF_MUSHROOM, MARSHMALLOWS, BROWN_SUGAR, ORANGE_JUICE, MAYONNAISE, BUTTER, SAVORY_SEASONING, CHEESE,
    BREADCRUMBS, OLIVE_OIL, GARLIC, NUTMEG, CINNAMON, APPLES, ORANGES, WHISKEY, RUM, CINNAMON, APEROL, PROSECCO,
    CLUB_SODA;

    private String display;
    private int value;
    private Category category; //DRY_GOODS

    Ingredient(String display, int value, Category category) {
        this.display = display;
        this.value = value;
        this.category = category;
    }

    public static List<Ingredient> byCategory(Category category) {
        // for-each over all the values() (all the Ingredient objects)
        // and return all the ones that have the specified category
        // java.util.stream can help here

        return Arrays.asList(Ingredient.values()).stream()
                .filter(ingredient -> ingredient.getCategory().equals(category);
    }

    // OR you could think the other way,
    // that a Category has a List<Ingredient> as one of its properties

    private Category getCategory() {
        return this.category;
    }
}
