package view;

import controller.ViewController;
import gamecenter.AllUsers;
import controller.ViewController.*;
import gamecenter.Day;
import gamecenter.GameMode;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);

    public String getOrder() {

        return input.nextLine().toLowerCase();
    }

    public void loginHelp() {

        System.out.println("//Create your account//Login//Leaderboard");
    }

    public void mainmenuHelp() {

        System.out.println("//Play//Profile//Shop");
    }

    public void profileHelp() {

        System.out.println("change//rename//show//delete");
    }

    public void shopHelp() {

        System.out.println("show hand//show collection//play//buy card");
    }

    public void playHelp() {

        System.out.println("day//zombie//rail//pvp//water");
    }

    public void collectionHelp() {

        System.out.println("show hand//show collection//play//select//remove");
    }

    public void dayHelp() {

        System.out.println("show hand//select//plant//remove//show lawn//end turn");
    }

    public void showLaeaderboards() {
        String[] name = ViewController.allusers.Leaderboard();
        int[] number = ViewController.allusers.Leaderboardnumbers();
        for (int i = 0; i < ViewController.allusers.users.size(); i++) {
            System.out.print("name " + name[i] + " killed");
            System.out.println(number[i]);
        }
    }

    public void showShop() {
        for (int i = 0; i < ViewController.shop.ShowShop().size(); i++) {
            System.out.println(ViewController.shop.ShowShop().get(i) +"     "+ ViewController.shop.ShowShopprices().get(i).intValue());
        }
    }

    public void showCollection_shop() {
        for (int i = 0; i < ViewController.shop.ShowCollectionPlants().size(); i++) {
            System.out.print(ViewController.shop.ShowCollectionPlants().get(i) + "//");
        }
        System.out.println();
    }

    public void showMoney() {

        System.out.println(ViewController.shop.getMoney());
    }

    public void showHandZombie() {
        for (int i = 0; i < ViewController.collection.showHandZombie().size(); i++) {
            System.out.print(ViewController.collection.showHandZombie().get(i) + "//");
        }
        System.out.println();
    }

    public void showHandPlants() {
        for (int i = 0; i < ViewController.collection.showHandPlants().size(); i++) {
            System.out.print(ViewController.collection.showHandPlants().get(i) + "//");
        }
        System.out.println();
    }

    public void showCollectionPlants() {
        for (int i = 0; i < ViewController.collection.showCollectionPlants().size(); i++) {
            System.out.print(ViewController.collection.showCollectionPlants().get(i) + "//");
        }
        System.out.println();
    }

    public void showCollectionZombies() {
        for (int i = 0; i < ViewController.collection.showCollectionZombies().size(); i++) {
            System.out.print(ViewController.collection.showCollectionZombies().get(i) + "//");
        }
        System.out.println();
    }
    
    public void showHandDay(Day day) {
        for (int i = 0; i < day.showHand().size(); i++) {
            System.out.print(day.showHand().get(i) +" sun "+ day.showHandSun().get(i) +" Cd "+ day.showHandCool().get(i));
        }
    }

    public void showLawn(GameMode gameMode) {

//        for (int i = 0; i < gameMode.; i++) {
//            System.out.print(gameMode.showLawn().get(i) + " x " + gameMode.showLawnX().get(i) +" Y "+ gameMode.showLawnY().get(i) +" Health "+ gameMode.showLawnHealth().get(i));
//
//        }
    }

    public void showCurrentUser() {

        System.out.println(AllUsers.currentuser);
    }

    public String getUserName() {
        String str = input.nextLine();
        return str;
    }

    public String getPassword() {
        String str = input.nextLine();
        return str;
    }

    public void invalidUser() {

        System.out.println("invalid username or Password");
    }

    public void invalidCommand() {

        System.out.println("invalid command");
    }

    public void invalidCard() {

        System.out.println("invalid card");
    }

    public void notEnoughSun() {

        System.out.println("Not enough sun");
    }

    public void plantIsTired() {

        System.out.println("Plant Is Tired :((");
    }

    public void spaceIsFull() {

        System.out.println("space is full");
    }

    public void noPlantFounded() {

        System.out.println("no plant founded");
    }
}