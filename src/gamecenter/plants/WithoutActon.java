package gamecenter.plants;

import gamecenter.Ground;

public class WithoutActon extends Plants {

    public WithoutActon(String name, Ground ground) {
        if (name.matches("Wall-nut")){
            setparameters("Wall-nut",2,4,4,ground);
        }
        if (name.matches("Tall-nut")){
            setparameters("Tall-nut",4,6,6,ground);
        }
        if (name.matches("Magnet-shroom")){
            setparameters("Magnet-shroom",4,4,2,ground);
        }
    }
    public void Wallnut(boolean status) {

    }

    public void Tallnut(boolean status) {

    }

    public void Magnetshroom(boolean status) {

    }
}
