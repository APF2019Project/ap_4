package gamecenter.zombies;

import gamecenter.Ground;

public class CARZombie extends Zombies {

    public CARZombie(String name, Ground ground) {
        type = "c";
        if (name.matches("zomboni")) {
            setparameters("Zomboni", 2, 3, 1000, ground);
        }
        else {
            setparameters("Catapult Zombie", 2, 3, 1000, ground);
        }
    }

    @Override
    public void operation(Ground[] grounds) {
        int y = getGround().getGroundY();
        if (y == 0) {
            grounds[0].Chamnzan(grounds);
            return;
        }
        for (int i = 0; i <= getSpeed(); i++) {
            y = getGround().getGroundY();
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
        CatapultZombie();
        y = getGround().getGroundY();
        if (y == 0) {
            grounds[0].Chamnzan(grounds);
        }

    }

    public void CatapultZombie() {
        if (getName().equals("catapult zombie") && getHealth() <= 0) {
            setparameters("Zombie", 2, 2, 1, getGround());
        }
    }
}
