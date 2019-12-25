package controller;

import view.*;
import gamecenter.*;


public class ViewController {
    static Menu menu = new Menu();
    public static AllUsers allusers = new AllUsers();
    static String str = "";
    public static Collection collection = new Collection();
    public static Shop shop = new Shop();

    public static void main(String[] args) {

        loginMenu();
    }

    public static void loginMenu() {
        int flag = 0;
        while (true) {
            flag = 0;
            System.out.println("loginmenu");
            str = menu.getOrder();

            if (str.matches("help")) {
                flag = 1;
                menu.loginHelp();
                continue;
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
                continue;
            }
        }
    }

    public static void mainMenu() {
        while (true) {
            System.out.println("mainmenu");
            String str = menu.getOrder();

            if (str.matches("play")) {
                play();
                continue;
            }

            if (str.matches("profile")) {
                profile();
                continue;
            }

            if (str.matches("shop")) {
                shop();
                continue;
            }

            if (str.matches("help")) {
                menu.mainmenuHelp();
                continue;
            }

            if (str.matches("exit")) {
                return;
            }

        }
    }

    public static void leaderBoard() {
        menu.showLaeaderboards();
        while (true) {
            String str = menu.getOrder();
            if (str.matches("exit")) {
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
                if (!User.deleteUser(username, password)) {
                    menu.invalidUser();
                }
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

    public static void shop() {
        while (true) {
            System.out.println("Shop");
            String str = menu.getOrder();

            if (str.matches("show shop")) {
                menu.showShop();
                continue;
            }

            if (str.matches("show collection")) {
                menu.showCollection();
                continue;
            }

            if (str.matches("buy \\w+")) {
                String name = str.substring(str.indexOf("y") + 2);
                shop.buyCard(name);
                continue;
            }

            if (str.matches("money")) {
                menu.showMoney();
                continue;
            }

            if (str.matches("help")) {
                menu.shopHelp();
                continue;
            }

            if (str.matches("exit")) {
                return;
            }

            menu.invalidCommand();
        }
    }

    public static void play() {

        while (true) {
            System.out.println("Play");
            String str = menu.getOrder();

            if (str.matches("day")) {
                day();
                continue;
            }

            if (str.matches("water")) {
                continue;
            }

            if (str.matches("rail")) {
                continue;
            }

            if (str.matches("zombie")) {
                continue;
            }

            if (str.matches("pvp")) {
                continue;
            }

            if (str.matches("help")) {
                menu.playHelp();
                continue;
            }

            if (str.matches("exit")) {
                return;
            }

            menu.invalidCommand();
        }
    }

    public static void day() {
        collection_plants();
        while (true) {
            System.out.println("Day");
            String str = menu.getOrder();

            if (str.matches("show hand")) {
                continue;
            }

            if (str.matches("plant \\d+,\\d+")) {
                continue;
            }

            if (str.matches("remove \\d+,\\d+")) {
                continue;
            }

            if (str.matches("select \\w+")) {
                continue;
            }

            if (str.matches("end turn")) {
                continue;
            }

            if (str.matches("show lawn")) {
                continue;
            }

            if (str.matches("help")) {
                menu.dayHelp();
                continue;
            }

            if (str.matches("exit")) {
                return;
            }

            menu.invalidCommand();
        }
    }

    public static void collection_plants() {
        while (true) {
            System.out.println("Collection(Plants)");
            String str = menu.getOrder();

            if (str.matches("show hand")) {
                continue;
            }

            if (str.matches("show collection")) {
                continue;
            }

            if (str.matches("select \\w+")) {
                continue;
            }

            if (str.matches("remove \\w+")) {
                continue;
            }

            if (str.matches("help")) {
                menu.collectionHelp();
                continue;
            }

            if (str.matches("exit") || str.matches("play")) {
                return;
            }

            menu.invalidCommand();
        }
    }

    public static void collection_zombies() {
        while (true) {
            System.out.println("Collection(Zombies)");
            String str = menu.getOrder();

            if (str.matches("show hand")) {
                continue;
            }

            if (str.matches("show collection")) {
                continue;
            }

            if (str.matches("select \\w+")) {
                continue;
            }

            if (str.matches("remove \\w+")) {
                continue;
            }

            if (str.matches("help")) {
                menu.collectionHelp();
                continue;
            }

            if (str.matches("exit") || str.matches("play")) {
                return;
            }

            menu.invalidCommand();
        }
    }

}


















