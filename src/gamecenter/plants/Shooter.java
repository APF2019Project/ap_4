package gamecenter.plants;

import controller.ViewController;
import gamecenter.GameMode;
import gamecenter.Ground;

public class Shooter extends Plants {

    public Shooter(String name, Ground ground) {
        name = name.toLowerCase();
        type = "shooter";
        if (name.matches("cabbage-pult")) {
            setparameters("Cabbage-pult", 2, 3, 2, ground);
        }
        if (name.matches("winter melon")) {
            setparameters("Winter Melon", 4, 5, 3, ground);
        }
        if (name.matches("melon-pult")) {
            setparameters("Melon-pult", 3, 3, 3, ground);
        }
        if (name.matches("kernel-pult")) {
            setparameters("Kernel-pult", 3, 3, 2, ground);
        }
    }

    @Override
    public void operation(GameMode gameMode) {

        turn_shoot++;
        if (!isThereAnyZombie(gameMode))
            return;
        if (name.equals("cabbage-pult")) {
            if (turn_shoot % 2 == 0) {
                gameMode.shotadder(1, ground, 2, null);
            }
        }
        if (name.equals("melon-pult")) {
            if (turn_shoot % 4 == 0) {
                gameMode.shotadder(1, ground, 3, null);
            }
        }
        if (name.equals("winter melon")) {
            if (turn_shoot % 4 == 0) {
                gameMode.shotadder(1, ground, 3, "icy");
            }
        }
        if (name.equals("kernel-pult")) {
            if (turn_shoot % 4 == 0) {
                gameMode.shotadder(1, ground, 0, "sticky");
            }
        }
    }
}
