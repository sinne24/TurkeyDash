package com.turkeydash.storyboard;

import com.turkeydash.dishmodel.*;
import com.turkeydash.locationmodel.Bakery;
import com.turkeydash.locationmodel.ButcherShop;
import com.turkeydash.locationmodel.FarmersMarket;
import com.turkeydash.locationmodel.LiquorStore;

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

        file = "data/presentButcher.txt";
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
                if (input == "C") {
                    selection = new Chicken();
                } else if (input == "T") {
                    selection = new Turkey();
                } else {
                    selection = new Ham();
                }
            }
        }
        System.out.println("Nice choice!");
        return selection;
    }

    public Dish presentBakery() {
        Dish selection = null;
        validInput = false;

        file = "data/presentBaker.txt";
        presentExpositionText(file);
        System.out.println("I serve: ");
        List<String> grains = butcher.getDishNames();
        dump(grains);
        System.out.println("Which of these would you like?");

        while (!validInput) {
            System.out.println("Please enter 'M'- for macaroni and cheese, 'B'- for french bread, or 'A' for apple pie. ");
            input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("M|B|A")) {
                validInput = true;
                if (input == "M") {
                    selection = new MacAndCheese();
                } else if (input == "B") {
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

        file = "data/presentFarmer.txt";
        presentExpositionText(file);
        System.out.println("I serve: ");
        List<String> grains = butcher.getDishNames();
        dump(grains);
        System.out.println("Which of these would you like?");

        while (!validInput) {
            System.out.println("Please enter 'G'- for green bean casserole, 'S'- for candied sweet potatoes, or 'C' for roasted corn. ");
            input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("G|S|C")) {
                validInput = true;
                if (input == "G") {
                    selection = new GreenBeanCasserole();
                } else if (input == "S") {
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
        //TODO: Create and read in Butcher file
        // Welcome, which meat would you like? Our options are:
        List<Dish> meats = liquorStore.getDishes();
        dump(meats);

        while (!validInput) {
            System.out.println("Please enter 'S'- for sangria, 'E'- for eggnog, or 'A' for aperol spritz. ");
            input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("S|E|A")) {
                validInput = true;
                if (input == "S") {
                    selection = new Sangria();
                } else if (input == "E") {
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
