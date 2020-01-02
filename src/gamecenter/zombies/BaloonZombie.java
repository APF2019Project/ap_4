package gamecenter.zombies;

import gamecenter.Ground;

public class BaloonZombie extends Zombies {
    public BaloonZombie(Ground ground) {
        setparameters("balloon zombie", 2, 3, 1, ground);
        type="BaloonZombie";
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
}
