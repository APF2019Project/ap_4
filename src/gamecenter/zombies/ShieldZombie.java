package gamecenter.zombies;

import gamecenter.Ground;

public class ShieldZombie extends Zombies {

    public ShieldZombie(String name , Ground ground) {
        if (name.matches("Newspaper Zombie")){
            setparameters("Newspaper Zombie",2,2,1,ground);
            shield = 2;
        }
        if (name.matches("Target Zombie")){
            setparameters("Target Zombie",2,3,1,ground);
            shield = 3;
        }
        if (name.matches("Screendoor Zombie")){
            setparameters("Screendoor Zombie",2,2,1,ground);
            shield = 4;
        }
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public void NewspaperZombie(boolean status) {

    }

    public void TargetZombie(boolean status) {

    }

    public void ScreenDoorZombie(boolean status) {

    }

}
