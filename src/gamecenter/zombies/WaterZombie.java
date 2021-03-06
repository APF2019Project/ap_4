package gamecenter.zombies;

import gamecenter.Ground;

public class WaterZombie extends Zombies {

    public WaterZombie(String name, Ground ground) {
        name = name.toLowerCase();
        type="w";
        if (name.matches("snorkel zombie")) {
            setparameters("Snorkel Zombie", 2, 2, 1, ground);
            imagePath = "pics/SnorkelZombie.jpg";
            shield = 0;
        } else {
            setparameters("dolphin rider zombie", 2, 2, 1, ground);
            imagePath = "pics/DolphinRiderZombie.jpg";
            shield = 2;
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
                }else break;
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
