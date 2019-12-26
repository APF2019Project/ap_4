package gamecenter;

import controller.ViewController;
import gamecenter.plants.*;
import gamecenter.zombies.Zombies;

import java.util.ArrayList;
import java.util.Random;

public class Day extends GameMode {
    private int sun = 2;
    static int turn = 1;
    Plants current;
    Random generator = new Random();
    ArrayList<gamecenter.zombies.Zombies> Zombies = new ArrayList<>();
    ArrayList<Plants> plants_hand = new ArrayList<>();
    ArrayList<Integer> sunneeded = new ArrayList<>();
    ArrayList<Integer> cooldown_left = new ArrayList<>();

    public Day() {
        plants_hand = ViewController.collection.plants_hand;
        for (int i = 0; i < 19; i++) {
            for (int k = 0; k < 6; k++) {
                GameGround[i][k].groundX = i;
                GameGround[i][k].groundY = k;
                GameGround[i][k].type = true;
            }
        }
    }

    public ArrayList<String> showHand() {
        ArrayList<String> all = new ArrayList<String>();
        for (int i = 0; i < plants_hand.size(); i++) {
            all.add(plants_hand.get(i).getName());
            sunneeded.add(plants_hand.get(i).getSun_used());
            cooldown_left.add(plants_hand.get(i).getTurn_cooldown());
        }
        return all;
    }

    public ArrayList<Integer> showHandSun() {


        return sunneeded;
    }

    public ArrayList<Integer> showHandCool() {


        return cooldown_left;
    }

    public int select(String name) {
        for (Plants plant : plants_hand) {
            if (name.contains(plant.getName())) {
                if (plant.getSun_used() <= sun) {
                    if (!plant.isTired()) {
                        sun -= plant.getSun_used();
                        current = cardFinder(plant, name);
                        PlantsinGame.add(current);
                        return 2;
                    } else return 1;
                } else return 0;
            }
        }
        return -1;
    }

    public boolean plantingPlant(int i, int j) {
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

    public Plants cardFinder(Plants plant, String name) {

        if (plant.type.equals("damage")) {
            return new Damage(name, null);
        }

        if (plant.type.equals("pea")) {
            return new Pea(name, null);
        }

        if (plant.type.equals("shooter")) {
            return new Shooter(name, null);
        }

        if (plant.type.equals("sunflower")) {
            return new Sunflower(name, null);
        }

        if (plant.type.equals("waterplants")) {
            return new WaterPlants(name, null);
        }

        if (plant.type.equals("withoutaction")) {
            return new WithoutActon(name, null);
        }

        return null;
    }

    public void setSun(int sun) {

        this.sun += sun;
    }

}
