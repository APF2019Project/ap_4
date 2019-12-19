package gamecenter.zombies;

import gamecenter.Ground;


public class Zombies {
    private int speed;
    private int health;
    private int damage;
    private Ground ground;

    public Zombies() {
    }

    public void setparameters(int speed, int health, int damage, Ground ground) {
        this.speed = speed;
        this.health = health;
        this.damage = damage;
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
}
