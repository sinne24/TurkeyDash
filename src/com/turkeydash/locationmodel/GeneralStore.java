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
    private static final String generalStoreFilePath = "conf/generalStoreList.csv";
    private Obstacle obstacle;
    private final List<Ingredient> cart = new ArrayList<>();
    boolean continueToShop = true;
    private final int MIN_INPUT_VALUE = 1;
    private final int MAX_INPUT_VALUE = 7;
    private final int cartLimit = 12;

    private final Scanner scanner = new Scanner(System.in);
    private final Aisle produce = new Aisle(Category.PRODUCE);
    private final Aisle refrigerated = new Aisle(Category.REFRIGERATED);
    private final Aisle dryGoods = new Aisle(Category.DRY_GOODS);
    private final Aisle spirits = new Aisle(Category.SPIRITS);
    private final Aisle misc = new Aisle(Category.MISC);

    public List<Ingredient> execute() {

        while (continueToShop) {
            generalStoreGuide();
            decisionValidator();
        };
        return cart;
    }

    private void generalStoreGuide() {
        // May replace with read-in CSV file.
        String checkoutLeave = "Checkout and leave?";
        String removeItems = "Remove items";
        System.out.printf("Where would you like to go?\n" +
                          "   1. %s\n" +
                          "   2. %s\n" +
                          "   3. %s\n" +
                          "   4. %s\n" +
                          "   5. %s\n" +
                          "   6. %s\n" +
                          "   7. %s\n", produce.getCategory(), refrigerated.getCategory(), dryGoods.getCategory(),
                                        spirits.getCategory(), misc.getCategory(), removeItems, checkoutLeave);
    }


    // method that only handles the decisions made by the user (decisionHandler)
    // contains a switch that calls methods that reads in food in a specific category and prints them
    private void decisionHandler(int userChoice) {

        switch (userChoice) {
            case 1:
                printItemList(getAisleItems(produce.getCategory()));
                selectItems(produce.getCategory());
                break;
            case 2:
                printItemList(getAisleItems(refrigerated.getCategory()));
                selectItems(refrigerated.getCategory());
                break;
            case 3:
                printItemList(getAisleItems(dryGoods.getCategory()));
                selectItems(dryGoods.getCategory());
                break;
            case 4:
                printItemList(getAisleItems(spirits.getCategory()));
                selectItems(spirits.getCategory());
                break;
            case 5:
                printItemList(getAisleItems(misc.getCategory()));
                selectItems(misc.getCategory());
                break;
            case 6:
                updateCart();
                break;
            case 7:
                continueToShop = false;
        }
    }

    private List<Ingredient> getAisleItems(Category aisleChoice) {
          List<Ingredient> ingredientArrayList = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Path.of(generalStoreFilePath));

            for (String line : lines) {
                String[] tokens = line.split(",");
                String category = String.valueOf(tokens[0]);
                String itemName = tokens[1].toUpperCase();
                Ingredient ingredientItem = Ingredient.valueOf(itemName);

                if (category.equals(aisleChoice.toString())) {
                    ingredientArrayList.add(ingredientItem);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ingredientArrayList;
    }

    private void printItemList(List<Ingredient> aisleList) {
        System.out.println("This aisle has:");
        for (Ingredient item : aisleList) {
            System.out.println(item);
        }
    }

    // TODO: break up this behemoth into other methods.
    private void selectItems(Category aisleCategory) {
        boolean continueAddingItems = true;

        while (continueAddingItems) {
            if (limitCart()) {
                System.out.println("\nYou've hit the maximum number of items that you can add to your cart!\n" +
                                   "You can checkout and leave the store, or remove some items from the main menu.\n");
                break;
            }
            System.out.println();
            System.out.println("Please type what you would you like (use underscores for spaces).");
            String itemSelection = scanner.next().toUpperCase();
            System.out.println();
            // if it exists it can be added to the List
            if (itemValidator(itemSelection.toUpperCase(), getAisleItems(aisleCategory))) {

                // selects the enum ingredient type that matches the validated input
                Ingredient selectedIngredient = Ingredient.valueOf(itemSelection);
                cart.add(selectedIngredient);
                System.out.printf("%s has been added to your cart!\n", itemSelection);
                checkCart();

                System.out.println("Would you like to add another item from this aisle? (Y/N)");
                String addMoreItems = scanner.next().trim().toUpperCase();
                System.out.println();

                if (addMoreItems.matches("N")) {
                    continueAddingItems = false;
                } else if(addMoreItems.matches("Y")) {
                    List<Ingredient> getAisleStuff = getAisleItems(aisleCategory);
                    printItemList(getAisleStuff);
                }
            } else {
                System.out.println("Item not found. Please try something else.");
                scanner.nextLine();
            }
        }
    }

    private void checkCart() {
        System.out.printf("You have %s items in your cart containing: %s\n", getCart().size(), getCart());
        System.out.println();
    }

    private boolean limitCart() {
        boolean limitReached = false;
        int cartSize = getCart().size();
        if (cartSize == cartLimit) {
            limitReached = true;
        }
        return limitReached;
    }

    private void updateCart() {
        boolean finishedUpdating = false;
        System.out.println("So which item(s) do you want to remove?");
        while (!finishedUpdating) {
            checkCart();
            String itemToRemove = scanner.next().toUpperCase();
            for (int i = 0; i < getCart().size(); i++) {
                Ingredient currentItem = getCart().get(i);
                if (itemToRemove.matches(String.valueOf(currentItem))) {
                    getCart().remove(currentItem);
                    System.out.printf("%s was removed from your cart",currentItem);
                }
            }
            checkCart();
            System.out.println("Remove anything else? (Y/N)");
            String removeMore = scanner.next();
            if (removeMore.matches("N")) {
                finishedUpdating = true;
            } else if(removeMore.matches("Y")) {
                System.out.println("Okay, what else do you want to remove?");
            }
        }

    }
    public void decisionValidator() {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Option: ");
                String input = scanner.next().trim();
                int parseInput = Integer.parseInt(input);
                if (parseInput >= MIN_INPUT_VALUE && parseInput <= MAX_INPUT_VALUE) {
                    System.out.println();
                    validInput = true;
                    decisionHandler(parseInput);
                } else {
                    System.out.printf("Invalid selection, please choose a number between" +
                            " %s and %s\n", MIN_INPUT_VALUE, MAX_INPUT_VALUE);
                }
            } catch (NumberFormatException e) {
                System.out.println("Your entry is not a number, please try again");
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean itemValidator(String userInput, List<Ingredient> aisleList) {
        boolean itemFound = false;

            for (Ingredient item : aisleList) {
                if (userInput.equals(item.toString())) {
                    itemFound = true;
                }
            }
        return itemFound;
    }

    public List<Ingredient> getCart() {
        return cart;
    }

    public static void main(String[] args) {
        GeneralStore test = new GeneralStore();
        test.execute();


    }
}
