package com.turkeydash.storyboard;

import com.turkeydash.model.Dish;
import com.turkeydash.model.Ingredient;

import java.util.List;
import java.util.Scanner;

public class StoryBoard {
    private Scanner scanner = new Scanner(System.in);

    public void presentInstructions() {
        //TODO: Create and read in csv instruction file
        System.out.println("csv instruction file");
    }

    public boolean readyToContinue() {
        boolean readyToContinue = false;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("If so, please type 'Y' for yes. If not, " +
                    "type 'N' for no and the application will close: ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("Y|N")) {
                validInput = true;
                readyToContinue = ("Y".equals(input)) ? (readyToContinue = true) : (readyToContinue = false);

            }
        }
        return readyToContinue;
    }

    public Dish presentButcher() {
        Dish selection;
        //TODO: Create and read in Butcher file
        List<Dish> meats = butcher.getDishes();
        return takeInSelection(meats);
    }

    public Dish presentBakery() {
        Dish selection;
        //TODO: Create and read in Baker file
        List<Dish> grains = baker.getDishes();
        return takeInSelection(grains);
    }

    public Dish presentFarmersMarket() {
        Dish selection;
        //TODO: Create and read in farmer's market Proprietor file
        List<Dish> produce = farmersMarket.getDishes();
        return takeInSelection(produce);
    }

    public Dish presentLiquorStore() {
        Dish selection;
        //TODO: Create and read in liquor store Proprietor file
        List<Dish> beverage = liquorStore.getDishes();
        return takeInSelection(beverage);
    }

    private Dish takeInSelection(List<Dish> dishes) {
        Dish dish = null;
        //TODO: prompt for and set dish

        return dish;
    }

    public void presentGeneralStore() {
        Dish selection;
        //TODO: Create and read in general store file
    }
}
