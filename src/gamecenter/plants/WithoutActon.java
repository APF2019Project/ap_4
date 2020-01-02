package gamecenter.plants;

import controller.ViewController;
import gamecenter.Ground;
import gamecenter.zombies.Zombies;

import java.util.ArrayList;

public class WithoutActon extends Plants {

    public WithoutActon(String name, Ground ground) {
        type = "withoutaction";
        if (name.matches("wall-nut")) {
            setparameters("Wall-nut", 2, 4, 4, ground);
        }
        if (name.matches("tall-nut")) {
            setparameters("Tall-nut", 4, 6, 6, ground);
        }
        if (name.matches("magnet-shroom")) {
            setparameters("Magnet-shroom", 4, 4, 2, ground);
        }
    }

    @Override
    public void operation() {
        turn_shoot++;
        if (name.equals("magnet-shroom")) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    ArrayList<Zombies> zombies = ViewController.day.GameGround[groundX + i][groundY + j].settledZombie;
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
