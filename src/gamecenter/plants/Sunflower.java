package gamecenter.plants;

import gamecenter.Ground;

public class Sunflower extends Plants {

    public Sunflower(String name, Ground ground) {
        if (name.matches("Sunflower")){
            setparameters(1,2,2,ground);
        }
        if (name.matches("Twin Sunflower")){
            setparameters(3,5,2,ground);
        }
    }

    public Sunflower(boolean status) {
        // TODO - implement Sunflower.Sunflower
        throw new UnsupportedOperationException();
    }

    public void TwinSunflower(boolean status) {
        // TODO - implement Sunflower.TwinSunflower
        throw new UnsupportedOperationException();
    }

}
