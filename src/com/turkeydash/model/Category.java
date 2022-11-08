package com.turkeydash.model;

/*
 * 4 Categories?
 */
public enum Category {
    //TODO: confirm these with team
    DRY_GOODS("dry goods"), REFRIGERATED("refrigerated"), SPIRITS("spirits"), MISC("miscellaneous"), PRODUCE("produce");

    private String display;

    Category(String display) {
        this.display = display;
    }
}
