package gamecenter.plants;

import gamecenter.Ground;

public class Damage extends Plants {

    public Damage(String name, Ground ground) {
        if (name.matches("Tangle Kelp")){
            setparameters("Tangle Kelp",3,3,0,ground);
        }
        if (name.matches("Potato Mine")){
            setparameters("Potato Mine",2,3,1,ground);
        }
        if (name.matches("Cherry Bomb")){
            setparameters("Cherry Bomb",2,4,0,ground);
        }
        if (name.matches("Cattail")){
            setparameters("Cattail",5,5,3,ground);
        }
        if (name.matches("Jalapeno")){
            setparameters("Jalapeno",4,5,0,ground);
        }
        if (name.matches("Explode-o-nut")){
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
