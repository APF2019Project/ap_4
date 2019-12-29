package gamecenter.zombies;

import gamecenter.Ground;

public class WaterZombie extends Zombies {

    public WaterZombie(String name, Ground ground) {
        if (name.matches("Snorkel Zombie")) {
            setparameters("Snorkel Zombie", 2, 2, 1, ground);
            shield = 0;
        } else {
            setparameters("Dolphin Rider Zombie", 2, 2, 1, ground);
            shield = 2;
            setHealth(-2);
        }

    }


    @Override
    public void operation(Ground[] grounds) {
        for (Ground ground : grounds) {
            if (ground.isType()) return;
        }
        int y = getGround().getGroundY();
        for (int i = 0; i < getSpeed(); i++) {
            if (grounds[y - 1].settledPlant == null) {
                grounds[y].settledZombie.remove(this);
                grounds[y - 1].settledZombie.add(this);
                this.setGround(grounds[y - 1]);
            } else {
                if (grounds[y - 1].settledPlant.getHealth() > 0)
                    grounds[y - 1].settledPlant.setHealth(getDamage());

                if (grounds[y - 1].settledPlant.getHealth() <= 0) {
                    grounds[y - 1].settledPlant = null;

                }
            }
        }
        y = getGround().getGroundY();
        if (y==0){ grounds[0].Chamnzan(grounds);}

    }

    public void DolphinRiderZombie(boolean status) {

    }

    public void SnorkelZombie(boolean status) {

    }
}
