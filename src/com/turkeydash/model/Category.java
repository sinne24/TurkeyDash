package com.turkeydash.model;

/*
 * 4 Categories?
 */
public enum Category {
    DRY_GOODS("dry goods"), REFRIGERATED("refrigerated"), SPIRITS("spirits"), MISC("miscellaneous"), PRODUCE("produce");

    private String display;

    Category(String display) {
        this.display = display;
    }
}
