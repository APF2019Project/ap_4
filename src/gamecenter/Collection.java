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
                    new BaloonZombie(null),
                    new CARZombie("Zomboni", e),
                    new Normal("Zombie", e),
                    new Normal("Football Zombie", e),
                    new Normal("Buckethead Zombie", e),
                    new ShieldZombie("Screendoor Zombie", e),
                    new SpiderZombie(e)
            )
    );
///Inja ro Mitonim yedoone hand bezarim
    ArrayList<Plants> plants_hand = new ArrayList<>();
    ArrayList<Zombies> zombies_hand = new ArrayList<>();
    ArrayList<String> Showhandplants(){
        ArrayList<String> all =new ArrayList<String>();
        for(int i=0;i<plants_hand.size();i++){
            all.add(plants_hand.get(i).getName());
        }
        return all;
    }
    ArrayList<String> Showhandzombie(){
        ArrayList<String> all =new ArrayList<String>();
        for(int i=0;i<zombies_hand.size();i++){
            all.add(zombies_hand.get(i).getName());
        }
        return all;
    }

    public void Select(String name) {
        for (Plants plant : plants_s) {
            if (name.contains(plant.getName())) {
                    plants_hand.add(plant);
                    return;
            }
        }
        for (Zombies zombie : zombies_s) {
            if (name.contains(zombie.getName())) {
                zombies_hand.add(zombie);
                return;
            }
        }
    }
    public void Remove(String name) {
        for (Plants plant : plants_hand) {
            if (name.contains(plant.getName())) {
                plants_hand.remove(plant);
                return;
            }
        }
        for (Zombies zombie : zombies_hand) {
            if (name.contains(zombie.getName())) {
                zombies_hand.remove(zombie);
                return;
            }
        }
    }

}


