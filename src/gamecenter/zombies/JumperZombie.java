package gamecenter.zombies;

import gamecenter.Ground;

public class JumperZombie extends Zombies {
    public JumperZombie(Ground ground) {
        setparameters("Pogo Zombie", 2, 2, 0, ground);
    }

    @Override
    public void operation(Ground[] grounds) {
        for (int i = 0; i < getSpeed(); i++) {
            int k = 1;
            while (!changeLocation(grounds, k)) {
                k++;
            }
        }
        int y = getGround().getGroundY();
        if (y==0){ grounds[0].Chamnzan(grounds);}
    }
    boolean changeLocation(Ground[] grounds,int k){
        int y = getGround().getGroundY();
        if (y-k==-1){
            grounds[y].settledZombie.remove(this);
            grounds[0].settledZombie.add(this);
            this.setGround(grounds[0]);
            return true;
        }
        if (grounds[y - k].settledPlant == null) {
            grounds[y].settledZombie.remove(this);
            grounds[y - k].settledZombie.add(this);
            this.setGround(grounds[y - k]);
            return true;
        }
        return false;
    }
}

