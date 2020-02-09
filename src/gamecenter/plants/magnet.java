package gamecenter.plants;

import gamecenter.GameMode;
import gamecenter.Ground;
import gamecenter.zombies.Zombies;

import java.util.ArrayList;

public class magnet extends Plants {

    public magnet(String name, Ground ground) {
        name = name.toLowerCase();
        type = "magnet";
        if (name.matches("magnet-shroom")) {
            setparameters("Magnet-shroom", 4, 4, 2, ground);
            imagePath = "pics/Magnet-shroom.jpg";
        }
    }

    @Override
    public void operation(GameMode gameMode) {
        String name = this.name2;
        turn_shoot++;
        if (!isThereAnyZombie(gameMode))
            return;
        if (name.equals("magnet-shroom")) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    ArrayList<Zombies> zombies = gameMode.GameGround[groundX + i][groundY + j].settledZombie;
                    for (int k = 0; k < zombies.size(); k++) {
                        if (zombies.get(k).getName().equals("screendoor Zombie")) {
                            zombies.get(k).shield = 0;
                        }
                        if (zombies.get(k).getName().equals("buckethead Zombie")) {
                            if (zombies.get(k).getHealth() >= 2) {
                                zombies.get(k).setHealth(1);
                            }
                        }
                    }
                }
            }
        }
    }
}
