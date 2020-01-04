package gamecenter;

import controller.ViewController;
import gamecenter.plants.*;
import gamecenter.zombies.*;

import java.util.ArrayList;
import java.util.Random;

public class Day extends GameMode {
    private int sun = 2;
    int waveNumber = 1;
    int turn;
    Plants current;
    int turn_miani = 0;
    ArrayList<gamecenter.zombies.Zombies> Zombies = new ArrayList<>();
    ArrayList<Plants> plants_hand;
    ArrayList<Integer> sunneeded = new ArrayList<>();
    ArrayList<Integer> cooldown_left = new ArrayList<>();

    public Day() {
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

    public void setDefaults() {
        GameGround = new Ground[6][19];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 19; j++) {
                GameGround[i][j] = new Ground();
            }
        }
        PlantsinGame = new ArrayList<>();
        ZombiesinGame = new ArrayList<>();
        peas = new ArrayList<>();
        rockets = new ArrayList<>();
        showLawnX = new ArrayList<>();
        showLawnY = new ArrayList<>();
        showLawnHealth = new ArrayList<>();
        zombies_dead = new ArrayList<>();
        plants_dead = new ArrayList<>();
        plants_hand = ViewController.collection.plants_hand;
        for (int i = 0; i < 6; i++) {
            for (int k = 0; k < 19; k++) {
                GameGround[i][k].groundX = i;
                GameGround[i][k].groundY = k;
                GameGround[i][k].type = true;
            }
        }
        turn = 0;
        sun = 2;
        waveNumber = 1;
        turn_miani = 0;
        Zombies = new ArrayList<>();
        plants_hand = new ArrayList<>();
        sunneeded = new ArrayList<>();
        cooldown_left = new ArrayList<>();
    }

    public int endTurn() {
        turn++;
        setSun(generator.nextInt(4) + 2);

        if (turn == 3) {
            wave();
            waveNumber = 1;
        }
        if (!zombiesCheck()) {
            turn_miani++;
        }
        if (!zombiesCheck() && waveNumber < 3 && turn_miani >= 7) {
            turn_miani = 0;
            waveNumber++;
            wave();
        }
        for (Plants plant : PlantsinGame) {
            plant.setXY();
            plant.operation();
        }
        for (int i = 0; i < peas.size(); i++) {
            int x = peas.get(i).getGroundX();
            peas.get(i).operation(GameGround[x]);
        }
        for (int i = 0; i < rockets.size(); i++) {
            int x = rockets.get(i).getGroundX();
            rockets.get(i).operation(GameGround[x]);
        }
        for (Zombies zombie : ZombiesinGame) {
            int i = zombie.getGroundX();
            zombie.operation(getGroundline(i));
        }
        deathSets();
        ViewController.shop.setCoin(zombies_dead.size() * 10);

        if (zombieWins()) {
            return 0;
        }
        if (waveNumber == 3 && !zombiesCheck()) {
            return 1;
        }
        return -1;
    }

    boolean zombieWins() {
        for (int k = 0; k < 6; k++) {
            if (!GameGround[k][0].chamanzan && GameGround[k][0].settledZombie.size() != 0)
                return true;
        }
        return false;
    }

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

    void wave() {
        int c = generator.nextInt(7) + 4;
        for (int i = 0; i < c; i++) {
            int q = generator.nextInt(6);
            plantingZombie(q);
        }
    }

    public ArrayList<String> showHand() {
        ArrayList<String> all = new ArrayList<String>();
        for (int i = 0; i < plants_hand.size(); i++) {
            all.add(plants_hand.get(i).getName());
            sunneeded.add(plants_hand.get(i).getSun_used());
            cooldown_left.add(plants_hand.get(i).getTurn_cooldown());
        }
        return all;
    }

    public ArrayList<Integer> showHandSun() {


        return sunneeded;
    }

    public ArrayList<Integer> showHandCool() {


        return cooldown_left;
    }

    public int plantingPlant(int j, int i) {
        if (j % 2 != 0 || j > 18 || i > 5)
            return 0;
        if (GameGround[i][j].settledPlant == null) {
            GameGround[i][j].settledPlant = current;
            current.setGround(GameGround[i][j]);
            current = null;
            return 1;
        } else return -1;
    }

    public void plantingZombie(int q) {
        gamecenter.zombies.Zombies zombie = randomZombie();
        zombie.setGround(GameGround[q][18]);
        GameGround[q][18].settledZombie.add(zombie);
        ZombiesinGame.add(zombie);
    }

    public boolean removePlant(int j, int i) {
        if (GameGround[i][j].settledPlant != null) {
            PlantsinGame.remove(GameGround[i][j].settledPlant);
            GameGround[i][j].settledPlant.setGround(null);
            GameGround[i][j].settledPlant = null;
            return true;
        } else return false;
    }

    public void setSun(int sun) {

        this.sun += sun;
    }
    //problem detected: select sth that its been selected
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
}
