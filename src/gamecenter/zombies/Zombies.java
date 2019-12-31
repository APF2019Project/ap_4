package gamecenter.zombies;

import gamecenter.Ground;

public class Zombies {
    public int shield;
    protected String type;
    protected String name;
    protected int speed;
    protected int health;
    protected int damage;
    protected Ground ground;
    protected int price;
    protected int turn;

    public Zombies() {
    }

    public String getName() {

        return name;
    }

    public int getPrice() {

        return price;
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

    public boolean isDead() {

        return health <= 0;
    }

    public String getType() {

        return type;
    }

    public void operation() {}

    //NEW THINGS
    public void suddenDeath() {
        health = 0;
    }
}
