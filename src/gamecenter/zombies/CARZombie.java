package gamecenter.zombies;

import gamecenter.Ground;

public class CARZombie extends Zombies {

    public CARZombie(String name, Ground ground) {
        if (name.matches("Zomboni")) {
            setparameters("Zomboni", 2, 3, 1, ground);
        }
        if (name.matches("Catapult Zombie")) {
            setparameters("Catapult Zombie", 2, 3, 1, ground);
        }
    }

    public void Zomboni(boolean status) {
    }

    public void CatapultZombie(boolean status) {
    }
}
