package gamecenter.zombies;

import gamecenter.Ground;

public class GiantZombie extends Zombies {
    public GiantZombie(Ground ground) {
        setparameters("giga-gargantuar",1,1006,1000,ground);
        imagePath = "pics/Giga-gargantuar.jpg";
        type="g";
    }

}
