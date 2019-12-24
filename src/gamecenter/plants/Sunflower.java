package gamecenter.plants;

import gamecenter.Ground;

public class Sunflower extends Plants {

    public Sunflower(String name, Ground ground) {
        if (name.matches("Sunflower")){
            setparameters("Sunflower",1,2,2,ground);
        }
        if (name.matches("Twin Sunflower")){
            setparameters("Twin Sunflower",3,5,2,ground);
        }
    }

    public Sunflower(boolean status) {

    }

    public void TwinSunflower(boolean status) {

    }

}
