package com.turkeydash.locationmodel;

import com.turkeydash.model.Aisle;
import com.turkeydash.model.Player;
import com.turkeydash.model.Category;
import com.turkeydash.storyboard.Obstacle;
import com.turkeydash.model.Ingredient;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GeneralStore extends Location {
    private Obstacle obstacle;
    private final Scanner scanner = new Scanner(System.in);
    private final Aisle produce = new Aisle(Category.PRODUCE);
    private final Aisle refrigerated = new Aisle(Category.REFRIGERATED);
    private final Aisle dryGoods = new Aisle(Category.DRY_GOODS);
    private final Aisle spirits = new Aisle(Category.SPIRITS);
    private final Aisle misc = new Aisle(Category.MISC);

    /*
     * Player enters the store and is immediately asked which aisle they would like to visit.
     * Player types in the aisle they want, and the screen flashes pulling up a list of ingredients
     * in that aisle by Category. The player selects each item they think is necessary and adds it them
     * to their basket for that aisle. They are prompt to either visit another aisle or checkout and
     * leave the store. If they choose to leave the store it break the while loop and returns the user
     * back to the main menu.
     */
    public List<Ingredient> execute(Player player) {
        List<Ingredient> ingredientsToTakeHome = new ArrayList<>();

        //TODO: Begin gameplay design for the general store
        // maybe have a while loop to check if the player is
        // done in the store and ready to go home?
        // Once complete return to the TurkeyDashApp class

        //TODO:Allow user to return to sections of general store repeatedly.

        //TODO: Allow user to check basket

        return ingredientsToTakeHome;
    }

    private String generalStoreGreeting() {
        // May replace with read-in CSV file.
        System.out.printf("Where would you like to go?\n" +
                          "   1. %s\n" +
                          "   2. %s\n" +
                          "   3. %s\n" +
                          "   4. %s\n" +
                          "   5. %s\n%n", produce, refrigerated, dryGoods, spirits, misc);
        return scanner.nextLine();
    }
}
