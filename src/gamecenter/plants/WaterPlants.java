package gamecenter.plants;

import gamecenter.Ground;

public class WaterPlants extends Plants {

    public WaterPlants(String name, Ground ground) {
        if (name.matches("Lily Pad")){
            setparameters(0,1,1,ground);
        }
    }
    public void LilyPad(boolean status) {
        // TODO - implement WaterPlants.LilyPad
        throw new UnsupportedOperationException();
    }

}
