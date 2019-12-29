package gamecenter.plants;

import controller.ViewController;
import gamecenter.Ground;

public class Pea extends Plants {
    private int turn_shoot = 0;

    public Pea(String name, Ground ground) {
        type = "pea";
        if (name.matches("peashooter")) {
            setparameters("Peashooter", 2, 2, 2, ground);
        }
        if (name.matches("repeater")) {
            setparameters("Repeater", 3, 4, 4, ground);
        }
        if (name.matches("threepeater")) {
            setparameters("Threepeater", 4, 4, 5, ground);
        }
        if (name.matches("cactus")) {
            setparameters("Cactus", 5, 4, 5, ground);
        }
        if (name.matches("split pea")) {
            setparameters("Split Pea", 4, 4, 3, ground);
        }
        if (name.matches("gatling pea")) {
            setparameters("Gatling Pea", 5, 4, 3, ground);
        }
        if (name.matches("scaredy-shroom")) {
            setparameters("Scaredy-shroom", 1, 2, 1, ground);
        }
        if (name.matches("snow pea")) {
            setparameters("Snow Pea", 3, 3, 3, ground);
        }
    }

    @Override
    public void operation() {
        if (name.equals("peashooter")) {
            if (turn_shoot % 2 == 0) {
                ViewController.day.peaadder(1);
            }
        }
        if (name.equals("snow pea")) {
            if (turn_shoot % 3 == 0) {
                ViewController.day.peaadder(1);
            }
        }
        if (name.equals("repeater")) {
            if (turn_shoot % 3 == 0) {
                ViewController.day.peaadder(2);
            }
        }
        if (name.equals("gatling pea")) {
            if (turn_shoot % 5 == 0) {
                ViewController.day.peaadder(4);
            }
        }
    }
}
