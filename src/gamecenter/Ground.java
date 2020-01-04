package gamecenter;

import gamecenter.plants.Plants;
import gamecenter.zombies.Zombies;

import java.util.ArrayList;

public class Ground {

    int groundX;
    int groundY;
    boolean type;
    public Plants settledPlant = null;
    public ArrayList<Zombies> settledZombie = new ArrayList<>();
    boolean chamanzan = true;

    public boolean isType() {
        return type;
    }

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

    public void Chamnzan(Ground[] grounds) {
        if (groundY == 0 && chamanzan) {
            for (int i = 0; i < 19; i++) {
                for (int k = 0; k < grounds[i].settledZombie.size(); i++)
                    grounds[i].settledZombie.remove(k);
            }
            chamanzan = false;
        }
    }

}