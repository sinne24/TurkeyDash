package com.turkeydash.locationmodel;

import com.turkeydash.dishmodel.Dish;
import com.turkeydash.model.Ingredient;
import com.turkeydash.model.Player;
import com.turkeydash.storyboard.StoryBoard;


import java.util.ArrayList;
import java.util.List;

public class Home {
    private List<Ingredient> ingredientsToTally;
    private int score;
    private StoryBoard storyBoard = new StoryBoard();
    private Player player;
    private int points;
    private String file;


    public void execute(Player player) {
        setPlayer(player);
        setIngredientsToTally(player.getBasket());

        //TODO: begin Home operations
        tallyPoints();
        storyBoard.hostDinner();
        guestReactions();
        addBonusPoints();
        presentScore();
        celebrate();
    }

    private void celebrate() {

            if(points == 60){
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
    }

    private void addBonusPoints() {
        int bonusPoints = 0 ;
      setScore(points + bonusPoints);
    }

    private void guestReactions() {
        List<Dish> dishes = player.getMenu();
        int matches = 0 ;

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


    public List<Ingredient> getIngredientsToTally() {
        return ingredientsToTally;
    }

    public void setIngredientsToTally(List<Ingredient> ingredientsToTally) {
        this.ingredientsToTally = ingredientsToTally;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        score = score;
    }

    public StoryBoard getStoryBoard() {

        return storyBoard;
    }

    public void setStoryBoard(StoryBoard storyBoard) {
        this.storyBoard = storyBoard;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
