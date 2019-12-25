package gamecenter;

import gamecenter.plants.Plants;
import gamecenter.zombies.Zombies;

import java.util.ArrayList;

public class GameMode {
    Ground[][] GameGround = new Ground[19][6];

    public int sun;
    ArrayList<Plants> PlantsinGame = new ArrayList<>();
    ArrayList<Zombies> ZombiesinGame = new ArrayList<>();

    void DayGround() {
        for (int i=0;i<19;i++) {
            for (int k=0;k<6;k++) {
                GameGround[i][k].groundX=i;
                GameGround[i][k].groundY=k;
                GameGround[i][k].type = true;
            }
        }
    }
    ArrayList<Integer> showLawnX=new ArrayList<>();
    ArrayList<Integer> showLawnY= new ArrayList<>();
    ArrayList<Integer> showLawnHealth=new ArrayList<>();
    ArrayList<String> showLawn(){
        ArrayList<String> a=new ArrayList<>();
        for (int i=0;i<PlantsinGame.size();i++){
            a.add(PlantsinGame.get(i).getName());
            showLawnX.add(PlantsinGame.get(i).getGround().groundX);
            showLawnY.add(PlantsinGame.get(i).getGround().groundY);
            showLawnHealth.add(PlantsinGame.get(i).getHealth());
        }
        for (int i=0;i<ZombiesinGame.size();i++){
            a.add(ZombiesinGame.get(i).getName());
            showLawnX.add(ZombiesinGame.get(i).getGround().groundX);
            showLawnY.add(ZombiesinGame.get(i).getGround().groundY);
            showLawnHealth.add(ZombiesinGame.get(i).getHealth());
        }
        return a;
    }
    ArrayList<Integer> showLawnX(){return showLawnX;}
    ArrayList<Integer> showLawnY(){return showLawnY;}
    ArrayList<Integer> showLawnHealth(){return showLawnHealth;}

}
