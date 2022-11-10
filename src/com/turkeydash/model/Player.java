package com.turkeydash.model;

import com.turkeydash.model.dish.Dish;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Dish> menu;
    private List<Ingredient> basket;
    private int points;

    public Player() {
        this.name = "";
        this.menu = new ArrayList<>();
        this.basket = new ArrayList<>();
    }

    public void emptyPlayerItems(){
        menu.clear();
        basket.clear();
        points = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getMenu() {
        return menu;
    }

    public void setMenu(List<Dish> menu) {
        this.menu = menu;
    }

    public List<Ingredient> getBasket() {
        return basket;
    }

    public void setBasket(List<Ingredient> basket) {
        this.basket = basket;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}
