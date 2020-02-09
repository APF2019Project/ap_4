package gamecenter;

import controller.Viewcontroller;
import gamecenter.plants.Plants;
import gamecenter.zombies.Zombies;

import java.util.ArrayList;

public class PvP extends GameMode {
    int coin = 100;
    int sun = 2;
    int waveNumber = 1;
    int plantWins = 0;
    int zombieWins = 0;
    int turn;
    Plants selectedPlant;
    Zombies selectedZombie;
    ArrayList<Plants> plants_hand;
    Zombies current;
    ArrayList<Zombies> zombies_hand;
    ArrayList<Integer> zombies_health = new ArrayList<>();
    ArrayList<Plants> plants = new ArrayList<>();
    Zombies[][] zombies = new Zombies[6][2];
    int[] lanes = new int[6];
    ArrayList<String> showLanes = new ArrayList<>();
    ArrayList<Integer> showlanesNumbers = new ArrayList<>();
    ArrayList<gamecenter.zombies.Zombies> Zombies = new ArrayList<>();
    boolean readyStatu = false;
    ArrayList<Integer> sunneeded = new ArrayList<>();
    ArrayList<Integer> cooldown_left = new ArrayList<>();

    public PvP() {
        super();
        plants_hand = Viewcontroller.collection.plants_hand;
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
        sun++;
        turn++;
        for (int i = 0; i < peas.size(); i++) {
            peas.get(i).setXY(this);
            int x = peas.get(i).getGroundX();
            peas.get(i).operation(GameGround[x]);
        }
        for (int i = 0; i < rockets.size(); i++) {
            rockets.get(i).setXY(this);
            int x = rockets.get(i).getGroundX();
            rockets.get(i).operation(GameGround[x]);
        }
        for (Zombies zombie : ZombiesinGame) {
            zombie.setXY(this);
            int i = zombie.getGroundX();
            zombie.operation(getGroundline(i));
        }
        deathSets();

        if (zombieWins()) {
            coin += 200;
        }
    }

    public void ready() {


        readyStatu = true;
    }

    boolean waveWinner() {
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

    ///////////// DAY////////////
    /////////////day/////////
    //////////////day//////////
    /////////////day//////////
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
        if (j > 2) return false;
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

    public ArrayList<String> showHand_p() {
        sunneeded = new ArrayList<>();
        cooldown_left = new ArrayList<>();
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

    //////////////////Zombie
    public int put(String name, int number, int line) {
        if (line > 5)
            return -2;
        if (lanes[line] + number > 2)
            return 1;
        for (Zombies zombie : zombies_hand) {
            if (name.equals(zombie.getName())) {
                if (coin >= 10 * zombie.getHealth() * number) {
                    coin -= zombie.getHealth() * 10 * number;
                    current = cardFinder(zombie, name);
                    if (number == 1) {
                        if (lanes[line] == 0) {
                            zombies[line][0] = current;
                            current.setGround(GameGround[line][17]);
                            GameGround[line][17].settledZombie.add(current);
                        }
                        if (lanes[line] == 1) {
                            zombies[line][1] = current;
                            GameGround[line][18].settledZombie.add(current);
                            current.setGround(GameGround[line][18]);
                        }
                        lanes[line]++;
                        ZombiesinGame.add(current);
                    }
                    if (number == 2) {
                        zombies[line][0] = current;
                        current.setGround(GameGround[line][17]);
                        GameGround[line][17].settledZombie.add(current);
                        ZombiesinGame.add(current);
                        current = cardFinder(zombie, name);
                        zombies[line][1] = current;
                        GameGround[line][18].settledZombie.add(current);
                        current.setGround(GameGround[line][18]);
                        ZombiesinGame.add(current);
                        lanes[line] += 2;
                    }
                    return 2;
                } else return 0;
            }
        }
        return -1;
    }

    public ArrayList<String> showLanes() {
        for (int i = 0; i < 6; i++) {
            showlanesNumbers.add(i);
            for (int j = 0; j < 2; j++) {
                showLanes.add(zombies[i][j].getName());
            }
        }
        return showLanes;
    }

    public ArrayList<Integer> showlanesNumbers() {

        return showlanesNumbers;
    }

    public ArrayList<String> showHand_z() {
        ArrayList<String> all = new ArrayList<String>();
        for (int i = 0; i < zombies_hand.size(); i++) {
            all.add(zombies_hand.get(i).getName());
            zombies_health.add(zombies_hand.get(i).getHealth());
        }
        return all;
    }

    public ArrayList<Integer> showHandHealth() {

        return zombies_health;
    }

}
