package gamecenter;

import gamecenter.plants.Plants;
import java.util.ArrayList;
import java.util.Random;

public class Day extends GameMode {
    static int sun=2;
    static int turn=1;
    Random generator = new Random();
    ArrayList<Zombies> Zombies=new ArrayList<>();
    void Day(/* Plants  */){  // plants Arraylist
        if (turn==3){
            int i=generator.nextInt(7)+4;
            for (int k=0;k<i;k++) Zombies.add(new zombie);
        }



            turn++;
    }
}
