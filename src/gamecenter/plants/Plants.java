package gamecenter.plants;

import controller.ViewController;
import gamecenter.GameMode;
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
    protected int groundX;
    protected int groundY;
    protected int turn_shoot = 0;

    public Plants() {
    }

    public void setparameters(String name, int sun_used, int cooldown, int health, Ground ground) {
        this.price = sun_used * health * cooldown + 1;
        this.name = name.toLowerCase();
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

    public void suddenDeath() {
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

    public void operation(GameMode gameMode) {
    }

    protected boolean isThereAnyZombie(GameMode gameMode) {
        for (int j = groundY; j < 19; ++j) {
            if (gameMode.GameGround[groundX][j].settledZombie.size() > 0) {
                return true;
            }
        }
        return false;
    }
}
