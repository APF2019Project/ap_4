package gamecenter.zombies;

import gamecenter.Ground;

public class Zombies {
    private String name;
    private int speed;
    private int health;
    private int damage;
    private Ground ground;
    private int price;

    public Zombies() {
    }

    public void setparameters(String name, int speed, int health, int damage, Ground ground) {
        this.name = name;
        this.price = (1 + speed) * health * 10;
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
