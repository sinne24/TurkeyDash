package com.turkeydash.storyboard;

import com.turkeydash.dishmodel.Chicken;
import com.turkeydash.dishmodel.Ham;
import com.turkeydash.dishmodel.Turkey;
import com.turkeydash.locationmodel.Bakery;
import com.turkeydash.locationmodel.ButcherShop;
import com.turkeydash.locationmodel.FarmersMarket;
import com.turkeydash.locationmodel.LiquorStore;
import com.turkeydash.dishmodel.Dish;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class StoryBoard {
    private Scanner scanner = new Scanner(System.in);
    Bakery baker = new Bakery();
    ButcherShop butcher = new ButcherShop();
    LiquorStore liquorStore = new LiquorStore();
    FarmersMarket farmersMarket = new FarmersMarket();
    boolean validInput = false;
    String input;

    public void presentInstructions() {
        //TODO: Create and read in csv instruction file
        System.out.println("csv instruction file");
    }

    public boolean readyToContinue() {
        boolean readyToContinue = false;

        while (!validInput) {
            System.out.print("If so, please type 'Y' for yes. If not, " +
                    "type 'N' for no and the application will close: ");
            input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("Y|N")) {
                validInput = true;
                readyToContinue = ("Y".equals(input)) ? (readyToContinue = true) : (readyToContinue = false);
            }
        }
        return readyToContinue;
    }

    public Dish presentButcher() {
        Dish selection = null;
        validInput = false;
        //TODO: Create and read in Butcher file
        // Welcome, which meat would you like? Our options are:
        List<Dish> meats = butcher.getDishes();
        dump(meats);

        while (!validInput) {
            System.out.println("Please enter 'C'- for chicken, 'H'- for ham, or 'T' for turkey. ");
            input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("C|H|T")) {
                validInput = true;
                if (input == "C") {
                    selection = new Chicken();
                } else if (input == "T") {
                    selection = new Turkey();
                } else {
                    selection = new Ham();
                }
            }
        }
        return selection;
    }

    public Dish presentBakery() {
        Dish selection;
        validInput = false;
        //TODO: Create and read in Baker file
        List<Dish> grains = baker.getDishes();
        return takeInSelection(grains);
    }

    public Dish presentFarmersMarket() {
        Dish selection;
        validInput = false;
        //TODO: Create and read in farmer's market Proprietor file
        List<Dish> produce = farmersMarket.getDishes();
        return takeInSelection(produce);
    }

    public Dish presentLiquorStore() {
        Dish selection;
        validInput = false;
        //TODO: Create and read in liquor store Proprietor file
        List<Dish> beverage = liquorStore.getDishes();
        return takeInSelection(beverage);
    }

    private Dish takeInSelection(List<Dish> dishes) {
        Dish dish = null;
        //TODO: prompt for and set dish
        return dish;
    }

    private static void dump(Collection<?> collection) {
        collection.forEach(System.out::println);
    }

    public void presentGeneralStore() {
        Dish selection;
        //TODO: Create and read in general store file
    }

    public void hostDinner() {
        //TODO: present dinner text file
    }
}
