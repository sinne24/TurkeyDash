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
    EGG("eggs", 5, Category.REFRIGERATED),
    MILK("milk", 5, Category.REFRIGERATED),
    CREAM_OF_MUSHROOM("cream of mushroom", 5, Category.MISC),
    MARSHMALLOWS("marshmallows", 5, Category.DRY_GOODS),
    BROWN_SUGAR("brown sugar", 5, Category.DRY_GOODS),
    ORANGE_JUICE("orange juice", 5, Category.REFRIGERATED),
    MAYONNAISE("mayonnaise", 5, Category.MISC),
    BUTTER("butter", 5, Category.REFRIGERATED),
    SAVORY_SEASONING("savory seasonings (salt, pepper, old bay", 5, Category.DRY_GOODS),
    CHEESE("cheese", 5, Category.REFRIGERATED),
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
    CLUB_SODA("club soda", 5, Category.REFRIGERATED);

    private final String display;
    private final int value;
    private final Category category;

    Ingredient(String display, int value, Category category) {
        this.display = display;
        this.value = value;
        this.category = category;
    }

    private Category getCategory() {
        return this.category;
    }
}
