package gamecenter;


import gamecenter.plants.*;
import gamecenter.zombies.*;
import gamecenter.zombies.Zombies;

import java.util.ArrayList;
import java.util.Arrays;

public class Shop {
    int coin = 10000;
    Ground e = null;
    Collection collection;
    public Shop(Collection collection) {
        this.collection = collection;
    }
    ArrayList<Plants> plants = new ArrayList<>(
            Arrays.asList(
                    new Damage("Tangle Kelp", e),
                    new Damage("Potato Mine", e),
                    new Damage("Cherry Bomb", e),
                    new Damage("Cattail", e),
                    new Damage("Jalapeno", e),
                    new Damage("Explode-o-nut", e),
                    new Pea("Peashooter", e),
                    new Pea("Repeater", e),
                    new Pea("Threepeater", e),
                    new Pea("Cactus", e),
                    new Pea("Split Pea", e),
                    new Pea("Gatling Pea", e),
                    new Pea("Scaredy-shroom", e),
                    new Pea("Snow Pea", e),
                    new Shooter("Cabbage-pult", e),
                    new Shooter("Winter Melon", e),
                    new Shooter("Melon-pult", e),
                    new Shooter("Kernel-pult", e),
                    new Sunflower("Sunflower", e),
                    new Sunflower("Twin Sunflower", e),
                    new WaterPlants("Lily Pad", e),
                    new WithoutActon("Wall-nut", e),
                    new WithoutActon("Tall-nut", e),
                    new WithoutActon("Magnet-shroom", e)
            ));

    ArrayList<Zombies> zombies = new ArrayList<Zombies>(
            Arrays.asList(
                    new BaloonZombie(e),
                    new CARZombie("Zomboni", e),
                    new CARZombie("Catapult Zombie", e),
                    new GiantZombie(e),
                    new JumperZombie(e),
                    new Normal("Zombie", e),
                    new Normal("Football Zombie", e),
                    new Normal("Buckethead Zombie", e),
                    new Normal("Conehead Zombie", e),
                    new ShieldZombie("Newspaper Zombie", e),
                    new ShieldZombie("Target Zombie", e),
                    new ShieldZombie("Screendoor Zombie", e),
                    new SpiderZombie(e),
                    new WaterZombie("Snorkel Zombie", e),
                    new WaterZombie("Dolphin Rider Zombie", e)
            ));
    public ArrayList<Integer> allprice = new ArrayList<>();
    //buy sth bought
    public int buyCard(String name) {
        for (Plants plants : this.collection.plants_s) {
            if (plants.getName().equals(name)) {
                return 2;
            }
        }
        for (Zombies zombies : this.collection.zombies_s) {
            if (zombies.getName().equals(name)) {
                return 2;
            }
        }
        for (Plants plant : plants) {
            if (name.equals(plant.getName())) {
                if (plant.getPrice() <= coin) {
                    this.collection.plants_s.add(plant);
                    coin -= plant.getPrice();
                    return 1;
                } else return 0;
            }
        }
        for (Zombies zombie : zombies) {
            if (name.equals(zombie.getName())) {
                if (zombie.getPrice() <= coin) {
                    this.collection.zombies_s.add(zombie);
                    coin -= zombie.getPrice();
                    return 1;
                } else return 0;
            }
        }
        return -1;
    }

    public Plants makeCard_p(String type, String name, int health, int sun, int cooldown) {
        Plants plants =  new Plants(type, name, sun, cooldown, health);
        this.plants.add(plants);
        return plants;
    }

    public Zombies makeCard_z(String type, String name, int health, int speed, int damage) {
        Zombies zombies = new Zombies(type, name, speed, health, damage);
        this.zombies.add(zombies);
        return zombies;
    }

    public ArrayList<String> ShowShop() {
        ArrayList<String> all = new ArrayList<String>();
        int flag;
        for (Zombies zombie : zombies) {
            flag = 1;
            if (flag == 1) {
                all.add(zombie.getName());
                allprice.add(zombie.getPrice());
            }
        }
        for (Plants plants : plants) {
            flag = 1;

            if (flag == 1) {
                all.add(plants.getName());
                allprice.add(plants.getPrice());
            }
        }
        return all;
    }

    public ArrayList<Integer> ShowShopprices() {

        return allprice;
    }

    public ArrayList<String> ShowCollectionZombies() {
        ArrayList<String> all = new ArrayList<String>();
        for (int i = 0; i < this.collection.zombies_s.size(); i++) {
            all.add(this.collection.zombies_s.get(i).getName());
        }
        return all;
    }

    public ArrayList<String> ShowCollectionPlants() {
        ArrayList<String> all = new ArrayList<String>();
        for (int i = 0; i < this.collection.plants_s.size(); i++) {
            all.add(this.collection.plants_s.get(i).getName());
        }
        return all;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin += coin;
    }

    public ArrayList<String> names() {
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < plants.size(); i++) {
            names.add(plants.get(i).getName());
        }
        for (int i = 0; i < zombies.size(); i++) {
            names.add(zombies.get(i).getName());
        }
        return names;
    }

    public ArrayList<String> name_c() {
        ArrayList<String> all = new ArrayList<String>();
        for (int i = 0; i < this.collection.zombies_s.size(); i++) {
            all.add(this.collection.zombies_s.get(i).getName());
        }

        for (int i = 0; i < this.collection.plants_s.size(); i++) {
            all.add(this.collection.plants_s.get(i).getName());
        }
        return all;
    }
}


