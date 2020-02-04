package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.*;
import gamecenter.*;


public class ViewController {

    static Menu menu = new Menu();
    public static AllUsers allusers = new AllUsers();
    public static Collection collection = new Collection();
    public static Shop shop = new Shop();
    public static Day day = new Day();
    public static Rail rail = new Rail();
    public static ZombieGameMode zombieGameMode = new ZombieGameMode();

    public static String loginMenu(String order, String username, String password) {
        System.out.println("loginmenu");

        if (order.matches("create account")) {
            if (!allusers.newUser(username, password)) {
                menu.invalidUser();
                return "already exist";
            } else {
                return "account created";
            }
        }

        if (order.matches("login")) {
            if (!allusers.login(username, password)) {
                return "invalid username or password";
            } else {
                return "mainmenu";
            }
        }

        if (order.matches("leaderboard")) {
            leaderBoard();
        }
        return "null";
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

    public static String profile(String order, String username, String password) {
            System.out.println("profile");

            if (order.matches("change")) {
                User.change(username, password);
                return "Changed";
            }

            if (order.matches("delete")) {
                if (!User.deleteUser(username, password)) {
                    menu.invalidUser();
                    return "invalid user";
                }
                return "Deleted";
            }

            if (order.matches("rename")) {
                User.renameUsername(username);
                ;return "Renamed";
            }

            if (order.matches("show")) {
                menu.showCurrentUser();

            }

            if (order.matches("help")) {
                menu.profileHelp();
                ;
            }

            if (order.matches("exit")) {
                return null;
            }
            return null;
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

            if (str.matches("money")) {
                System.out.println(ViewController.shop.getCoin());
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
            System.out.println("Rail");
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

            if (str.matches("select \\d+")) {
                int s = Integer.parseInt(str.substring(str.indexOf("t") + 2));
                int status = rail.select(s);
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
                rail.endTurn();
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















  //  public static void mainMenu() {
//        while (true) {
//            System.out.println("mainmenu");
//            String str = menu.getOrder();
//
//            if (str.matches("play")) {
//                play();
//                continue;
//            }
//
//            if (str.matches("profile")) {
//                //profile();
//                continue;
//            }
//
//            if (str.matches("shop")) {
//                shop();
//                continue;
//            }
//
//            if (str.matches("help")) {
//                menu.mainmenuHelp();
//                continue;
//            }
//
//            if (str.matches("exit")) {
//                return;
//            }
//
//            menu.invalidCommand();
//        }
//    }


