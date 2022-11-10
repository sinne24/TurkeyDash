package com.turkeydash.client;

import com.turkeydash.app.TurkeyDashApp;
/*
 * TurkeyDash is a console based memory rpg, that asks
 * the user to choose 4 dishs to make for Thanksgiving
 * and then remember what ingredients they need for
 * those dishes.
 *
 * The flow of the program begins in the TurkeyDashApp
 * controller class, and from there travels to three
 * primary classes holding the majority of the business
 * logic; StoryBoard, GeneralStore, and Home, before
 * returning to the controller to determine when the game
 * should conclude.
 */
public class TurkeyDashClient {
    public static void main(String[] args) {
        TurkeyDashApp app = new TurkeyDashApp();
        app.execute();

    }
}
