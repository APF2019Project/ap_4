package view;

import clientAndServer.Server;
import controller.Viewcontroller;
import gamecenter.Day;
import gamecenter.GameMode;
import gamecenter.ZombieGameMode;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.collectionController.CollectionController;
import view.collectionController.Collection_z;
import view.shopController.ShopController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends Application {
    Scanner input = new Scanner(System.in);
    static mainmenu mainmenu = new mainmenu();
    static LoginController loginController = new LoginController();
    static ShopController shopController = new ShopController();
    static CollectionController collectionController = new CollectionController();
    static Collection_z collection_z = new Collection_z();
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("isServer.txt");
        byte[] bytes = new byte[100];
        inputStream.read(bytes);
        inputStream.close();
        if (bytes[0] == 49) {
            new FileOutputStream("isServer.txt").write(48);
            new Server().start();
        } else {
            launch(args);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public void start() {
    }











































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
        String[] name = Viewcontroller.users.Leaderboard();
        int[] number = Viewcontroller.users.Leaderboardnumbers();
        for (int i = 0; i < Viewcontroller.users.users.size(); i++) {
            System.out.print("name " + name[i] + " killed");
            System.out.println(number[i]);
        }
    }

    public void showShop() {
        ArrayList<String> name = Viewcontroller.shop.ShowShop();
        ArrayList<Integer> number = Viewcontroller.shop.ShowShopprices();
        for (int i = 0; i < name.size(); i++) {
            System.out.println(name.get(i) + " Price: " + number.get(i));
        }
    }

    public void showCollection_shop() {
        ArrayList<String> name = Viewcontroller.shop.ShowCollectionPlants();
        ArrayList<String> name1 = Viewcontroller.shop.ShowCollectionZombies();
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

        System.out.println(Viewcontroller.shop.getCoin());
    }

    public void showHandZombie() {
        ArrayList<String> name = Viewcontroller.collection.showHandZombie();
        for (int i = 0; i < name.size(); i++) {
            System.out.print(name.get(i) + "//");
        }
        System.out.println();
    }

    public void showHandPlants() {
        ArrayList<String> name = Viewcontroller.collection.showHandPlants();
        for (int i = 0; i < name.size(); i++) {
            System.out.print(name.get(i) + "//");
        }
        System.out.println();
    }

    public void showCollectionPlants() {
        ArrayList<String> name = Viewcontroller.collection.showCollectionPlants();
        for (int i = 0; i < name.size(); i++) {
            System.out.print(name.get(i) + "//");
        }
        System.out.println();
    }

    public void showCollectionZombies() {
        ArrayList<String> name = Viewcontroller.collection.showCollectionZombies();
        for (int i = 0; i < name.size(); i++) {
            System.out.print(name.get(i) + "//");
        }
        System.out.println();
    }

    public void showHandDay(Day day) {
        ArrayList<String> name = day.showHand();
        for (int i = 0; i < name.size(); i++) {
            System.out.print(name.get(i) + " sun " + day.showHandSun().get(i) + " Cd " + day.showHandCool().get(i) + "   ");
        }
        System.out.println();
    }

    public void showHandZombies(ZombieGameMode zombieGameMode) {
        ArrayList<String> name = zombieGameMode.showHand();
        for (int i = 0; i < name.size(); i++) {
            System.out.print(name.get(i) + " health " + zombieGameMode.showHandHealth().get(i) + "   ");
        }
        System.out.println();
    }

    public void showLawn(GameMode gameMode) {
        ArrayList<String> name = gameMode.showLawn();
        for (int i = 0; i < name.size(); i++) {
            System.out.print(name.get(i) + " X " + gameMode.showLawnX().get(i) + " Y " + gameMode.showLawnY().get(i) + " Health " + gameMode.showLawnHealth().get(i) + "    ");
            if (i == gameMode.numberOfPlants() - 1) {
                System.out.println();
            } else if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public void showLanes(ZombieGameMode zombieGameMode) {
        ArrayList<Integer> showlanesNumbers = zombieGameMode.showlanesNumbers();
        ArrayList<String> showlanes = zombieGameMode.showLanes();
        for (int i = 0; i < 12; i++) {
            System.out.println(showlanesNumbers.get(i/2) + "  " + showlanes.get(i) + "  ");
        }
    }

    public void showCurrentUser() {

        System.out.println(Viewcontroller.users.currentuser);
    }

    public String getUserName() {
        String str = null;
        return str;
    }

    public String getPassword() {
        String str = null;
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

    public void outOfLadder() {

        System.out.println("out of ladders");
    }

    public void zombieswin() {

        System.out.println("zombies win");
    }

    public void plantswin() {

        System.out.println("plants win");
    }

    public void enterNextWave() {

        System.out.println("enter next wave");
    }

    public void recordRail() {

        System.out.println(Viewcontroller.rail.record());
    }

    public void listRail() {
        ArrayList<String> name = Viewcontroller.rail.list();
        for (int i = 0; i < name.size(); i++) {
            System.out.print(name.get(i) + "//");
        }
        System.out.println();
    }
}