package gamecenter.plants;

import gamecenter.Ground;

public class WaterPlants extends Plants {

    public WaterPlants(String name, Ground ground) {
        type = "waterplants";
        if (name.matches("Lily Pad")){
            setparameters("Lily Pad",0,1,1,ground);
        }
    }
    public void LilyPad(boolean status) {

    }

}
