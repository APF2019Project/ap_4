package gamecenter;

import controller.ViewController;
import gamecenter.plants.Plants;
import gamecenter.zombies.*;
import gamecenter.zombies.Zombies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ZombieGameMode extends GameMode {
    static int turn = 1;
    Random generator = new Random();
    private int coin = 50;
    Zombies current;
    ArrayList<Zombies> zombies_hand;
    ArrayList<Integer> zombies_health = new ArrayList<>();
    ArrayList<Plants> plants = new ArrayList<>();
    Zombies [][] zombies = new Zombies[6][2];
    HashMap<String, String> showLanes = new HashMap<>();


    public ZombieGameMode() {
        zombies_hand = ViewController.collection.zombies_hand;
        for (int i = 0; i < 6; i++) {
            for (int k = 0; k < 19; k++) {
                GameGround[i][k].groundX = i;
                GameGround[i][k].groundY = k;
                GameGround[i][k].type = true;
            }
        }
    }

    public int put(String name, int number, int line) {
        if (line > 5)
            return -2;
        if (zombies[line].length + number > 2)
            return 1;
        for (Zombies zombie : zombies_hand) {
            if (name.equals(zombie.getName())) {
                if (coin >= 10 * zombie.getHealth()) {
                    coin -= zombie.getHealth() * 10;
                    current = cardFinder(zombie, name);
                    if (zombies[line][0] == null) {
                        zombies[line][0] = current;
                    }else {
                        zombies[line][1] = current;
                    }
                    ZombiesinGame.add(current);
                    return 2;
                } else return 0;
            }
        }
        return -1;
    }

    public HashMap<String, String> showLanes() {
        for (int i = 0; i < 6; i++) {
            for (Zombies zombie : zombies[i]) {
                showLanes.put(Integer.toString(i), zombie.getName());
            }
        }
        return showLanes;
    }

    public ArrayList<String> showHand() {
        ArrayList<String> all = new ArrayList<String>();
        for (int i = 0; i < zombies_hand.size(); i++) {
            all.add(zombies_hand.get(i).getName());
            zombies_health.add(zombies_hand.get(i).getHealth());
        }
        return all;
    }

    public ArrayList<Integer> showHandHealth() {

        return zombies_health;
    }

    private Zombies cardFinder(Zombies zombie, String name) {

        if (zombie.type.equals("BaloonZombie")) {
            return new BaloonZombie(null);
        }

        if (zombie.type.equals("CARZombie")) {
            return new CARZombie(name, null);
        }

        if (zombie.type.equals("GiantZombie")) {
            return new GiantZombie(null);
        }

        if (zombie.type.equals("JumperZombie")) {
            return new JumperZombie(null);
        }

        if (zombie.type.equals("Normal")) {
            return new Normal(name, null);
        }

        if (zombie.type.equals("ShieldZombie")) {
            return new ShieldZombie(name, null);
        }

        if (zombie.type.equals("SpiderZombie")) {
            return new SpiderZombie(null);
        }

        if (zombie.type.equals("WaterZombie")) {
            return new WaterZombie(name, null);
        }
        return null;
    }


}
