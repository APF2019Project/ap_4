package gamecenter.zombies;

import gamecenter.Ground;

public class SpiderZombie extends Zombies {
    int turn;
    public SpiderZombie(Ground ground) {
        type="s";
        setparameters("bungee zombie",0,3,10000,ground); turn=0;
        imagePath = "pics/BungeeZombie.jpg";
    }
@Override
    public void operation(Ground[] grounds){
        turn++;
        if (turn==3){
            int y = getGround().getGroundY();
            grounds[y].settledPlant=null;
            grounds[y].settledZombie.remove(this);
            //hazf zombie va plant az zombies ingame
            this.setHealth(getHealth());
        }
    }
}
