package gamecenter.plants;

import gamecenter.Ground;

public class Plants {
    protected int turn_cooldown;
    public String type = "";
    protected String name;
    protected int price;
    protected int sun_used;
    protected int cooldown;
    protected int health;
    protected Ground ground;

    public Plants() {
    }

    public void setparameters(String name, int sun_used, int cooldown, int health, Ground ground) {
        name = name.toLowerCase();
        this.price = sun_used * health * cooldown + 1;
        this.name = name;
        this.sun_used = sun_used;
        this.health = health;
        this.cooldown = cooldown;
        this.ground = ground;
        turn_cooldown = 0;
    }

    public int getSun_used() {

        return sun_used;
    }

    public int getCooldown() {


        return cooldown;
    }

    public String getName() {

        return name;
    }

    public int getPrice() {

        return price;
    }

    public int getTurn_cooldown() {


        return turn_cooldown;
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

    public boolean isDead() {

        return health <= 0;
    }

    public boolean isTired() {
        if (turn_cooldown == 0) {
            turn_cooldown = cooldown;
            return false;
        } else {
            return true;
        }
    }

    public void operation() {}

}
