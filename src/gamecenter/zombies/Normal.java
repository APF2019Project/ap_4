package gamecenter.zombies;

import gamecenter.Ground;

public class Normal extends Zombies {

    public Normal(String name, Ground ground) {
        type = "Normal";
        if (name.matches("Zombie")) {
            setparameters("Zombie",2, 2, 1, ground);
        }
        if (name.matches("football zombie")) {
            setparameters("Football Zombie",3, 4, 1, ground);
        }
        if (name.matches("buckethead Zombie")) {
            setparameters("Buckethead Zombie",2, 3, 1, ground);
        }
        if (name.matches("Conehead Zombie")) {
            setparameters("Conehead Zombie",2, 3, 1, ground);
        }
    }


    public void ConeheadZombie(boolean status) {
    }

    public void BucketheadZombie(boolean status) {
    }

    public void FootballZombie(boolean status) {
    }
}
