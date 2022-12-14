package com.turkeydash.storyboard;

import com.turkeydash.model.location.Bakery;
import com.turkeydash.model.location.ButcherShop;
import com.turkeydash.model.location.FarmersMarket;
import com.turkeydash.model.location.LiquorStore;
import com.turkeydash.model.dish.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class StoryBoard {
    private final Scanner scanner = new Scanner(System.in);
    private Bakery baker = new Bakery();
    private ButcherShop butcher = new ButcherShop();
    private LiquorStore liquorStore = new LiquorStore();
    private FarmersMarket farmersMarket = new FarmersMarket();
    private boolean validInput = false;
    private String input;
    private String file;

    public void presentInstructions() {
        file = "data/IntroInstructions.txt";
        presentExpositionText(file);
        file = "data/gameInstructions.txt";
        presentExpositionText(file);
        System.out.println();
    }

    public boolean readyToContinue() {
        boolean readyToContinue = false;
        validInput = false;

        while (!validInput) {
            System.out.print("If so, please type 'Y' for yes. If not, " +
                    "type 'N' for no and the application will close: ");
            input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("Y|N")) {
                validInput = true;
                readyToContinue = ("Y".equalsIgnoreCase(input)) ? (readyToContinue = true) : (readyToContinue = false);
            }
        }
        System.out.println();
        return readyToContinue;
    }

    public Dish presentButcher() {
        Dish selection = null;
        validInput = false;

        file = "data/locations/presentButcher.txt";
        presentExpositionText(file);
        System.out.println("I serve: ");
        System.out.println();
        List<String> meats = butcher.getDishNames();
        dump(meats);
        System.out.println("Which of these would you like?");

        while (!validInput) {
            System.out.println("Please enter 'C'- for chicken, 'H'- for ham, or 'T' for turkey. ");
            input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("C|H|T")) {
                validInput = true;
                if (input.equals("C")) {
                    selection = Dishes.get("Chicken");
                    file = "data/recipes/ChickenButcher.txt";
                } else if (input.equals("T")) {
                    selection = Dishes.get("Turkey");
                    file = "data/recipes/TurkeyButcher.txt";
                } else {
                    selection = Dishes.get("Ham");
                    file = "data/recipes/HamButcher.txt";
                }
            }
        }
        System.out.println();
        presentExpositionText(file);
        return selection;
    }

    public Dish presentBakery() {
        Dish selection = null;
        validInput = false;

        file = "data/locations/presentBaker.txt";
        presentExpositionText(file);
        System.out.println("I serve: ");
        System.out.println();
        List<String> grains = baker.getDishNames();
        dump(grains);
        System.out.println("Which of these would you like?");

        while (!validInput) {
            System.out.println("Please enter 'M'- for macaroni and cheese, 'G'- for garlic bread, or 'A' for apple pie. ");
            input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("M|G|A")) {
                validInput = true;
                if (input.equals("M")) {
                    selection = Dishes.get("Mac n Cheese");
                    file = "data/recipes/MacnCheeseBakery.txt";
                } else if (input.equals("G")) {
                    selection = Dishes.get("Garlic Bread");
                    file = "data/recipes/GarlicBreadBakery.txt";
                } else {
                    selection = Dishes.get("Apple Pie");
                    file = "data/recipes/ApplePieBakery.txt";
                }
            }
        }
        System.out.println();
        presentExpositionText(file);
        return selection;
    }

    public Dish presentFarmersMarket() {
        Dish selection = null;
        validInput = false;

        file = "data/locations/presentFarmer.txt";
        presentExpositionText(file);
        System.out.println("I serve: ");
        System.out.println();
        List<String> grains = farmersMarket.getDishNames();
        dump(grains);
        System.out.println("Which of these would you like?");

        while (!validInput) {
            System.out.println("Please enter 'G'- for green bean casserole, 'C'- for candied sweet potatoes, or 'R' for roasted corn. ");
            input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("G|C|R")) {
                validInput = true;
                if (input.equals("G")) {
                    selection = Dishes.get("Green Bean Casserole");
                    file = "data/recipes/GreenBeanCas.txt";
                } else if (input.equals("C")) {
                    selection = Dishes.get("Candied Sweet Potato");
                    file = "data/recipes/SweetPoFarmer.txt";
                } else {
                    selection = Dishes.get("Roasted Corn");
                    file = "data/recipes/RoastedCorn.txt";
                }
            }
        }
        System.out.println();
        presentExpositionText(file);
        return selection;
    }

    public Dish presentLiquorStore() {
        Dish selection = null;
        validInput = false;

        file = "data/locations/presentLiquorEmployee.txt";
        presentExpositionText(file);
        System.out.println("I serve: ");
        System.out.println();
        List<String> grains = liquorStore.getDishNames();
        dump(grains);
        System.out.println("Which of these would you like?");

        while (!validInput) {
            System.out.println("Please enter 'S'- for sangria, 'E'- for eggnog, or 'A' for aperol spritz. ");
            input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("S|E|A")) {
                validInput = true;
                if (input.equals("S")) {
                    selection = Dishes.get("Sangria");
                    file = "data/recipes/SangriaLiquor.txt";
                } else if (input.equals("E")) {
                    selection = Dishes.get("Eggnog");
                    file = "data/recipes/EggnogLiquor.txt";
                } else {
                    selection = Dishes.get("Aperol Spritz");
                    file = "data/recipes/AperolSpritz.txt";
                }
            }
        }
        System.out.println();
        presentExpositionText(file);
        return selection;
    }

    public void presentExpositionText(String file){
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
        System.out.println();
        file = "data/locations/presentGeneralStore.txt";
        presentExpositionText(file);
    }

    public void hostDinner() {
        file = "data/locations/presentHome.txt";
        presentExpositionText(file);
    }
}
