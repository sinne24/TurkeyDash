package com.turkeydash.app;

import com.turkeydash.locationmodel.GeneralStore;
import com.turkeydash.locationmodel.Home;
import com.turkeydash.locationmodel.Location;
import com.turkeydash.model.Dish;
import com.turkeydash.model.Player;
import com.turkeydash.storyboard.StoryBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TurkeyDashApp {
    private Scanner scanner = new Scanner(System.in);
    private static boolean readyToContinue = false;
    GeneralStore generalStore;
    Player player;
    Home home;
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

        dishes.add(storyBoard.presentButcher());
        dishes.add(storyBoard.presentBakery());
        dishes.add(storyBoard.presentFarmersMarket());
        dishes.add(storyBoard.presentLiquorStore());

        player.setMenu(dishes);
        storyBoard.presentGeneralStore();
        player.setBasket(generalStore.execute());

        home.execute(player);

        playAgain();
    }

    private void playAgain() {
        System.out.println("Would you like to play again?");
        readyToContinue = storyBoard.readyToContinue();
        if(!readyToContinue){
            exit();
        }
    }

    private void startScreen() {
        //TODO: populate and add welcome banner
    }

    private void enterName() {
        player = new Player();
        System.out.println("Please enter you name: ");
        player.setName(scanner.nextLine().trim());
    }

    public void exit(){
        System.out.println("Goodbye");
        //TODO: terminate app
    }
}
