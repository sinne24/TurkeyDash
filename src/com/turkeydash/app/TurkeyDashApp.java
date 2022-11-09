package com.turkeydash.app;

import com.turkeydash.locationmodel.GeneralStore;
import com.turkeydash.locationmodel.Home;
import com.turkeydash.dishmodel.Dish;
import com.turkeydash.model.Ingredient;
import com.turkeydash.model.Player;
import com.turkeydash.storyboard.StoryBoard;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TurkeyDashApp {
    // Maybe we can implement a Scanner class that gets the same Scanner in several places instead of creating multiple
    // instances that we have to go back and close.
    private final Scanner scanner = new Scanner(System.in);
    private static boolean readyToContinue = false;
    private static boolean play = true;
    GeneralStore generalStore = new GeneralStore();
    Player player = new Player();
    Home home = new Home();
    List<Dish> dishes = new ArrayList<>();
    StoryBoard storyBoard = new StoryBoard();

    public void execute() {
        startScreen();
        enterName();
        storyBoard.presentInstructions();
        System.out.println("Are you ready to continue? ");
        readyToContinue = storyBoard.readyToContinue();
        if(!readyToContinue){
            exit();
        }
        while(play) {
            if(!player.getBasket().isEmpty()) {
                emptyPlayerHoldings();
            }
            dishes.add(storyBoard.presentButcher());
            dishes.add(storyBoard.presentBakery());
            dishes.add(storyBoard.presentFarmersMarket());
            dishes.add(storyBoard.presentLiquorStore());

            player.setMenu(dishes);
            storyBoard.presentGeneralStore();
            player.setBasket(generalStore.execute());

            home.execute(player);

            play = playAgain();
        }
    }

    private void emptyPlayerHoldings() {
        player.emptyPlayerItems();
    }

    private boolean playAgain() {
        System.out.println("\nWould you like to play again?");
        readyToContinue = storyBoard.readyToContinue();
        if(!readyToContinue){
            play = false;
            exit();
        }
        return true;
    }

    private void startScreen() {
        //TODO: populate and add welcome banner
        System.out.println("S T A R T    S C R E E N");
        System.out.println("-------------------------");
    }

    private void enterName() {
        player = new Player();
        System.out.println("Please enter you name: ");
        player.setName(scanner.nextLine().trim());
        System.out.println("Welcome " + player.getName() + "!");
    }

    public void exit(){
        scanner.close();                // Scott --> closes the scanner
        System.out.println("Goodbye");
        System.exit(0);           // Scott --> tells the JVM to terminate
    }
}
