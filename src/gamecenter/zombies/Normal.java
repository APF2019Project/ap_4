package gamecenter.zombies;

import controller.ViewController;
import gamecenter.GameMode;
import gamecenter.Ground;

public class Normal extends Zombies {
    boolean buckethead;
    public Normal(String name, Ground ground) {
        buckethead=true;
        type="Normal";
        if (name.matches("zombie")) {
            setparameters("Zombie", 2, 2, 1, ground);
        }
        if (name.matches("football zombie")) {
            setparameters("Football Zombie", 3, 4, 1, ground);
        }
        if (name.matches("buckethead zombie")) {
            setparameters("Buckethead Zombie", 2, 3, 1, ground);

        }
        if (name.matches("conehead zombie")) {
            setparameters("Conehead Zombie", 2, 3, 1, ground);
        }
    }
/*
    @Override
    public void operation(Ground[] grounds) {
        if (getName().matches("Zombie")) {
            Zombie(grounds);
        }
        if (getName().matches("Football Zombie")) {
     Zombie(grounds);
     //Braye tabe nokhode tigh dar mostana shavad
        }
        if (getName().matches("Buckethead Zombie")) {
            Zombie(grounds);
        }
        if (getName().matches("Conehead Zombie")) {
            Zombie(grounds);
        }
    }
*/
   // public void ConeheadZombie(Ground[] grounds) { }
//Vaghti kolahash jazb shavad
   public void BucketheadZombie(){
        if (buckethead){
        buckethead=false;
        if(getHealth()>1) setHealth(this.getDamage());}
     }
   /* public void BucketheadZombie(Ground[] grounds) {
        int y = getGround().getGroundY();
        for (int i = 0; i < getSpeed(); i++) {
            if (grounds[y-1].settledPlant==null){
                grounds[y].settledZombie.remove(this);
                grounds[y-1].settledZombie.add(this);
                this.setGround(grounds[y-1]);
            }else {
                if (grounds[y-1].settledPlant.getHealth()>0)
                    grounds[y-1].settledPlant.setHealth(1);

                if (grounds[y-1].settledPlant.getHealth()<=0){
                    grounds[y-1].settledPlant=null;
                }
            }
        }
    }*/


   // public void FootballZombie(Ground[] grounds) { }
/*
    public void Zombie(Ground[] grounds) {
        int y = getGround().getGroundY();
        for (int i = 0; i < getSpeed(); i++) {
            if (grounds[y-1].settledPlant==null){
                grounds[y].settledZombie.remove(this);
                grounds[y-1].settledZombie.add(this);
                this.setGround(grounds[y-1]);
            }else {
                if (grounds[y-1].settledPlant.getHealth()>0)
                grounds[y-1].settledPlant.setHealth(getDamage());

                if (grounds[y-1].settledPlant.getHealth()<=0){
                    grounds[y-1].settledPlant=null;

                }
            }
        }
    }
    */
}
