package gamecenter.plants;

import gamecenter.Ground;

public class Plants {
    private String name;
    private int price;
    private int sun_used;
    private int cooldown;
    private int health;
    private Ground ground;

    public Plants() {
    }

    public void setparameters(String name, int sun_used, int cooldown, int health, Ground ground) {
        this.price = sun_used * health * cooldown + 1;
        this.name = name;
        this.sun_used = sun_used;
        this.health = health;
        this.cooldown = cooldown;
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
