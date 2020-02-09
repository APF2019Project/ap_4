package gamecenter.plants;

import gamecenter.GameMode;
import gamecenter.Ground;

public class WithoutActon extends Plants {

    public WithoutActon(String name, Ground ground) {
        name = name.toLowerCase();
        type = "withoutaction";
        if (name.matches("wall-nut")) {
            setparameters("Wall-nut", 2, 4, 4, ground);
            imagePath = "pics/Wall-nut.jpg";
        }
        if (name.matches("tall-nut")) {
            setparameters("Tall-nut", 4, 6, 6, ground);
            imagePath = "pics/Tall-nut.jpg";
        }
    }

    @Override
    public void operation(GameMode gameMode) {

    }
}
