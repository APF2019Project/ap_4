package gamecenter;

import gamecenter.plants.*;
import gamecenter.zombies.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Collection {
    private Ground e = null;
    ArrayList<Plants> plants_s = new ArrayList<>(
            Arrays.asList(
                    new Damage("cherry Bomb", e),
                    new Damage("explode-o-nut", e),
                    new Pea("peashooter", e),
                    new Pea("scaredy-shroom", e),
                    new Pea("snow Pea", e),
                    new Shooter("kernel-pult", e),
                    new Sunflower("sunflower", e)
            )
    );
    ArrayList<gamecenter.zombies.Zombies> zombies_s = new ArrayList<>(
            Arrays.asList(
                    new BaloonZombie(e),
                    new CARZombie("zomboni", e),
                    new Normal("zombie", e),
                    new Normal("football zombie", e),
                    new Normal("buckethead zombie", e),
                    new ShieldZombie("screendoor zombie", e),
                    new GiantZombie(e),
                    new SpiderZombie(e)
            )
    );


    ArrayList<Plants> plants_hand = new ArrayList<>();
    ArrayList<Zombies> zombies_hand = new ArrayList<>();

    public ArrayList<String> showCollectionZombies() {
        int flag = 1;
        ArrayList<String> notChosen = new ArrayList<>();
        for (int i = 0; i < zombies_s.size(); i++) {
            flag = 1;
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
            flag = 1;
            for (int j = 0; j < plants_hand.size(); j++) {
                if (plants_s.get(i).getName().equals(plants_hand.get(j).getName())) {
                    flag = 0;
                    break;
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

    public int select(String name) {
        for (Plants plants : plants_hand) {
            if (plants.getName().equals(name)) {
                return 2;
            }
        }
        for (Zombies zombies : zombies_hand) {
            if (zombies.getName().equals(name)) {
                return 2;
            }
        }
        for (int i = 0; i < plants_s.size(); i++) {
            Plants plant = plants_s.get(i);
            if (name.equals(plant.getName())) {
                if (plants_hand.size() >= 7)
                    return 0;
                plants_hand.add(plant);
                return 1;
            }
        }
        for (Zombies zombie : zombies_s) {
            if (name.equals(zombie.getName())) {
                if (zombies_hand.size() >= 7)
                    return 0;
                zombies_hand.add(zombie);
                return 1;
            }
        }
        return -1;
    }

    public boolean remove(String name) {
        for (Plants plant : plants_hand) {
            if (name.equals(plant.getName())) {
                plants_hand.remove(plant);
                return true;
            }
        }
        for (Zombies zombie : zombies_hand) {
            if (name.equals(zombie.getName())) {
                zombies_hand.remove(zombie);
                return true;
            }
        }
        return false;
    }

}


