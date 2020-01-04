package gamecenter.plants;

import controller.ViewController;
import gamecenter.Ground;

public class Sunflower extends Plants {

    public Sunflower(String name, Ground ground) {
        name = name.toLowerCase();
        type = "sunflower";
        if (name.matches("sunflower")) {
            setparameters("Sunflower", 1, 2, 2, ground);
        }
        if (name.matches("twin sunflower")) {
            setparameters("Twin Sunflower", 3, 5, 2, ground);
        }
    }

    @Override
    public void operation() {
        turn_shoot++;
        if (name.equals("sunflower")) {
            if (turn_shoot % 2 == 0) {
                ViewController.day.setSun(1);
            }
        }
        if (name.equals("twin sunflower")) {
            if (turn_shoot % 2 == 0) {
                ViewController.day.setSun(2);
            }
        }
    }

}
