package gamecenter.plants;

import gamecenter.Ground;

public class Sunflower extends Plants {

    public Sunflower(String name, Ground ground) {
        type = "sunflower";
        if (name.matches("sunflower")){
            setparameters("Sunflower",1,2,2,ground);
        }
        if (name.matches("twin sunflower")){
            setparameters("Twin Sunflower",3,5,2,ground);
        }
    }

    public Sunflower(boolean status) {

    }

    public void TwinSunflower(boolean status) {

    }

}
