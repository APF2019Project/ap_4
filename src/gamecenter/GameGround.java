package gamecenter;

public class GameGround {
    Ground[][] GameGround=new Ground[6][19];

    void Day(){
        for (Ground[] g:GameGround) {
            for (Ground w:g) {
                //Dar rooz hame zamin khoshki ast.
                w.type=true;
            }
        }
    }

}
