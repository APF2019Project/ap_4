package gamecenter.zombies;

import gamecenter.Ground;

public class BaloonZombie extends Zombies {
    public BaloonZombie(Ground ground) {
        setparameters("balloon zombie", 2, 3, 1, ground);
        type="b";
    }

}
