package gamecenter.zombies;

import gamecenter.Ground;

public class WaterZombie extends Zombies {

    public WaterZombie(String name, Ground ground) {
        if (name.matches("Snorkel Zombie")) {
            setparameters("Snorkel Zombie",2,2,1,ground);
            shield = 0;
        }else {
            setparameters("Dolphin Rider Zombie",2,2,1,ground);
            shield = 2;
        }

    }

    public void DolphinRiderZombie(boolean status) {

    }

    public void SnorkelZombie(boolean status) {

    }
}
