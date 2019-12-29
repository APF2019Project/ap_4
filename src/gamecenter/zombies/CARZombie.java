package gamecenter.zombies;

import gamecenter.Ground;

public class CARZombie extends Zombies {

    public CARZombie(String name, Ground ground) {
        if (name.matches("Zomboni")) {
            setparameters("Zomboni", 2, 3, 1000, ground);
        }
        if (name.matches("Catapult Zombie")) {
            setparameters("Catapult Zombie", 2, 3, 1000, ground);
        }
    }
/*
    @Override
    public void operation(Ground[] grounds) {
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
}
       */


    public void Zomboni(boolean status) {
    }

    public void CatapultZombie(boolean status) {
    }
}
