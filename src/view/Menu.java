package view;

import controller.ViewController;
import gamecenter.AllUsers;

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

        for (int i = 0; i < ViewController.allusers.users.size(); i++) {
            System.out.print("name" + ViewController.allusers.Leaderboard()[i] + "       killed");
            System.out.println(ViewController.allusers.Leaderboardnumbers()[i]);
        }
    }

    public void showShop() {

    }

    public void showCollection() {

    }

    public void showMoney() {

        System.out.println(ViewController.shop.getMoney());
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
}