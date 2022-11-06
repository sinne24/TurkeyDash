package com.turkeydash.locationmodel;

import com.turkeydash.model.Ingredient;
import com.turkeydash.model.Player;
import com.turkeydash.storyboard.StoryBoard;

import java.util.List;

public class Home {
    private List<Ingredient> ingredientsToTally;
    private int Score;
    private StoryBoard storyBoard;
    private Player player;


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

//    private void packagePlayer(Player player){
//       this.player = player;
//    }

    private void celebrate() {
    }

    private void presentScore() {
    }

    private void addBonusPoints() {
    }

    private void guestReactions() {
    }

    private void tallyPoints() {
    }

    public List<Ingredient> getIngredientsToTally() {
        return ingredientsToTally;
    }

    public void setIngredientsToTally(List<Ingredient> ingredientsToTally) {
        this.ingredientsToTally = ingredientsToTally;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
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
