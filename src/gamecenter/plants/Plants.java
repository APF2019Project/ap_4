package gamecenter.plants;

import gamecenter.Ground;

public class Plants {
    private int turn_cooldown;
    public String type = "";
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

    public boolean isAlive() {

        return health > 0;
    }

    public boolean isTired() {
        if (turn_cooldown == 0) {
            turn_cooldown = cooldown;
            return false;
        } else {
            return true;
        }
    }

    public void operation() {
    }
}
