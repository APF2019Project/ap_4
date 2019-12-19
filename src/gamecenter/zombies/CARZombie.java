package gamecenter.zombies;

import gamecenter.Ground;

public class CARZombie extends Zombies {

    public CARZombie(String name, Ground ground) {
        if (name.matches("zomboni")){
            setparameters(2,3,1,ground);
        }
        if (name.matches("catapultzombie")){
            setparameters(2,3,1,ground);
        }
    }

    public void Zomboni(boolean status) {
    }

    public void CatapultZombie(boolean status) {
    }
}
