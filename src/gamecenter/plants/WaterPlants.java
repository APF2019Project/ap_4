package gamecenter.plants;

import gamecenter.Ground;

public class WaterPlants extends Plants {

    public WaterPlants(String name, Ground ground) {
        Plants plants;
        type = "waterplants";
        if (name.matches("lily pad")){
            setparameters("Lily Pad",0,1,1,ground);
        }
    }


    public void operation() {
    }

}
