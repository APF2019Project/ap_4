package gamecenter.plants;

import controller.ViewController;
import gamecenter.Ground;
import gamecenter.ZombieGameMode;
import gamecenter.zombies.Zombies;

import java.util.ArrayList;

public class Pea extends Plants {

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
        turn_shoot++;
        if (!isThereAnyZombie())
            return;

        if (name.equals("peashooter")) {
            if (turn_shoot % 2 == 0) {
                ViewController.day.shotadder(1, ground);
            }
        }

        if (name.equals("snow pea")) {
            if (turn_shoot % 3 == 0) {
                ViewController.day.shotadder(1, ground, true);
            }
        }

        if (name.equals("repeater")) {
            if (turn_shoot % 3 == 0) {
                ViewController.day.shotadder(2, ground);
            }
        }

        if (name.equals("gatling pea")) {
            if (turn_shoot % 5 == 0) {
                ViewController.day.shotadder(4, ground);
            }
        }

        if (name.equals("threepeater")) {
            if (turn_shoot % 4 == 0) {
                ViewController.day.shotadder(1, ground);
                ViewController.day.shotadder(1, ViewController.day.GameGround[groundX + 1][groundY]);
                ViewController.day.shotadder(1, ViewController.day.GameGround[groundX - 1][groundY]);
            }
        }

        if (name.equals("cactus")) {
            if (turn_shoot % 2 == 0) {
                ViewController.day.shotadder(1, ground);
            }
            ArrayList<Zombies> zombies = ViewController.day.GameGround[groundX][groundY + 1].settledZombie;
            for (int i = 0; i < zombies.size(); i++) {
                if (!zombies.get(i).getType().equals("Normal")) {
                    zombies.get(i).setHealth(1);
                    break;
                }
            }
        }

        if (name.equals("scaredy-shroom")) {
            boolean a = false;
            for (int j = groundY; j < groundY + 3; ++j){
                if (ViewController.day.GameGround[groundX][j].settledZombie.size() != 0) {
                    a = true;
                    break;
                }
            }
            if (!a) {
                if (turn_shoot % 2 == 0) {
                    ViewController.day.shotadder(1, ground);
                }
            }
        }


    }
}
