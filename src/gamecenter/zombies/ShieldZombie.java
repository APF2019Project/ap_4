package gamecenter.zombies;

import gamecenter.Ground;

public class ShieldZombie extends Zombies {

    public ShieldZombie(String name , Ground ground) {
        name = name.toLowerCase();
        if (name.matches("newspaper zombie")){
            setparameters("Newspaper Zombie",2,2,1,ground);
            imagePath = "";
            shield = 2;
        }
        if (name.matches("target zombie")){
            setparameters("Target Zombie",2,3,1,ground);
            imagePath = "pics/TargetZombie.jpg";
            shield = 3;

        }
        if (name.matches("screendoor zombie")){
            setparameters("Screendoor Zombie",2,2,1,ground);
            imagePath = "pics/ScreenDoorZombie.jpg";
            shield = 4;
        }
        type="sh";
    }
}
