package gamecenter;

import controller.ViewController;
import gamecenter.plants.Peas;
import gamecenter.plants.Plants;
import gamecenter.zombies.Zombies;

import java.util.ArrayList;

public class PvP extends GameMode {
    private int sun = 2;
    int waveNumber = 1;
    int plantWins = 0;
    int zombieWins = 0;
    int turn;
    Plants selectedPlant;
    Zombies selectedZombie;
    ArrayList<Plants> plants_hand;

    ArrayList<gamecenter.zombies.Zombies> Zombies = new ArrayList<>();

    public PvP() {
        super();
        plants_hand = ViewController.collection.plants_hand;
        for (int i = 0; i < 6; i++) {
            for (int k = 0; k < 19; k++) {
                GameGround[i][k].groundX = i;
                GameGround[i][k].groundY = k;
                GameGround[i][k].type = true;
            }
        }
        turn = 0;
    }

    public void pvpEndTurn() {
        turn++;
        setSun(1);

        for (Plants plant : PlantsinGame) {
            plant.operation();
        }
        for (Zombies zombie : ZombiesinGame) {
            int i = zombie.getGroundX();
            zombie.operation(getGroundline(i));
        }

        if (zombieWins()) {
            //Zombie Wins
        }

        deathSets();

    }

    public void ready() {
    }

    boolean waveWinner(){
        plantWins++;
        zombieWins++;
        return true;
    }






    boolean zombieWins() {
        for (int k = 0; k < 6; k++) {
            if (!GameGround[k][0].chamanzan && GameGround[k][0].settledZombie.size() != 0)
                return true;
        }
        return false;
    }

    //True if plant was in game
    boolean plantsCheck() {
        boolean check = false;
        for (int i = 0; i < 6; i++) {
            for (int k = 0; k < 19; k++) {
                if (!GameGround[i][k].settledPlant.isDead())
                    check = true;

            }
        }
        return check;
    }

    boolean zombiesCheck() {
        boolean check = false;
        for (int i = 0; i < 6; i++) {
            for (int k = 0; k < 19; k++) {
                for (int w = 0; w < GameGround[i][k].settledZombie.size(); w++)
                    if (!GameGround[i][k].settledZombie.get(w).isDead())
                        check = true;

            }
        }
        return check;
    }

    public int select(String name) {
        for (Plants plant : plants_hand) {
            if (name.contains(plant.getName())) {
                if (plant.getSun_used() <= sun) {
                    if (!plant.isTired()) {
                        sun -= plant.getSun_used();
                        selectedPlant = cardFinder(plant, name);
                        PlantsinGame.add(selectedPlant);
                        return 2;
                    } else return 1;
                } else return 0;
            }
        }
        return -1;
    }

    public boolean plantingPlant(int j, int i) {
        if (j>2) return false;
        if (GameGround[i][j].settledPlant == null || GameGround[i][j].settledZombie.size() == 0) {
            GameGround[i][j].settledPlant = selectedPlant;
            selectedPlant.setGround(GameGround[i][j]);
            selectedPlant = null;
            return true;
        } else return false;
    }




    public boolean removePlant(int j, int i) {
        if (GameGround[i][j].settledPlant != null) {
            PlantsinGame.remove(GameGround[i][j].settledPlant);
            GameGround[i][j].settledPlant.setGround(null);
            GameGround[i][j].settledPlant = null;
            return true;
        } else return false;
    }



}
