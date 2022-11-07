package com.turkeydash.locationmodel;

import com.turkeydash.model.Aisle;
import com.turkeydash.model.Player;
import com.turkeydash.model.Category;
import com.turkeydash.storyboard.Obstacle;
import com.turkeydash.model.Ingredient;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class GeneralStore extends Location {
    private static final String generalStoreFilePath = "conf/generalStoreList";
    private Obstacle obstacle;
    private final List<Ingredient> cart = new ArrayList<>();
    boolean continueToShop = true;
    private final int MIN_INPUT_VALUE = 1;
    private final int MAX_INPUT_VALUE = 6;

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

        while (continueToShop) {
            generalStoreGuide();
            int userChoice = scanner.nextInt();
            decisionValidator(userChoice);
        };
        saveCartToBasket(player);
        return cart;
    }

    private void generalStoreGuide() {
        // May replace with read-in CSV file.
        String checkoutLeave = "Checkout and leave?";
        System.out.printf("Where would you like to go?\n" +
                          "   1. %s\n" +
                          "   2. %s\n" +
                          "   3. %s\n" +
                          "   4. %s\n" +
                          "   5. %s\n" +
                          "   6. %s", produce, refrigerated, dryGoods, spirits, misc, checkoutLeave);
    }


    // method that only handles the decisions made by the user (decisionHandler)
    // contains a switch that calls methods that reads in food in a specific category and prints them
    private void decisionHandler(int userChoice) {

        switch (userChoice) {
            case 1:
                getAisleItems(produce.getCategory());
                selectItems(produce.getCategory());
                break;
            case 2:
                getAisleItems(refrigerated.getCategory());
                selectItems(refrigerated.getCategory());
                break;
            case 3:
                getAisleItems(dryGoods.getCategory());
                selectItems(dryGoods.getCategory());
                break;
            case 4:
                getAisleItems(spirits.getCategory());
                selectItems(dryGoods.getCategory());
                break;
            case 5:
                getAisleItems(misc.getCategory());
                selectItems(misc.getCategory());
            case 6:
                continueToShop = false;
                break;
        }
    }

    // method that opens a .csv files, reads in lines, and returns a hashmap
    // called by aisleMenu
    private Map<String, Ingredient> getAisleItems(Category aisleChoice) {
        Map<String, Ingredient> aisleMap = new HashMap<>();

        try {
            List<String> lines = Files.readAllLines(Path.of(generalStoreFilePath));

            for (String line : lines) {
                String[] tokens = line.split(",");
                String category = String.valueOf(tokens[0]);
                String itemName = tokens[1].toLowerCase();
//                Category ingredientCategory = Category.valueOf(category).;
                Ingredient ingredientItem = Ingredient.valueOf(itemName);
                if (category.equalsIgnoreCase(String.valueOf(aisleChoice))) {
                    aisleMap.putIfAbsent(category, ingredientItem);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aisleMap;
    }

    private void selectItems(Category aisleCategory) {
        boolean continueAddingItems = true;
        String itemSelection = scanner.nextLine();


        while (continueAddingItems) {
            System.out.println("Please type what you would you like.");
            // if it exists it can be added to the List
            if (itemValidator(itemSelection, aisleCategory)) {
                // selects the enum ingredient type that matches the validated input
                Ingredient selectedIngredient = Ingredient.valueOf(itemSelection);
                cart.add(selectedIngredient);
                System.out.printf("%s has been added to your cart!", itemSelection);
            }

            System.out.println("Would you like to add another item?");
            String addMoreItems = scanner.nextLine().trim().toUpperCase();

            // selection of "N" breaks the loop and ends the method
            if (addMoreItems.matches("N")) {
               continueAddingItems = false;
            }
        }
    }

    // COME BACK TO THIS
    public void decisionValidator(int userChoice) {
        boolean validInput = false;
        while (!validInput) {
            if (userChoice >= MIN_INPUT_VALUE && userChoice <= MAX_INPUT_VALUE) {
                validInput = true;
                decisionHandler(userChoice);
            } else {
                System.out.printf("Invalid selection, please choose a number between" +
                        " %s and %s\n", MIN_INPUT_VALUE, MAX_INPUT_VALUE);
            }
        }
        decisionHandler(userChoice);
    }

    public boolean itemValidator(String userInput, Category itemCategory) {
        boolean validInput = false;
        Map<String, Ingredient> aisleMap = getAisleItems(itemCategory);

        while (!validInput) {
            if (userInput.matches(String.valueOf(aisleMap.values()))) {
                validInput = true;
            }
            System.out.println("Item not found. Please try something else.");
        }
        return validInput;
    }

    private void saveCartToBasket(Player player) {
        List<Ingredient> currentBasket = player.getBasket();
        currentBasket.addAll(cart);
        player.setBasket(currentBasket);
    }

}
