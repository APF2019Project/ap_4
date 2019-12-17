package view;

import java.util.Scanner;

public class Menu {

    private int attribute;

    Scanner input = new Scanner(System.in);

    public String loginMenu() {
        System.out.println("Enter your choice: Loginmenu");
        String str = input.nextLine();
        return str.toLowerCase();
    }

    public void loginHelp() {

        System.out.println("//Create your account//Login//Leaderboard");
    }

    public void mainmenuHelp() {

        System.out.println("//Play//Profile//Shop");
    }

    public String mainMenu() {
        System.out.println("Enter your choice : mainmenu");
        String str = input.nextLine();
        return str.toLowerCase();
    }

    public String getProfileOrder() {

        return input.nextLine().toLowerCase();
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


















    public void profile() {
        throw new UnsupportedOperationException();
    }

    public void play() {
        throw new UnsupportedOperationException();
    }

    public void collection() {
        throw new UnsupportedOperationException();
    }

    public void leaderboard() {
        throw new UnsupportedOperationException();
    }


    public void shop() {
        throw new UnsupportedOperationException();
    }

    public void PvP() {
        throw new UnsupportedOperationException();
    }

    public void Zombie() {
        throw new UnsupportedOperationException();
    }

    public void Rail() {
        throw new UnsupportedOperationException();
    }

    public void DayandWater() {
        throw new UnsupportedOperationException();
    }

    public void help() {

    }

}