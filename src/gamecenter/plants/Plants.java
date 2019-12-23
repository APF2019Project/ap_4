package gamecenter.plants;

import gamecenter.Ground;

public class Plants {

    private int sun_used;
    private int rest;
    private int health;
    private Ground ground;

    public Plants() {
    }

    public void setparameters(int sun_used, int rest, int health, Ground ground) {
        this.sun_used = sun_used;
        this.health = health;
        this.rest = rest;
        this.ground = ground;
    }


    public Ground getGround() {
        return ground;
    }

    public void setGround(Ground ground) {
        this.ground = ground;
    }

    public void setHealth(int a) {
        health -= a;
    }

    public int getHealth() {
        return health;
    }


    public void operation() {
        // TODO - implement Plants.operation
        throw new UnsupportedOperationException();
    }
}
