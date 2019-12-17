package controller;

import view.*;
import gamecenter.*;

import gamecenter.plants.*;
import gamecenter.zombies.*;
import gamecenter.AllUsers;
import gamecenter.AllUsers.*;

public class ViewController {
    static Menu menu = new Menu();
    static AllUsers allusers = new AllUsers();
    static String str = "";

    public static void main(String[] args) {

        loginMenu();
    }

    public static void loginMenu() {
        str = menu.loginMenu();
        int flag = 0;

        if (str.matches("help")) {
            menu.loginHelp();
        }

        if (str.matches("create account")) {
            flag = 1;
            String username = menu.getUserName();
            String password = menu.getPassword();
            if (!allusers.newUser(username, password)) {
                menu.invalidUser();
            } else {
                menu.loginMenu();
            }
        }

        if (str.matches("login")) {
            flag = 1;
            String username = menu.getUserName();
            String password = menu.getPassword();
            if (!allusers.login(username, password)) {
                menu.invalidUser();
            } else {
                mainMenu(menu.mainMenu());
            }
        }

        if (str.matches("leaderboard")) {
            flag = 1;
            leaderBoard();
        }

        if (str.matches("exit")) {
            return;
        }

        if (flag == 0)
            menu.invalidCommand();
    }

    public static void mainMenu(String str) {
        int flag = 0;
        str = menu.mainMenu();

        if (str.matches("play")) {
            flag = 1;
        }

        if (str.matches("profile")) {
            String str1 = menu.getProfileOrder();
            flag = 1;

            if (str1.matches("change")) {
                String username = menu.getUserName();
                String password = menu.getPassword();
                User.change(username, password);
            }

            if (str1.matches("delete")) {
                String username = menu.getUserName();
                String password = menu.getPassword();
                User.delete(username, password);
            }

            if (str1.matches("rename")) {
                String username = menu.getUserName();
                User.rename(username);
            }

            if (str1.matches("show")) {
                User.show();
            }

        }

        if (str.matches("shop")) {
            flag = 1;
        }

        if (str.matches("help")) {
            flag = 1;
            menu.mainmenuHelp();
        }

        if (flag == 0)
            menu.invalidCommand();
    }

    public static void leaderBoard() {
    }

}
