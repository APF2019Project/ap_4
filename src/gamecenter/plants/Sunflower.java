package gamecenter.plants;

import controller.Viewcontroller;
import gamecenter.GameMode;
import gamecenter.Ground;

public class Sunflower extends Plants {

    public Sunflower(String name, Ground ground) {
        name = name.toLowerCase();
        type = "sunflower";
        if (name.matches("sunflower")) {
            setparameters("Sunflower", 1, 2, 2, ground);
            imagePath = "pics/Sunflower.jpg";
        }
        if (name.matches("twin sunflower")) {
            setparameters("Twin Sunflower", 3, 5, 2, ground);
            imagePath = "pics/Sunflower.jpg";
        }
    }

    @Override
    public void operation(GameMode gameMode) {
        ;String name = this.name2;
        turn_shoot++;
        if (name.equals("sunflower")) {
            if (turn_shoot % 2 == 0) {
                Viewcontroller.day.setSun(1);
            }
        }
        if (name.equals("twin sunflower")) {
            if (turn_shoot % 2 == 0) {
                Viewcontroller.day.setSun(2);
            }
        }
    }

}
