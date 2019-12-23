package gamecenter.plants;

import gamecenter.Ground;

public class WithoutActon extends Plants {

    public WithoutActon(String name, Ground ground) {
        if (name.matches("Wall-nut")){
            setparameters(2,4,4,ground);
        }
        if (name.matches("Tall-nut")){
            setparameters(4,6,6,ground);
        }
        if (name.matches("Magnet-shroom")){
            setparameters(4,4,2,ground);
        }
    }
    public void Wallnut(boolean status) {
        // TODO - implement WithoutAction.Wallnut
        throw new UnsupportedOperationException();
    }

    public void Tallnut(boolean status) {
        // TODO - implement WithoutAction.Tallnut
        throw new UnsupportedOperationException();
    }

    public void Magnetshroom(boolean status) {
        // TODO - implement WithoutAction.Magnetshroom
        throw new UnsupportedOperationException();
    }
}
