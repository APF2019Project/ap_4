package gamecenter.zombies;

import gamecenter.GameMode;
import gamecenter.Ground;

public class Zombies {
    public String imagePath;
    public int capacity = 2;
    protected String name2;
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
    protected int turn_freeze;

    public Zombies() {
    }
    @Override
    public String toString() {
        return name + "  " + price;
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
    public Zombies(String name2, String name, int speed, int health, int damage) {
        this.name = name.toLowerCase();
        this.price = (1 + speed) * health * 10;
        this.speed = speed;
        this.health = health;
        this.damage = damage;
        this.name2 = name2;
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
        String name = name2;
        int y = getGround().getGroundY();
        if (y == 0) {
            grounds[0].Chamnzan(grounds);
            return;
        }
        for (int i = 0; i < getSpeed(); i++) {
            y = getGround().getGroundY();
            if (y == 0) break;
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

    public void setXY(GameMode gameMode) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 19; j++) {
                if (gameMode.GameGround[i][j] == ground) {
                    groundX = i;
                    groundY = j;
                }
            }
        }
    }

    public void CatapultZombie() {
        if (getName().equals("zomboni") && getHealth() <= 0) {
            setparameters("Zombie", 2, 2, 1, getGround());
        }
    }
}
