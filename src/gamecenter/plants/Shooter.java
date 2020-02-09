package gamecenter.plants;

import gamecenter.GameMode;
import gamecenter.Ground;

public class Shooter extends Plants {

    public Shooter(String name, Ground ground) {
        name = name.toLowerCase();
        type = "shooter";
        if (name.matches("cabbage-pult")) {
            setparameters("Cabbage-pult", 2, 3, 2, ground);
            imagePath = "pics/Cabbage-pult.jpg";
        }
        if (name.matches("winter melon")) {
            setparameters("Winter Melon", 4, 5, 3, ground);
            imagePath = "pics/WinterMelon.jpg";

        }
        if (name.matches("melon-pult")) {
            setparameters("Melon-pult", 3, 3, 3, ground);
            imagePath = "pics/Melon-pult.jpg";

        }
        if (name.matches("kernel-pult")) {
            setparameters("Kernel-pult", 3, 3, 2, ground);
            imagePath = "pics/Kernel-pult.jpg";

        }
    }

    @Override
    public void operation(GameMode gameMode) {
        String name = this.name2;
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
