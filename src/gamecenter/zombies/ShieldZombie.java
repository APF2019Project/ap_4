package gamecenter.zombies;

import gamecenter.Ground;

public class ShieldZombie extends Zombies {
    int shield;
    public ShieldZombie(String name , Ground ground) {
        if (name.matches("newspaperzombie")){
            setparameters(2,2,1,ground);
            shield = 2;
        }
        if (name.matches("targetzombie")){
            setparameters(2,3,1,ground);
            shield = 3;
        }
        if (name.matches("screendoorzombie")){
            setparameters(2,2,1,ground);
            shield = 4;
        }
    }

    public void NewspaperZombie(boolean status) {

    }

    public void TargetZombie(boolean status) {

    }

    public void ScreenDoorZombie(boolean status) {

    }

}
