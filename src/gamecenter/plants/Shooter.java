package gamecenter.plants;

import gamecenter.Ground;

public class Shooter extends Plants {

    public Shooter(String name, Ground ground) {
        if (name.matches("Cabbage-pult")){
            setparameters(2,3,2,ground);
        }
        if (name.matches("Winter Melon")){
            setparameters(4,5,3,ground);
        }
        if (name.matches("Melon-pult")){
            setparameters(3,3,3,ground);
        }
        if (name.matches("Kernel-pult")){
            setparameters(3,3,2,ground);
        }
    }
    public void Cabbagepult(boolean status) {
        // TODO - implement shooterr.Cabbagepult
        throw new UnsupportedOperationException();
    }

    public void WinterMelon(boolean status) {
        // TODO - implement shooterr.WinterMelon
        throw new UnsupportedOperationException();
    }

    public void Melonpult(boolean status) {
        // TODO - implement shooterr.Melonpult
        throw new UnsupportedOperationException();
    }

    public void Kernelpult(boolean status) {
        // TODO - implement shooterr.Kernelpult
        throw new UnsupportedOperationException();
    }

}
