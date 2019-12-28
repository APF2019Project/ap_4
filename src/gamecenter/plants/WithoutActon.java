package gamecenter.plants;

import gamecenter.Ground;

public class WithoutActon extends Plants {

    public WithoutActon(String name, Ground ground) {
        type = "withoutaction";
        if (name.matches("wall-nut")){
            setparameters("Wall-nut",2,4,4,ground);
        }
        if (name.matches("tall-nut")){
            setparameters("Tall-nut",4,6,6,ground);
        }
        if (name.matches("magnet-shroom")){
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
