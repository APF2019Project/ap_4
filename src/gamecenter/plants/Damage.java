package gamecenter.plants;

import gamecenter.GameMode;
import gamecenter.Ground;
import gamecenter.zombies.Zombies;

import java.util.ArrayList;

public class Damage extends Plants {

    public Damage(String name2, Ground ground) {
        name2 = name2.toLowerCase();
        type = "damage";
        if (name2.matches("tangle kelp")) {
            setparameters("Tangle Kelp", 3, 3, 0, ground);
            imagePath = "pics/TangleKelp.jpg";
        }

        if (name2.matches("potato mine")) {
            setparameters("Potato Mine", 2, 3, 1, ground);
            imagePath = "pics/PotatoMine.jpg";
        }
        if (name2.matches("cherry bomb")) {
            setparameters("Cherry Bomb", 2, 4, 0, ground);
            imagePath = "pics/CherryBomb.jpg";
        }
        if (name2.matches("cattail")) {
            setparameters("Cattail", 5, 5, 3, ground);
            imagePath = "pics/CherryBomb.jpg";
        }
        if (name2.matches("jalapeno")) {
            setparameters("Jalapeno", 4, 5, 0, ground);
            imagePath = "pics/Jalapeno.jpg";
        }
        if (name2.matches("explode-o-nut")) {
            setparameters("Explode-o-nut", 4, 5, 3, ground);
            imagePath = "pics/Explode-o-nut.jpg";
        }
    }

    @Override
    public void operation(GameMode gameMode) {
        String name = this.name2;
        turn_shoot++;
        if (!isThereAnyZombie(gameMode))
            return;
        if (name.equals("explode-o-nut")) {
            ArrayList<Zombies> zombies = gameMode.GameGround[groundX][groundY + 1].settledZombie;
            if (zombies.size() != 0) {
                zombies.get(0).setHealth(1);
            }
        }else if (name.equals("jalapeno")) {
            for (int j = 0; j < 19; j++) {
                ArrayList<Zombies> zombies = gameMode.GameGround[groundX][j].settledZombie;
                for (int i = 0; i < zombies.size(); i++) {
                    zombies.get(i).suddenDeath();
                }
            }
        }else if (name.equals("potato mine")) {
            if (turn_shoot > 1) {
                ArrayList<Zombies> zombies = gameMode.GameGround[groundX][groundY].settledZombie;
                if (zombies.size() != 0) {
                    zombies.get(0).suddenDeath();
                }
            }
        }else if (name.equals("cherry bomb")) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    ArrayList<Zombies> zombies = gameMode.GameGround[groundX + i][groundY + j].settledZombie;
                    for (int k = 0; k < zombies.size(); k++) {
                        zombies.get(k).suddenDeath();
                    }
                }
            }
        }else {

        }
    }

}
