package gamecenter.plants;

import gamecenter.Ground;

public class Rocket {

    Ground ground = new Ground();
    int groundX;
    int groundY;
    int damage;

    public boolean operation(Ground[] grounds, int damage) {
        int flag = 0;
        for (int i = 0; i < grounds.length; i++) {
            if (grounds[i] == ground) {
                flag = i;
                break;
            }
        }
        for (int i = flag; i < flag + 4; i++) {
            if (grounds[i].settledZombie != null) {
                grounds[i].settledZombie.setHealth(damage);
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

    public int getDamage() {

        return damage;
    }

    public void setDamage(int damage) {

        this.damage = damage;
    }
}
