package com.turkeydash.model.location;

import com.apps.util.Console;
import com.turkeydash.model.dish.Dish;
import com.turkeydash.model.Ingredient;
import com.turkeydash.model.Player;
import com.turkeydash.storyboard.StoryBoard;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Home {
    private final int bonus = 10;
    private List<Ingredient> ingredientsToTally;
    private StoryBoard storyBoard = new StoryBoard();
    private Player player;
    private String file;

    public void execute(Player player) {
        setPlayer(player);
        setIngredientsToTally(player.getBasket());

        player.setPoints(tallyPoints());
        storyBoard.hostDinner();
        Console.pause(2000);
        guestReactions();
        presentScore();
        Console.pause(2000);
        celebrate();
    }

    private void celebrate() {
            int points = player.getPoints();

            if(points > 70){
                System.out.println("Holy perfect meal! Everyone is exclaiming at your spread.");
            }else if(points>=60 && points<=70){
                file = "data/celebration/Perfect.txt";
                storyBoard.presentExpositionText(file);
            }else if(points>=45 && points<=59){
                file = "data/celebration/ScoreA.txt";
                storyBoard.presentExpositionText(file);
            }else if(points>=35 && points<=44){
                file = "data/celebration/ScoreB.txt";
                storyBoard.presentExpositionText(file);
            }else if(points>=25 && points<=34){
                file = "data/celebration/ScoreC.txt";
                storyBoard.presentExpositionText(file);
            }else{
                file = "data/celebration/ScoreD.txt";
                storyBoard.presentExpositionText(file);
            }
        }

    private void presentScore() {
        System.out.println("\nWith bonus points your dinner scored " + player.getPoints() + " points.");
    }

    private void guestReactions() {
        List<Dish> dishes = player.getMenu();
        int matches = 0 ;

        System.out.println();
        for (Dish dish: dishes) {
            Dish ingToCompare = dish;
            matches = ingToCompare.getIngredients().stream()
                    .filter(ingredientsToTally::contains)
                    .collect(Collectors
                            .toList()).size();

            if(matches == 3){
                System.out.println("Wow! This " + dish.getName() + " is incredible!");
            } else if(matches == 2){
                System.out.println("Hmm, This " + dish.getName() + " is good, but something's missing");
            } else{
                System.out.println("\"Pleh! This " + dish.getName() + " is AWFUL!\" ~ says Uncle Fester.");
            }
        }
        System.out.println("\nSo far your dinner scores " + player.getPoints() + " points\n");
        commentOnFavoriteDishesAndAddBonusPoints(dishes);
    }

    private void commentOnFavoriteDishesAndAddBonusPoints(List<Dish> dishes) {
        for (Dish dish: dishes) {
            if(dish.getName().equalsIgnoreCase("Turkey")){
                player.setPoints(player.getPoints() + bonus);
                System.out.println("Hey! you made " + dish.getName() + "! That's Aunt Martha's favorite! " +
                        "(You earned 10 bonus points!)");
            } else if(dish.getName().equalsIgnoreCase("Candied Sweet Potato")){
                player.setPoints(player.getPoints() + bonus);
                System.out.println("*Uncle Fester groans with delight* \"I'm so glad you made sweet potatoes, " +
                        "however they may taste. They're my favorite.\" (You earned 10 bonus points!)" );
            } else if (dish.getName().equalsIgnoreCase("Sangria")){
                player.setPoints(player.getPoints() + bonus);
                System.out.println("The Sangria is flowing freely. It seems that was a good choice. " +
                        "(You earned 10 bonus points!)");
            }
        }
    }

    public int tallyPoints() {
        int points = 5;
        int matches = 0 ;

        List<Ingredient> menuIngredients = new ArrayList<>();
        for (Dish dish: player.getMenu()) {
            menuIngredients.addAll(dish.getIngredients());
        }
        menuIngredients.retainAll( ingredientsToTally );
        matches = menuIngredients.size();
        points *= matches;

        return points;

    }

    public void setIngredientsToTally(List<Ingredient> ingredientsToTally) {
        this.ingredientsToTally = ingredientsToTally;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
