package gamecenter.plants;

import gamecenter.GameMode;
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
                    //grounds[i].settledZombie.get(0).speedLimiter();
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

    public void setXY(GameMode gameMode) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 19; j++) {
                if (gameMode.GameGround[i][j] == ground) {
                    groundX = i;
                    groundY = j;
                }
            }
        }
    }

    public void setIcy(boolean icy) {
        this.icy = icy;
    }
}

