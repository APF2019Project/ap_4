package gamecenter.zombies;

import gamecenter.Ground;

public class Normal extends Zombies {

    public Normal(String name, Ground ground) {
        if (name.matches("zombie")) {
            setparameters(2, 2, 1, ground);
        }
        if (name.matches("footballzombie")) {
            setparameters(3, 4, 1, ground);
        }
        if (name.matches("bucketheadzombie")) {
            setparameters(2, 3, 1, ground);
        }
        if (name.matches("coneheadzombie")) {
            setparameters(2, 3, 1, ground);
        }
    }


    public void ConeheadZombie(boolean status) {
    }

    public void BucketheadZombie(boolean status) {
    }

    public void FootballZombie(boolean status) {
    }
}
