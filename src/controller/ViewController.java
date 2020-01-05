package controller;

import view.*;
import gamecenter.*;


public class ViewController {
    static Menu menu = new Menu();
    public static AllUsers allusers = new AllUsers();
    static String str = "";
    public static Collection collection = new Collection();
    public static Shop shop = new Shop();
    public static Day day = new Day();
    public static Rail rail = new Rail();
    public static ZombieGameMode zombieGameMode = new ZombieGameMode();

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

            menu.invalidCommand();
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
                menu.showCollection_shop();
                continue;
            }

            if (str.matches("buy .+")) {
                String name = str.substring(str.indexOf("y") + 2);
                int status = shop.buyCard(name);
                if (status == 0)
                    menu.notEnoughMoney();
                if (status == -1)
                    menu.invalidCard();
                if (status == 2)
                    menu.itsBeenBoughtBefore();
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
                day.setDefaults();
                continue;
            }

            if (str.matches("water")) {
                continue;
            }

            if (str.matches("rail")) {
                rail();
                continue;
            }

            if (str.matches("zombie")) {
                zombie_mode();
                zombieGameMode.setDefaults();
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
                menu.showHandDay(day);
                continue;
            }

            if (str.matches("plant \\d+,\\d+")) {
                int i = Integer.parseInt(str.substring(str.indexOf("t") + 2, str.lastIndexOf(",")));
                int j = Integer.parseInt(str.substring(str.indexOf(",") + 1));
                int status = day.plantingPlant(i, j);
                if (status == 0) {
                    menu.invalidLine();
                }
                if (status == -1) {
                    menu.spaceIsFull();
                }
                continue;
            }

            if (str.matches("remove \\d+,\\d+")) {
                int i = Integer.parseInt(str.substring(str.indexOf("ve") + 3, str.lastIndexOf(",")));
                int j = Integer.parseInt(str.substring(str.indexOf(",") + 1));
                if (!day.removePlant(i, j)) {
                    menu.noPlantFounded();
                }
                continue;
            }

            if (str.matches("select .+")) {
                String name = str.substring(str.indexOf("t") + 2);
                int status = day.select(name);
                if (status == -1) {

                    menu.invalidCard();
                }
                if (status == 0) {

                    menu.notEnoughSun();
                }
                if (status == 1) {

                    menu.plantIsTired();
                }
                continue;
            }

            if (str.matches("end turn")) {
                int status = day.endTurn();
                if (status == 0) {
                    menu.zombieswin();
                    return;
                }
                if (status == 1) {
                    menu.plantswin();
                    return;
                }
                continue;
            }

            if (str.matches("show lawn")) {
                menu.showLawn(day);
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

    public static void rail() {
        while (true) {
            System.out.println("Day");
            String str = menu.getOrder();

            if (str.matches("list")) {
                menu.listRail();
                continue;
            }

            if (str.matches("record")) {
                menu.recordRail();
                continue;
            }

            if (str.matches("plant \\d+,\\d+")) {
                int i = Integer.parseInt(str.substring(str.indexOf("t") + 2, str.lastIndexOf(",")));
                int j = Integer.parseInt(str.substring(str.indexOf(",") + 1));
                if (!rail.plantingPlant(i, j)) {
                    menu.spaceIsFull();
                }
                continue;
            }

            if (str.matches("remove \\d+,\\d+")) {
                int i = Integer.parseInt(str.substring(str.indexOf("ve") + 3, str.lastIndexOf(",")));
                int j = Integer.parseInt(str.substring(str.indexOf(",") + 1));
                if (!rail.removePlant(i, j)) {
                    menu.noPlantFounded();
                }
                continue;
            }

            if (str.matches("select .+")) {
                String name = str.substring(str.indexOf("t") + 2);
                int status = rail.select(name);
                if (status == -1) {
                    menu.invalidCard();
                }
                if (status == 0) {
                    menu.notEnoughSun();
                }
                if (status == 1) {
                    menu.plantIsTired();
                }
                continue;
            }

            if (str.matches("end turn")) {

                continue;
            }

            if (str.matches("show lawn")) {
                menu.showLawn(rail);
                continue;
            }

            if (str.matches("help")) {
                menu.railHelp();
                continue;
            }

            if (str.matches("exit")) {
                return;
            }

            menu.invalidCommand();
        }
    }

    public static void zombie_mode() {
        collection_zombies();
        while (true) {
            System.out.println("zombies mode");
            String str = menu.getOrder();

            if (str.matches("show hand")) {
                menu.showHandZombies(zombieGameMode);
                continue;
            }

            if (str.matches("show lanes")) {
                menu.showLanes(zombieGameMode);
                continue;
            }

            if (str.matches("put .+,\\d+,\\d+")) {
                String name = str.substring(str.indexOf("t") + 2, str.indexOf(","));
                int number = Integer.parseInt(str.substring(str.indexOf(",") + 1, str.lastIndexOf(",")));
                int line = Integer.parseInt(str.substring(str.lastIndexOf(",") + 1));
                int status = zombieGameMode.put(name, number, line);
                if (status == 0) {
                    menu.notEnoughCoin();
                }
                if (status == -2) {
                    menu.invalidLine();
                }
                if (status == -1) {
                    menu.invalidCard();
                }
                if (status == 1) {
                    menu.outOfSize();
                }
                continue;
            }

            if (str.matches("start")) {
                zombieGameMode.setLadder();
                zombieGameMode.randomPlanting();
                while (true) {
                    System.out.println("start menu");
                    str = menu.getOrder();
                    if (str.matches("put ladder \\d+")) {
                        int line = Integer.parseInt(str.substring(str.lastIndexOf("r") + 1));
                        int status = zombieGameMode.putLadder(line);
                        if (status == 0)
                            menu.outOfLadder();
                        if (status == -1)
                            menu.invalidLine();
                        continue;
                    }

                    if (str.matches("end turn")) {
                        int status = zombieGameMode.endTurn();
                        if (status == 2) {
                            menu.zombieswin();
                            return;
                        }
                        if (status == 0) {
                            menu.plantswin();
                            return;
                        }
                        if (status == 1) {
                            menu.enterNextWave();
                            break;
                        }
                        continue;
                    }

                    if (str.matches("show lawn")) {
                        menu.showLawn(zombieGameMode);
                        continue;
                    }

                    menu.invalidCommand();
                }
                continue;
            }

            if (str.matches("help")) {
                menu.zombieHelp();
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
                menu.showHandPlants();
                continue;
            }

            if (str.matches("show collection")) {
                menu.showCollectionPlants();
                continue;
            }

            if (str.matches("select .+")) {
                String name = str.substring(str.indexOf("t") + 2);
                int status = collection.select(name);
                if (status == 0) {
                    menu.handIsFull();
                } else if (status == -1) {
                    menu.invalidCard();
                } else if (status == 2) {
                    menu.itsBeenSelectedBefore();
                }
                continue;
            }

            if (str.matches("remove .+")) {
                String name = str.substring(str.indexOf("ve") + 3);
                if (!collection.remove(name)) {
                    menu.invalidCard();
                }
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
                menu.showHandZombie();
                continue;
            }

            if (str.matches("show collection")) {
                menu.showCollectionZombies();
                continue;
            }

            if (str.matches("select .+")) {
                String name = str.substring(str.indexOf("t") + 2);
                int status = collection.select(name);
                if (status == 0) {
                    menu.handIsFull();
                } else if (status == -1) {
                    menu.invalidCard();
                } else if (status == 2) {
                    menu.itsBeenSelectedBefore();
                }
                continue;
            }

            if (str.matches("remove .+")) {
                String name = str.substring(str.indexOf("ve") + 3);
                if (!collection.remove(name)) {
                    menu.invalidCard();
                }
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


















