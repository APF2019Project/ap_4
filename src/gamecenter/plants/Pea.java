package gamecenter.plants;

import gamecenter.Ground;

public class Pea extends Plants {
    public Pea(String name, Ground ground) {
        if (name.matches("Peashooter")){
            setparameters(2,2,2,ground);
        }
        if (name.matches("Repeater")){
            setparameters(3,4,4,ground);
        }
        if (name.matches("Threepeater")){
            setparameters(4,4,5,ground);
        }
        if (name.matches("Cactus")){
            setparameters(5,4,5,ground);
        }
        if (name.matches("Split Pea")){
            setparameters(4,4,3,ground);
        }
        if (name.matches("Gatling Pea")){
            setparameters(5,4,3,ground);
        }
        if (name.matches("Scaredy-shroom")){
            setparameters(1,2,1,ground);
        }
        if (name.matches("Snow Pea")){
            setparameters(3,3,3,ground);
        }
    }
    public void Peashooter(boolean status) {
        // TODO - implement Pea.Peashooter
        throw new UnsupportedOperationException();
    }

    public void Repeater(boolean status) {
        // TODO - implement Pea.Repeater
        throw new UnsupportedOperationException();
    }

    public void Threepeater(boolean status) {
        // TODO - implement Pea.Threepeater
        throw new UnsupportedOperationException();
    }

    public void Cactus(boolean status) {
        // TODO - implement Pea.Cactus
        throw new UnsupportedOperationException();
    }

    public void SplitPea(boolean status) {
        // TODO - implement Pea.SplitPea
        throw new UnsupportedOperationException();
    }

    public void GatlingPea(boolean status) {
        // TODO - implement Pea.GatlingPea
        throw new UnsupportedOperationException();
    }

    public void Scaredyshroom(boolean status) {
        // TODO - implement Pea.Scaredyshroom
        throw new UnsupportedOperationException();
    }

    public void SnowPea(boolean status) {
        // TODO - implement Pea.SnowPea
        throw new UnsupportedOperationException();
    }

}
