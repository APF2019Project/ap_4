package gamecenter;

import controller.ViewController;
import gamecenter.plants.Plants;
import gamecenter.zombies.Zombies;

import java.util.ArrayList;
import java.util.Random;

public class Day extends GameMode {
    static int sun = 2;
    static int turn = 1;
    Plants current;
    Random generator = new Random();
    ArrayList<gamecenter.zombies.Zombies> Zombies = new ArrayList<>();


    void Day(/* Plants  */) {  // plants Arraylist
        if (turn == 3) {
            int i = generator.nextInt(7) + 4;
         //   for (int k = 0; k < i; k++) Zombies.add(new zombie);
        }


        turn++;
    }

    ArrayList<Integer> sunneeded = new ArrayList<>();
    ArrayList<Integer> cooldown = new ArrayList<>();

    ArrayList<String> Showhand() {
        ArrayList<String> all = new ArrayList<String>();
        for (int i = 0; i < ViewController.collection.plants_hand.size(); i++) {
            all.add(ViewController.collection.plants_hand.get(i).getName());
            sunneeded.add(ViewController.collection.plants_hand.get(i).getSun_used());
            cooldown.add(ViewController.collection.plants_hand.get(i).getCooldown());
        }
        return all;
    }

    ArrayList<Integer> Showhandsun() {
        return sunneeded;
    }

    ArrayList<Integer> Showhandcool() {
        return cooldown;
    }

    public boolean Select(String name) {
        for (Plants plant : ViewController.collection.plants_hand) {
            if (name.contains(plant.getName())) {
                if (plant.getSun_used() <= sun) { /////////Hereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
                    ///Plant az che noei ast Damage ya ...
                    current = new Plants();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean choosePlace(int i, int j) {
        if (GameGround[i][j].settledPlant != null || GameGround[i][j].settledZombie != null) {

            GameGround[i][j].settledPlant = current;
            current.setGround(GameGround[i][j]);

            current = null;
            return true;
        } else return false;
    }

    public boolean removePlant(int i, int j) {
        if (GameGround[i][j].settledPlant != null) {
            GameGround[i][j].settledPlant.setGround(null);
            GameGround[i][j].settledPlant = null;
            return true;
        } else return false;
    }

}
