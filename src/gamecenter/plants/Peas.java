package gamecenter.plants;

import gamecenter.Ground;

public class Peas {
    Ground ground;
    int groundX;
    int groundY;
    boolean icy;

    public Peas(Ground ground) {

        this.ground = ground;
    }

    public boolean operation(Ground[] grounds) {
        int flag = 0;

        for (int i = 0; i < grounds.length; i++) {
            if (grounds[i] == ground) {
                flag = i;
                break;
            }
        }
        for (int i = flag; i < flag + 4; i++) {
            if (grounds[i].settledZombie.size() != 0) {
                if (grounds[i].settledZombie.get(0).shield > 0) {
                    grounds[i].settledZombie.get(0).shield--;
                } else {
                    grounds[i].settledZombie.get(0).setHealth(1);
                }
                if (icy) {
                    //grounds[i].settledZombie.icyplant.
                }
                return true;
            }
            if (i == 18) {
                return true;
            }
        }
        setGround(grounds[flag + 3]);
        return false;
    }

    public Ground getGround() {

        return ground;
    }

    public void setGround(Ground ground) {

        this.ground = ground;
    }

    public int getGroundX() {

        return groundX;
    }

    public void setGroundX(int groundX) {

        this.groundX = groundX;
    }

    public int getGroundY() {

        return groundY;
    }

    public void setGroundY(int groundY) {

        this.groundY = groundY;
    }

}

