package gamecenter;

import gamecenter.plants.Plants;
import gamecenter.zombies.Zombies;

public class Ground {

    int groundX;
    int groundY;
    boolean type;
    public Plants settledPlant = null;
    public Zombies settledZombie = null;

    public void setGroundX(int groundX) {
        this.groundX = groundX;
    }

    public void setGroundY(int groundY) {
        this.groundY = groundY;
    }

    public int getGroundX() {
        return groundX;
    }

    public int getGroundY() {
        return groundY;
    }

    public void Bilche() {
    }

    public void Chamnzan() {

    }

}