package gamecenter.plants;

import gamecenter.Ground;

public class Damage extends Plants {

    public Damage(String name, Ground ground) {
        if (name.matches("Tangle Kelp")){
            setparameters(3,3,0,ground);
        }
        if (name.matches("Potato Mine")){
            setparameters(2,3,1,ground);
        }
        if (name.matches("Cherry Bomb")){
            setparameters(2,4,0,ground);
        }
        if (name.matches("Cattail")){
            setparameters(5,5,3,ground);
        }
        if (name.matches("Jalapeno")){
            setparameters(4,5,0,ground);
        }
        if (name.matches("Explode-o-nut")){
            setparameters(4,5,3,ground);
        }
    }

    public void TangleKelp(boolean status) {
    }

    public void PotatoMine(boolean status) {
        // TODO - implement Damage.PotatoMine
        throw new UnsupportedOperationException();
    }

    public void CherryBomb(boolean status) {
        // TODO - implement Damage.CherryBomb
        throw new UnsupportedOperationException();
    }

    public void Cattail(boolean status) {
        // TODO - implement Damage.Cattail
        throw new UnsupportedOperationException();
    }

    public void Jalapeno(boolean status) {
        // TODO - implement Damage.Jalapeno
        throw new UnsupportedOperationException();
    }

    public void Explodeonut(boolean status) {
        // TODO - implement Damage.Explodeonut
        throw new UnsupportedOperationException();
    }

}
