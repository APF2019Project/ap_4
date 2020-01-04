package gamecenter.plants;

import controller.ViewController;
import gamecenter.Ground;
import gamecenter.zombies.Zombies;

import java.util.ArrayList;

public class WithoutActon extends Plants {

    public WithoutActon(String name, Ground ground) {
        name = name.toLowerCase();
        type = "withoutaction";
        if (name.matches("wall-nut")) {
            setparameters("Wall-nut", 2, 4, 4, ground);
        }
        if (name.matches("tall-nut")) {
            setparameters("Tall-nut", 4, 6, 6, ground);
        }
    }

}
