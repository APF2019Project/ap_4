package gamecenter.zombies;

import gamecenter.Ground;

public class ShieldZombie extends Zombies {

    public ShieldZombie(String name , Ground ground) {
        if (name.matches("newspaper zombie")){
            setparameters("Newspaper Zombie",2,2,1,ground);
            shield = 2;
            setHealth(-2);
        }
        if (name.matches("target zombie")){
            setparameters("Target Zombie",2,3,1,ground);
            shield = 3;
            setHealth(-3);
        }
        if (name.matches("screendoor zombie")){
            setparameters("Screendoor Zombie",2,2,1,ground);
            shield = 4;
            setHealth(-4);
        }
        type="ShieldZombie";
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }


    public void NewspaperZombie(Ground ground) { }

    public void TargetZombie() { }

    public void ScreenDoorZombie() { }

}
