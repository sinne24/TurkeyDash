package com.turkeydash.locationmodel;

import com.turkeydash.dishmodel.CandiedSweetPotatoes;
import com.turkeydash.dishmodel.Dish;
import com.turkeydash.dishmodel.Sangria;
import com.turkeydash.dishmodel.Turkey;
import com.turkeydash.model.Ingredient;
import com.turkeydash.model.Player;
import com.turkeydash.storyboard.StoryBoard;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Home {
    private final int bonus = 10;
    private List<Ingredient> ingredientsToTally;
    private int score;
    private StoryBoard storyBoard = new StoryBoard();
    private Player player;
    private int points;
    private String file;

    public void execute(Player player) {
        setPlayer(player);
        setIngredientsToTally(player.getBasket());

        tallyPoints();
        storyBoard.hostDinner();
        guestReactions();
        presentScore();
        celebrate();
    }

    private void celebrate() {

            if(score > 70){
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
        System.out.println("\nYour dinner scored " + score + " points.");
    }

    private void guestReactions() {
        List<Dish> dishes = player.getMenu();
        int matches = 0 ;

        System.out.println();
        for (Dish dish: dishes) {
            Dish ingToCompare = dish;
            ingToCompare.getIngredients().retainAll( ingredientsToTally );
            matches = ingToCompare.getIngredients().size();

            if(matches == 3){
                System.out.println("Wow! This " + dish.getDishName() + " is incredible!");
            } else if(matches == 2){
                System.out.println("Hmm, This " + dish.getDishName() + " is good, but something's missing");
            } else{
                System.out.println("\"Pleh! This " + dish.getDishName() + " is AWFUL!\" ~ says Uncle Fester.");
            }
        }
        System.out.println();
        commentOnFavoriteDishesAndAddBonusPoints(dishes);
    }

    private void commentOnFavoriteDishesAndAddBonusPoints(List<Dish> dishes) {
        for (Dish dish: dishes) {
            if(dish.getDishName().equalsIgnoreCase(Turkey.class.getSimpleName())){
                score += bonus;
                System.out.println("Hey! you made " + dish.getDishName() + "! That's Aunt Martha's favorite!");
            } else if(dish.getDishName().equalsIgnoreCase(CandiedSweetPotatoes.class.getSimpleName())){
                score += bonus;
                System.out.println("*Uncle Fester groans with delight* \"I'm so glad you made sweet potatoes, " +
                        "however they may taste. They're my favorite.\"" );
            } else if (dish.getDishName().equalsIgnoreCase(Sangria.class.getSimpleName())){
                score += bonus;
                System.out.println("The Sangria is flowing freely. It seems that was a good choice.");
            }
        }
    }

    public int tallyPoints() {
        points = 5;
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
