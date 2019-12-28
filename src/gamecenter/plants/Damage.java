package gamecenter.plants;

import gamecenter.Ground;

public class Damage extends Plants {

    public Damage(String name, Ground ground) {
        type = "damage";
        if (name.matches("tangle kelp")){
            setparameters("Tangle Kelp",3,3,0,ground);
        }
        if (name.matches("potato mine")){
            setparameters("Potato Mine",2,3,1,ground);
        }
        if (name.matches("cherry bomb")){
            setparameters("Cherry Bomb",2,4,0,ground);
        }
        if (name.matches("cattail")){
            setparameters("Cattail",5,5,3,ground);
        }
        if (name.matches("jalapeno")){
            setparameters("Jalapeno",4,5,0,ground);
        }
        if (name.matches("explode-o-nut")){
            setparameters("Explode-o-nut",4,5,3,ground);
        }
    }

    public void TangleKelp(boolean status) {
    }

    public void PotatoMine(boolean status) {
    }

    public void CherryBomb(boolean status) {

    }

    public void Cattail(boolean status) {

    }

    public void Jalapeno(boolean status) {

    }

    public void Explodeonut(boolean status) {

    }

}
