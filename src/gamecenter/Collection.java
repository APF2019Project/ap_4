package gamecenter;

import gamecenter.plants.*;
import gamecenter.zombies.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Collection {
    private Ground e = null;
    ArrayList<Plants> plants_s = new ArrayList<>(
            Arrays.asList(
                    new Damage("Cherry Bomb", e),
                    new Damage("Explode-o-nut", e),
                    new Pea("Peashooter", e),
                    new Pea("Scaredy-shroom", e),
                    new Pea("Snow Pea", e),
                    new Shooter("Kernel-pult", e),
                    new Sunflower("Sunflower", e)
            )
    );
    ArrayList<gamecenter.zombies.Zombies> zombies_s = new ArrayList<>(
            Arrays.asList(
                    new BaloonZombie(e),
                    new CARZombie("Zomboni", e),
                    new Normal("Zombie", e),
                    new Normal("Football Zombie", e),
                    new Normal("Buckethead Zombie", e),
                    new ShieldZombie("Screendoor Zombie", e),
                    new SpiderZombie(e)
            )
    );


    ArrayList<Plants> plants_hand = new ArrayList<>();
    ArrayList<Zombies> zombies_hand = new ArrayList<>();

    public ArrayList<String> showCollectionZombies() {
        int flag = 1;
        ArrayList<String> notChosen = new ArrayList<>();
        for (int i = 0; i < zombies_s.size(); i++) {
            for (int j = 0; j < zombies_hand.size(); j++) {
                if (zombies_s.get(i).equals(zombies_hand.get(j))) {
                    flag = 0;
                }
            }
            if (flag == 1)
                notChosen.add(zombies_s.get(i).getName());
        }
        return notChosen;
    }

    public ArrayList<String> showCollectionPlants() {
        int flag = 1;
        ArrayList<String> notChosen = new ArrayList<>();
        for (int i = 0; i < plants_s.size(); i++) {
            for (int j = 0; j < plants_hand.size(); j++) {
                if (plants_s.get(i).equals(plants_hand.get(j))) {
                    flag = 0;
                }
            }
            if (flag == 1)
                notChosen.add(plants_s.get(i).getName());
        }
        return notChosen;
    }

    public ArrayList<String> showHandPlants() {
        ArrayList<String> all = new ArrayList<String>();
        for (Plants plants : plants_hand) {
            all.add(plants.getName());
        }
        return all;
    }

    public ArrayList<String> showHandZombie() {
        ArrayList<String> all = new ArrayList<String>();
        for (Zombies zombies : zombies_hand) {
            all.add(zombies.getName());
        }
        return all;
    }

    public boolean select(String name) {
        for (Plants plant : plants_s) {
            if (name.contains(plant.getName())) {
                plants_hand.add(plant);
                return true;
            }
        }
        for (Zombies zombie : zombies_s) {
            if (name.contains(zombie.getName())) {
                zombies_hand.add(zombie);
                return true;
            }
        }
        return false;
    }

    public boolean remove(String name) {
        for (Plants plant : plants_hand) {
            if (name.contains(plant.getName())) {
                plants_hand.remove(plant);
                return true;
            }
        }
        for (Zombies zombie : zombies_hand) {
            if (name.contains(zombie.getName())) {
                zombies_hand.remove(zombie);
                return true;
            }
        }
        return false;
    }

}


