package gamecenter.zombies;

import controller.ViewController;
import gamecenter.Ground;

public class Zombies {
    public int shield;
    public String type = "";
    private String name;
    private int speed;
    private int health;
    private int damage;
    private Ground ground;
    private int price;
    protected int groundX;
    protected int groundY;

    public Zombies() {
    }

    public String getName() {


        return name;
    }

    public int getSpeed() {

        return speed;
    }

    public int getPrice() {

        return price;
    }

    public void setparameters(String name, int speed, int health, int damage, Ground ground) {
        this.name = name.toLowerCase();
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

    public void operation(Ground[] grounds) {
        int y = getGround().getGroundY();
        if (y == 0) {
            grounds[0].Chamnzan(grounds);
            return;
        }
        for (int i = 0; i < getSpeed(); i++) {
            if (grounds[y - 1].settledPlant == null) {
                grounds[y].settledZombie.remove(this);
                grounds[y - 1].settledZombie.add(this);
                this.setGround(grounds[y - 1]);
            } else {
                if (grounds[y - 1].settledPlant.getHealth() > 0) {
                    grounds[y - 1].settledPlant.setHealth(getDamage());
                    if (grounds[y - 1].settledPlant.getHealth() <= 0) {
                        grounds[y - 1].settledPlant = null;
                    } else break;
                }
            }
        }
        y = getGround().getGroundY();
        if (y == 0) {
            grounds[0].Chamnzan(grounds);
        }
    }

    public int getGroundX() {

        return ground.getGroundX();
    }

    public int getDamage() {

        return damage;
    }

    public void suddenDeath() {

        health = 0;
    }

    public void speedLimiter() {

        speed = speed / 2;
    }

    public void speedUnLimiter() {

        speed = 2 * speed;
    }

    private void setXY() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 19; j++) {
                if (ViewController.day.GameGround[i][j] == ground) {
                    groundX = i;
                    groundY = j;
                }
            }
        }
    }
}
