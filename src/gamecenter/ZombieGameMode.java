package gamecenter;

import controller.ViewController;
import gamecenter.plants.*;
import gamecenter.zombies.Zombies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class ZombieGameMode extends GameMode {
    int turn = 0;
    Random generator = new Random();
    private int coin = 50;
    private int ladder = 3;
    Zombies current;
    ArrayList<Zombies> zombies_hand;
    ArrayList<Integer> zombies_health = new ArrayList<>();
    ArrayList<Plants> plants = new ArrayList<>();
    Zombies[][] zombies = new Zombies[6][2];
    HashMap<String, String> showLanes = new HashMap<>();


    public ZombieGameMode() {
        zombies_hand = ViewController.collection.zombies_hand;
        for (int i = 0; i < 6; i++) {
            for (int k = 0; k < 19; k++) {
                GameGround[i][k].groundX = i;
                GameGround[i][k].groundY = k;
                GameGround[i][k].type = true;
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                zombies[i][j] = new Zombies();
            }
        }
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
        turn = 0;
        coin = 50;
        ladder = 3;
        zombies_hand = ViewController.collection.zombies_hand;
        zombies_health = new ArrayList<>();
        plants = new ArrayList<>();
        zombies = new Zombies[6][2];
        showLanes = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            for (int k = 0; k < 19; k++) {
                GameGround[i][k].groundX = i;
                GameGround[i][k].groundY = k;
                GameGround[i][k].type = true;
            }
        }
    }

    public int endTurn() {
        turn++;
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
        for (int i = 0; i < plants_dead.size(); i++) {
            coin += plants_dead.get(i).getHealth() * 10;
        }
        ViewController.shop.setCoin(plants_dead.size() * 10);
        if (!plantsCheck()) {
            return 2;
        }
        if (!zombiesCheck() && coin < 20) {
            return 0;
        }
        if (!zombiesCheck()) {
            return 1;
        }
        return -1;
    }

    public void randomPlanting() {
        Ground e = null;
        int a;
        ArrayList<Integer> random = new ArrayList<>();
        ArrayList<Plants> plants = new ArrayList<>(
                Arrays.asList(
                        new Damage("Potato Mine", e), new Damage("Potato Mine", e), new Damage("Potato Mine", e),
                        new Damage("Explode-o-nut", e), new Damage("Explode-o-nut", e), new Damage("Explode-o-nut", e),
                        new Pea("Gatling Pea", e), new Pea("Threepeater", e),
                        new Pea("Scaredy-shroom", e), new Pea("Scaredy-shroom", e), new Pea("Scaredy-shroom", e),
                        new Pea("Scaredy-shroom", e), new Pea("Scaredy-shroom", e), new Pea("Scaredy-shroom", e),
                        new Pea("Snow Pea", e), new Pea("Snow Pea", e),
                        new Shooter("Cabbage-pult", e), new Shooter("Cabbage-pult", e)
                ));

        while (true) {
            int flag = 1;
            a = generator.nextInt(18);
            for (int j = 0; j < random.size(); j++) {
                if (random.get(j) == a) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1)
                random.add(a);
            if (random.size() == 18)
                break;
        }

        for (int i = 0; i < 18; i++) {
            int x = random.get(i) / 3;
            int y = random.get(i) % 3;
            Ground ground = GameGround[x][y];
            ground.settledPlant = plants.get(i);
            plants.get(i).setGround(ground);
            PlantsinGame.add(plants.get(i));
        }
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

    public int put(String name, int number, int line) {
        if (line > 5)
            return -2;
        if (zombies[line].length + number > 2)
            return 1;
        for (Zombies zombie : zombies_hand) {
            if (name.equals(zombie.getName())) {
                if (coin >= 10 * zombie.getHealth()) {
                    coin -= zombie.getHealth() * 10;
                    current = cardFinder(zombie, name);
                    if (zombies[line][0] == null) {
                        zombies[line][0] = current;
                        current.setGround(GameGround[line][17]);
                        GameGround[line][17].settledZombie.add(current);
                    } else {
                        zombies[line][1] = current;
                        GameGround[line][18].settledZombie.add(current);
                        current.setGround(GameGround[line][18]);
                    }
                    ZombiesinGame.add(current);
                    return 2;
                } else return 0;
            }
        }
        return -1;
    }

    public int putLadder(int line) {
        if (line > 5)
            return -1;
        if (ladder <= 0)
            return 0;
        for (int i = 2; i <= 0; i++) {
            if (GameGround[line][i].settledPlant.type.equals("withoutaction")) {
                GameGround[line][i].settledPlant.suddenDeath();
                break;
            }
        }
        return 1;
    }

    public HashMap<String, String> showLanes() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < zombies[i].length; j++) {
                showLanes.put(Integer.toString(i), zombies[i][j].getName());
            }
        }
        return showLanes;
    }

    public ArrayList<String> showHand() {
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

    public void setLadder() {

        this.ladder = 3;
    }
}
