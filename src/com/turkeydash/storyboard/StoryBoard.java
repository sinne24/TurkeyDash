package com.turkeydash.storyboard;

import com.turkeydash.dishmodel.*;
import com.turkeydash.locationmodel.Bakery;
import com.turkeydash.locationmodel.ButcherShop;
import com.turkeydash.locationmodel.FarmersMarket;
import com.turkeydash.locationmodel.LiquorStore;
import com.turkeydash.model.Ingredient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    String file;

    public void presentInstructions() {
        //TODO: Create and read in csv instruction file
        System.out.println("/////////////////////");
        System.out.println("CSV instruction file");
        System.out.println("/////////////////////");
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

        file = "data/locations/presentButcher.txt";
        presentExpositionText(file);
        System.out.println("I serve: ");
        List<String> meats = butcher.getDishNames();
        dump(meats);
        System.out.println("Which of these would you like?");

        while (!validInput) {
            System.out.println("Please enter 'C'- for chicken, 'H'- for ham, or 'T' for turkey. ");
            input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("C|H|T")) {
                validInput = true;
                if (input.equals("C")) {
                    selection = new Chicken();
                    file = "data/recipes/ChickenButcher.txt";
                } else if (input.equals("T")) {
                    selection = new Turkey();
                    file = "data/recipes/TurkeyButcher.txt";
                } else {
                    selection = new Ham();
                    file = "data/recipes/HamButcher.txt";
                }
            }
        }
        presentExpositionText(file);
        return selection;

    }

    public Dish presentBakery() {
        Dish selection = null;
        validInput = false;

        file = "data/locations/presentBaker.txt";
        presentExpositionText(file);
        System.out.println("I serve: ");
        List<String> grains = baker.getDishNames();
        dump(grains);
        System.out.println("Which of these would you like?");

        while (!validInput) {
            System.out.println("Please enter 'M'- for macaroni and cheese, 'G'- for garlic bread, or 'A' for apple pie. ");
            input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("M|G|A")) {
                validInput = true;
                if (input.equals("M")) {
                    selection = new MacAndCheese();
                } else if (input.equals("G")) {
                    selection = new GarlicBread();
                } else {
                    selection = new ApplePie();
                }
            }
        }
        return selection;
    }

    public Dish presentFarmersMarket() {
        Dish selection = null;
        validInput = false;

        file = "data/locations/presentFarmer.txt";
        presentExpositionText(file);
        System.out.println("I serve: ");
        List<String> grains = farmersMarket.getDishNames();
        dump(grains);
        System.out.println("Which of these would you like?");

        while (!validInput) {
            System.out.println("Please enter 'G'- for green bean casserole, 'S'- for candied sweet potatoes, or 'C' for roasted corn. ");
            input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("G|S|C")) {
                validInput = true;
                if (input.equals("G")) {
                    selection = new GreenBeanCasserole();
                } else if (input.equals("S")) {
                    selection = new CandiedSweetPotatoes();
                } else {
                    selection = new RoastedCorn();
                }
            }
        }
        return selection;
    }

    public Dish presentLiquorStore() {
        Dish selection = null;
        validInput = false;

        file = "data/locations/presentLiquorEmployee.txt";
        presentExpositionText(file);
        System.out.println("I serve: ");
        List<String> grains = liquorStore.getDishNames();
        dump(grains);
        System.out.println("Which of these would you like?");

        while (!validInput) {
            System.out.println("Please enter 'S'- for sangria, 'E'- for eggnog, or 'A' for aperol spritz. ");
            input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("S|E|A")) {
                validInput = true;
                if (input.equals("S")) {
                    selection = new Sangria();
                } else if (input.equals("E")) {
                    selection = new Eggnog();
                } else {
                    selection = new AperolSpritz();
                }
            }
        }
        return selection;
    }

    void presentExpositionText(String file){
        try{
            String exposition = Files.readString(Paths.get(file)); //Java 11. Path.of()
            System.out.println(exposition);
        } catch (IOException e){
            e.printStackTrace();
        }

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
