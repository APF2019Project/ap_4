package gamecenter.plants;

import gamecenter.Ground;

public class Rocket {

    Ground ground;
    int groundX;
    int groundY;
    int damage;
    String kind;

    public Rocket(Ground groundm, int damage, String kind) {
        this.kind = kind;
        this.damage = damage;
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
                grounds[i].settledZombie.get(0).setHealth(damage);
                if (kind.equals("icy")) {
                    //winter melon
                }
                if (kind.equals("sticky")) {
                    //kernel pult
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

    public int getDamage() {

        return damage;
    }

    public void setDamage(int damage) {

        this.damage = damage;
    }
}
