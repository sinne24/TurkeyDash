package com.turkeydash.app;

import com.apps.util.Console;
import com.turkeydash.model.location.GeneralStore;
import com.turkeydash.model.location.Home;
import com.turkeydash.model.dish.Dish;
import com.turkeydash.model.Player;
import com.turkeydash.storyboard.StoryBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * TurkeyDashApp - Controller class of the program
 *
 * Here lies the framework of the overall playthrough.
 */
public class TurkeyDashApp {
    private static boolean readyToContinue = false;
    private static boolean play = true;
    private final Scanner scanner = new Scanner(System.in);
    private final GeneralStore generalStore = new GeneralStore();
    private Player player = new Player();
    private Home home = new Home();
    private List<Dish> dishes = new ArrayList<>();
    private StoryBoard storyBoard = new StoryBoard();

    public void execute() {
        startScreen();
        enterName();
        storyBoard.presentInstructions();
        System.out.println("Are you ready to continue? ");
        readyToContinue = storyBoard.readyToContinue();
        Console.pause(1000);
        Console.clear();
        if(!readyToContinue){
            exit();
        }
        while(play) {
            emptyPlayerHoldings();
            dishes.add(storyBoard.presentButcher());
            Console.pause(1000);
            dishes.add(storyBoard.presentBakery());
            Console.pause(1000);
            dishes.add(storyBoard.presentFarmersMarket());
            Console.pause(1000);
            dishes.add(storyBoard.presentLiquorStore());
            Console.pause(1000);

            player.setMenu(dishes);
            Console.clear();
            Console.pause(1000);
            storyBoard.presentGeneralStore();
            player.setBasket(generalStore.execute());
            Console.pause(1000);
            Console.clear();

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
        Console.clear();
        return true;
    }

    private void startScreen() {
        String file = "data/asciiArt/startBanner.txt";
        storyBoard.presentExpositionText(file);
    }

    private void enterName() {
        player = new Player();
        System.out.println("Please enter your name: ");
        player.setName(scanner.nextLine().trim());
        Console.clear();
        Console.pause(1000);
        System.out.println("Welcome " + player.getName() + "!");
    }

    public void exit(){
        scanner.close();
        System.out.println("Goodbye");
        System.exit(0);
    }
}
