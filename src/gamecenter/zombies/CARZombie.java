package gamecenter.zombies;

import gamecenter.Ground;

public class CARZombie extends Zombies {

    public CARZombie(String name, Ground ground) {
        name = name.toLowerCase();
        type = "CARZombie";
        if (name.matches("zomboni")) {
            setparameters("Zomboni", 2, 3, 1000, ground);
        }
        if (name.matches("catapult zombie")) {
            setparameters("Catapult Zombie", 2, 3, 1000, ground);
        }
    }

    public void CatapultZombie() {
        if (getName().equals("catapult zombie") && getHealth() <= 0) {
            setparameters("Zombie", 2, 2, 1, getGround());
        }
    }
}
