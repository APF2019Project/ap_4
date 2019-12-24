package gamecenter;
import controller.ViewController;
import gamecenter.Collection.*;

public class Shop {

    public int money;

    public String[] plants = {"Peashooter", "Snow Pea", "Cabbage-pult", "Repeater", "Threepeater", "Cactus", "Gatling Pea",
            "Scaredy-shroom", "Kernel-pult", "Split Pea", "Explode-o-nut", "Melon-pult", "Lily Pad", "Winter Melon", "Wall-nut",
            "Tangle Kelp", "Tall-nut", "Cattail", "Potato Mine", "Cherry Bomb", "Magnet-shroom", "Sunflower", "Twin Sunflower", "Jalapeno"};
    public String[] zombies = {"Zombie", "Football Zombie", "Buckethead Zombie", "Conehead Zombie", "Zomboni", "Catapult Zombie", "Bungee Zombie", "Balloon Zombie",
            "Newspaper Zombie", "Target Zombie", "Screen Door Zombie", "Giga-gargantuar", "Pogo Zombie", "Snorkel Zombie", "Dolphin Rider Zombie"};

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
