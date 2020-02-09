package gamecenter;

import controller.Viewcontroller;
import gamecenter.plants.*;
import gamecenter.zombies.*;

import java.util.ArrayList;
import java.util.Random;

public class Rail extends GameMode {
    private int sun;
    ArrayList<Zombies> DeadZombies = new ArrayList<>();
    ArrayList<Plants> plants_hand;
    Random generator = new Random();
    Plants current;
    int turn;
    int addingplantturn = 1;
    int addingzombieturn = 1;


    public Rail() {
        turn = 0;
        plants_hand = Viewcontroller.collection.plants_hand;
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

    public String select1(int i) {
        try{current = plants_hand.get(i);
            plants_hand.remove(i);
            return current.getName();}
        catch (Exception e){}
        return "";
    }

    public int select(int i) {
        String name = select1(i);
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
        for (int i = 0; i < plants_hand.size(); i++) {
            all.add(plants_hand.get(i).getName());
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

    public int endTurn() {
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
        for (int i = 0; i < plants_hand.size(); i++) {
            if (plants_hand.get(i).getTurn_cooldown() > 0)
                plants_hand.get(i).setTurn_cooldown();
        }
        for (Plants plant : PlantsinGame) {
            plant.setXY(this);
            plant.operation(this);
        }
        for (int i = 0; i < peas.size(); i++) {
            peas.get(i).setXY(this);
            int x = peas.get(i).getGroundX();
            if (peas.get(i).operation(GameGround[x])) {
                peas.remove(i);
            }
        }
        for (int i = 0; i < rockets.size(); i++) {
            rockets.get(i).setXY(this);
            int x = rockets.get(i).getGroundX();
            if (rockets.get(i).operation(GameGround[x])) {
                rockets.remove(i);
            }
        }
        for (Zombies zombie : ZombiesinGame) {
            zombie.setXY(this);
            int i = zombie.getGroundX();
            zombie.operation(getGroundline(i));
        }
        deathSets();
        Viewcontroller.shop.setCoin(DeadZombies.size() * 10);
        leaderBoards();
        if (zombieWins()) {
            return 1;
        }else
            return 0;
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
                zombies_dead.add(ZombiesinGame.get(i));
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
        plants_hand.add(randomPlant());
    }

    public Plants randomPlant() {
        int k = generator.nextInt(Viewcontroller.collection.plants_s.size());
        Plants current;
        current = Viewcontroller.collection.plants_s.get(k);
        return cardFinder(current, current.getName());
    }


}
