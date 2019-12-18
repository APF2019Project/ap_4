package controller;

import view.*;
import gamecenter.*;


public class ViewController {
    static Menu menu = new Menu();
    public static AllUsers allusers = new AllUsers();
    static String str = "";

    public static void main(String[] args) {

        loginMenu();
    }

    public static void loginMenu() {
        int flag = 0;
        while (true) {
            flag = 0;
            str = menu.getOrder();
            System.out.println("loginmenu");

            if (str.matches("help")) {
                flag = 1;
                menu.loginHelp();
            }

            if (str.matches("create account")) {
                flag = 1;
                String username = menu.getUserName();
                String password = menu.getPassword();
                if (!allusers.newUser(username, password)) {
                    menu.invalidUser();
                    continue;
                } else {
                    continue;
                }
            }

            if (str.matches("login")) {
                flag = 1;
                String username = menu.getUserName();
                String password = menu.getPassword();
                if (!allusers.login(username, password)) {
                    menu.invalidUser();
                    continue;
                } else {
                    mainMenu();
                }
            }

            if (str.matches("leaderboard")) {
                flag = 1;
                leaderBoard();
                continue;
            }

            if (str.matches("exit")) {
                return;
            }

            if (flag == 0) {
                menu.invalidCommand();
                loginMenu();
            }
        }
    }

    public static void mainMenu() {
        int flag = 0;
        while (true) {
            flag = 0;
            System.out.println("mainmenu");
            String str = menu.getOrder();

            if (str.matches("play")) {
                flag = 1;
            }

            if (str.matches("profile")) {
                profile();
                continue;
            }

            if (str.matches("shop")) {
                flag = 1;
            }

            if (str.matches("help")) {
                menu.mainmenuHelp();
                continue;
            }

            if (str.matches("exit")) {
                loginMenu();
            }

            if (flag == 0) {
                menu.invalidCommand();
                continue;
            }
        }
    }

    public static void leaderBoard() {
        for (int i = 0; i < allusers.users.size(); i++) {
            System.out.print("name" + allusers.Leaderboard()[i] + "       killed");
            System.out.println(allusers.Leaderboardnumbers()[i]);
        }
        while (true){
            String str = menu.getOrder();
            if (str.matches("exit")){
                return;
            }
            menu.invalidCommand();
        }
    }

    public static void profile() {
        while (true) {
            System.out.println("profile");
            String str = menu.getOrder();

            if (str.matches("change")) {
                String username = menu.getUserName();
                String password = menu.getPassword();
                User.change(username, password);
                continue;
            }

            if (str.matches("delete")) {
                String username = menu.getUserName();
                String password = menu.getPassword();
                User.deleteUser(username, password);
                continue;
            }

            if (str.matches("rename")) {
                String username = menu.getUserName();
                User.renameUsername(username);
                continue;
            }

            if (str.matches("show")) {
                menu.showCurrentUser();
                continue;
            }

            if (str.matches("help")) {
                menu.profileHelp();
                continue;
            }

            if (str.matches("exit")) {
                return;
            }

            menu.invalidCommand();
        }
    }
}
