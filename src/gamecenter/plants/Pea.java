package gamecenter.plants;

import gamecenter.Ground;

public class Pea extends Plants {
    public Pea(String name, Ground ground) {
        if (name.matches("Peashooter")) {
            setparameters("Peashooter", 2, 2, 2, ground);
        }
        if (name.matches("Repeater")) {
            setparameters("Repeater", 3, 4, 4, ground);
        }
        if (name.matches("Threepeater")) {
            setparameters("Threepeater", 4, 4, 5, ground);
        }
        if (name.matches("Cactus")) {
            setparameters("Cactus", 5, 4, 5, ground);
        }
        if (name.matches("Split Pea")) {
            setparameters("Split Pea", 4, 4, 3, ground);
        }
        if (name.matches("Gatling Pea")) {
            setparameters("Gatling Pea", 5, 4, 3, ground);
        }
        if (name.matches("Scaredy-shroom")) {
            setparameters("Scaredy-shroom", 1, 2, 1, ground);
        }
        if (name.matches("Snow Pea")) {
            setparameters("Snow Pea", 3, 3, 3, ground);
        }
    }

    public void Peashooter(boolean status) {

    }

    public void Repeater(boolean status) {

    }

    public void Threepeater(boolean status) {

    }

    public void Cactus(boolean status) {

    }

    public void SplitPea(boolean status) {

    }

    public void GatlingPea(boolean status) {

    }

    public void Scaredyshroom(boolean status) {

    }

    public void SnowPea(boolean status) {

    }

}
