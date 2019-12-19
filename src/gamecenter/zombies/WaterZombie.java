package gamecenter.zombies;

import gamecenter.Ground;

public class WaterZombie extends Zombies {
    int shield;

    public WaterZombie(String name, Ground ground) {
        if (name.matches("snorkelzombie")) {
            shield = 0;
        }else {
            shield = 2;
        }
        setparameters(2,2,1,ground);
    }

    public void DolphinRiderZombie(boolean status) {

    }

    public void SnorkelZombie(boolean status) {

    }
}
