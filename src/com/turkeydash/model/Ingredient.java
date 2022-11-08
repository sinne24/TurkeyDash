package com.turkeydash.model;

import java.util.Arrays;
import java.util.List;

public enum Ingredient {
    STUFFING("stuffing", 5, Category.DRY_GOODS),
    CRANBERRIES("cranberries", 5, Category.MISC),
    BEER("beer", 5, Category.SPIRITS),
    HONEY("honey", 5, Category.MISC),
    PINEAPPLE("pineapple", 5, Category.PRODUCE),
    CLOVES("cloves", 5, Category.DRY_GOODS),
    FLOUR("flour", 5, Category.DRY_GOODS),
    EGG("eggs", 5, Category.REFRIDGERATED),
    MILK("milk", 5, Category.REFRIDGERATED),
    CREAM_OF_MUSHROOM("cream of mushroom", 5, Category.MISC),
    MARSHMALLOWS("marchmallows", 5, Category.DRY_GOODS),
    BROWN_SUGAR("brown sugar", 5, Category.DRY_GOODS),
    ORANGE_JUICE("orange juice", 5, Category.REFRIDGERATED),
    MAYONNAISE("mayonnaise", 5, Category.MISC),
    BUTTER("butter", 5, Category.REFRIDGERATED),
    SAVORY_SEASONING("savory seasonings (salt, pepper, old bay", 5, Category.DRY_GOODS),
    CHEESE("cheese", 5, Category.REFRIDGERATED),
    FRIED_ONIONS("fried onions", 5, Category.MISC),
    BREADCRUMBS("breadcrumbs", 5, Category.DRY_GOODS),
    OLIVE_OIL("olive oil", 5, Category.MISC),
    GARLIC("garlic", 5, Category.PRODUCE),
    NUTMEG("nutmeg", 5, Category.DRY_GOODS),
    CINNAMON("cinnamon", 5, Category.DRY_GOODS),
    APPLES("apples", 5, Category.PRODUCE),
    ORANGES("oranges", 5, Category.PRODUCE),
    SUGAR("sugar", 5, Category.DRY_GOODS),
    WHISKEY("whiskey", 5, Category.SPIRITS),
    RUM("rum", 5, Category.SPIRITS),
    APEROL("aperol", 5, Category.SPIRITS),
    PROSECCO("prosecco", 5, Category.SPIRITS),
    CLUB_SODA("club soda", 5, Category.REFRIDGERATED);

    private final String display;
    private final int value;
    private final Category category; //DRY_GOODS

    Ingredient(String display, int value, Category category) {
        this.display = display;
        this.value = value;
        this.category = category;
    }

    public static List<Ingredient> byCategory(Category category) {
        // for-each over all the values() (all the Ingredient objects)
        // and return all the ones that have the specified category
        // java.util.stream can help here

//        return Arrays.asList(Ingredient.values()).stream()
//                .filter(ingredient -> ingredient.getCategory().equals(category);
        return null;
    }

    // OR you could think the other way,
    // that a Category has a List<Ingredient> as one of its properties

    private Category getCategory() {
        return this.category;
    }
}
