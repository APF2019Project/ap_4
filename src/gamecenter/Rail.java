package gamecenter;

import controller.ViewController;
import gamecenter.plants.*;
import gamecenter.zombies.*;

import java.util.ArrayList;
import java.util.Random;

public class Rail extends GameMode {
    private int sun;
    ArrayList<Zombies> DeadZombies = new ArrayList<>();
    ArrayList<Plants> Plants = new ArrayList<>();
    Random generator = new Random();
    ArrayList<Plants> plants_hand;
    Plants current;
    int turn;
    int addingplantturn = 1;
    int addingzombieturn = 1;


    public Rail() {
        turn = 0;
        plants_hand = ViewController.collection.plants_hand;
        for (int i = 0; i < 6; i++) {
            for (int k = 0; k < 19; k++) {
                GameGround[i][k].groundX = i;
                GameGround[i][k].groundY = k;
                GameGround[i][k].type = true;
            }
        }
    }


    public int record() {
        return DeadZombies.size();
    }

    public String select(int i) {
        current = Plants.get(i);
        Plants.remove(i);
        return current.getName();
    }

    public int select(String name) {
        for (Plants plant : plants_hand) {
            if (name.equals(plant.getName())) {
                if (plant.getSun_used() <= sun) {
                    if (!plant.isTired()) {
                        sun -= plant.getSun_used();
                        current = cardFinder(plant, name);
                        PlantsinGame.add(current);
                        return 2;
                    } else return 1;
                } else return 0;
            }
        }
        return -1;
    }

    public boolean plantingPlant(int j, int i) {
        if (GameGround[i][j].settledPlant == null) {
            current = cardFinder(current, current.getName());
            GameGround[i][j].settledPlant = current;
            current.setGround(GameGround[i][j]);
            PlantsinGame.add(current);
            current = null;
            return true;
        } else return false;
    }

    public ArrayList<String> list() {
        ArrayList<String> all = new ArrayList<String>();
        for (int i = 0; i < Plants.size(); i++) {
            all.add(Plants.get(i).getName());
        }
        return all;
    }

    public boolean removePlant(int j, int i) {
        if (GameGround[i][j].settledPlant != null) {
            PlantsinGame.remove(GameGround[i][j].settledPlant);
            GameGround[i][j].settledPlant.setGround(null);
            GameGround[i][j].settledPlant = null;
            return true;
        } else return false;
    }

    public void endTurn() {
        turn++;
        if (turn == addingplantturn) {
            addingplantturn = turn + generator.nextInt(3) + 2;
            addPlantsCard();
        }
        if (turn == addingzombieturn) {
            addingzombieturn = turn + generator.nextInt(3) + 3;
            int k = generator.nextInt(6);
            plantingZombie(k);
        }
        for (Plants plant : PlantsinGame) {
            plant.setXY(this);
            plant.operation(this);
        }

        for (Zombies zombie : ZombiesinGame) {
            int i = zombie.getGroundX();
            zombie.operation(getGroundline(i));
        }

        if (zombieWins()) {
            //Game end
        }
        deathSets();

    }

    boolean zombieWins() {
        for (int k = 0; k < 6; k++) {
            if (!GameGround[k][0].chamanzan && GameGround[k][0].settledZombie.size() != 0)
                return true;
        }
        return false;
    }

    @Override
    public void deathSets() {
        for (int i = 0; i < PlantsinGame.size(); i++) {
            if (PlantsinGame.get(i).isDead()) {
                PlantsinGame.get(i).getGround().settledPlant = null;
                PlantsinGame.remove(i);
            }
        }
        for (int i = 0; i < ZombiesinGame.size(); i++) {
            if (ZombiesinGame.get(i).isDead()) {
                ZombiesinGame.get(i).getGround().settledZombie.remove(ZombiesinGame.get(i));
                DeadZombies.add(ZombiesinGame.get(i));
                ZombiesinGame.remove(i);
            }
        }
    }

    public void plantingZombie(int q) {
        gamecenter.zombies.Zombies zombie = randomZombie();
        zombie.setGround(GameGround[q][18]);
        GameGround[q][18].settledZombie.add(zombie);
        ZombiesinGame.add(zombie);
    }


    public void addPlantsCard() {
        Plants.add(randomPlant());
    }

    public Plants randomPlant() {
        int k = generator.nextInt(ViewController.collection.plants_s.size());
        Plants current;
        current = ViewController.collection.plants_s.get(k);
        return cardFinder(current, current.getName());
    }


}
