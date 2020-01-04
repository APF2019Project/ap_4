package gamecenter.zombies;

import gamecenter.Ground;

public class GiantZombie extends Zombies {
    public GiantZombie(Ground ground) {
        setparameters("giga-gargantuar",1,6,1000,ground);
        type="GiantZombie";
    }

}
