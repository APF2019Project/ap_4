package gamecenter;

import controller.ViewController;
import gamecenter.Collection.*;

public class Shop {

    public int money;

    public String[] plants = {"peashooter", "snowpea", "cabbagepult", "repeater", "threepeater", "cactus", "gatlingpea",
            "scaredyshroom", "kernelpult", "splitpea", "explodeonut", "melonpult", "lilypad", "wintermelon", "wallnut",
            "tanglekelp", "tallnut", "cattail", "potatomine", "cherrybomb", "magnetshroom", "sunflower", "twinsunflower", "jalapeno"};
    public String[] zombies = {"zombie", "football", "buckethead", "conehead", "zomboni", "catapult", "bungee", "balloon",
            "newspaper", "target", "screendoor", "giga-gargantuar", "pogo", "snorkel", "dolphin rider"};

    public int buyCard(String name, int price) {
        if (money > price) {
            money -= price;
            for (int i = 0; i < plants.length; i++) {
                if (name.contains(plants[i])) {
                    ViewController.collection.plants_s.add(name);
                    return 1;
                }
            }
            for (int i = 0; i < zombies.length; i++) {
                if (name.contains(zombies[i])) {
                    ViewController.collection.zombies_s.add(name);
                    return 1;
                }
            }
            return -1;
        } else return 0;
    }
}
