package view;

import controller.ViewController;
import gamecenter.AllUsers;
import controller.ViewController.*;
import gamecenter.Day;
import gamecenter.GameMode;
import gamecenter.ZombieGameMode;
import gamecenter.zombies.Zombies;

import java.util.ArrayList;
import java.util.HashMap;
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

    public void railHelp() {

        System.out.println("list//record//plant//remove//show lawn//end turn//end turn");
    }

    public void zombieHelp() {

        System.out.println("show hand//show lanes//put//start//end turn//show lawn");
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
        ArrayList<String> name = ViewController.shop.ShowShop();
        ArrayList<Integer> number = ViewController.shop.ShowShopprices();
        for (int i = 0; i < name.size(); i++) {
            System.out.println(name.get(i) + " Price: " + number.get(i));
        }
    }

    public void showCollection_shop() {
        ArrayList<String> name = ViewController.shop.ShowCollectionPlants();
        ArrayList<String> name1 = ViewController.shop.ShowCollectionZombies();
        for (int i = 0; i < name.size(); i++) {
            System.out.print(name.get(i) + "//");
        }
        System.out.println();
        for (int i = 0; i < name1.size(); i++) {
            System.out.print(name1.get(i) + "//");
        }
        System.out.println();
    }

    public void showMoney() {

        System.out.println(ViewController.shop.getMoney());
    }

    public void showHandZombie() {
        ArrayList<String> name = ViewController.collection.showHandZombie();
        for (int i = 0; i < name.size(); i++) {
            System.out.print(name.get(i) + "//");
        }
        System.out.println();
    }

    public void showHandPlants() {
        ArrayList<String> name = ViewController.collection.showHandPlants();
        for (int i = 0; i < name.size(); i++) {
            System.out.print(name.get(i) + "//");
        }
        System.out.println();
    }

    public void showCollectionPlants() {
        ArrayList<String> name = ViewController.collection.showCollectionPlants();
        for (int i = 0; i < name.size(); i++) {
            System.out.print(name.get(i) + "//");
        }
        System.out.println();
    }

    public void showCollectionZombies() {
        ArrayList<String> name = ViewController.collection.showCollectionZombies();
        for (int i = 0; i < name.size(); i++) {
            System.out.print(name.get(i) + "//");
        }
        System.out.println();
    }

    public void showHandDay(Day day) {
        ArrayList<String> name = day.showHand();
        for (int i = 0; i < name.size(); i++) {
            System.out.print(name.get(i) + " sun " + day.showHandSun().get(i) + " Cd " + day.showHandCool().get(i));
        }
        System.out.println();
    }

    public void showHandZombies(ZombieGameMode zombieGameMode) {
        ArrayList<String> name = zombieGameMode.showHand();
        for (int i = 0; i < name.size(); i++) {
            System.out.print(name.get(i) + " health " + zombieGameMode.showHandHealth().get(i));
        }
        System.out.println();
    }

    public void showLawn(GameMode gameMode) {
        ArrayList<String> name = gameMode.showLawn();
        for (int i = 0; i < name.size(); i++) {
            System.out.print(name.get(i) + " Y " + gameMode.showLawnX().get(i) + " X " + gameMode.showLawnY().get(i) + " Health " + gameMode.showLawnHealth().get(i));
            if (i == gameMode.numberOfPlants()) {
                System.out.println();
            } else if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
    }

    public void showLanes(ZombieGameMode zombieGameMode) {
        HashMap<String,String> showlanes = zombieGameMode.showLanes();
        for (int i = 0; i < 6; i++) {
            System.out.println(i + showlanes.get(Integer.toString(i)));
        }
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

    public void notEnoughMoney() {

        System.out.println("Not enough money");
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

    public void handIsFull() {

        System.out.println("hand is full");
    }

    public void itsBeenSelectedBefore() {

        System.out.println("its been selected before");
    }

    public void itsBeenBoughtBefore() {

        System.out.println("its been bought before");
    }

    public void notEnoughCoin() {

        System.out.println("not enough coin");
    }

    public void outOfSize() {

        System.out.println("out of size");
    }

    public void invalidLine() {

        System.out.println("invalid line");
    }
}