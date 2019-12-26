package gamecenter.plants;

import gamecenter.Ground;

public class Shooter extends Plants {

    public Shooter(String name, Ground ground) {
        type = "shooter";
        if (name.matches("Cabbage-pult")){
            setparameters("Cabbage-pult",2,3,2,ground);
        }
        if (name.matches("Winter Melon")){
            setparameters("Winter Melon",4,5,3,ground);
        }
        if (name.matches("Melon-pult")){
            setparameters("Melon-pult",3,3,3,ground);
        }
        if (name.matches("Kernel-pult")){
            setparameters("Kernel-pult",3,3,2,ground);
        }
    }

    public void Cabbagepult(boolean status) {
    }

    public void WinterMelon(boolean status) {
    }

    public void Melonpult(boolean status) {
    }

    public void Kernelpult(boolean status) {
    }

}
