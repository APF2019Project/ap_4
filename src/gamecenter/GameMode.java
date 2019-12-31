package gamecenter;

import gamecenter.plants.Peas;
import gamecenter.plants.Plants;
import gamecenter.plants.Rocket;
import gamecenter.zombies.Zombies;

import java.util.ArrayList;

public class GameMode {
    public Ground[][] GameGround;
    ArrayList<Plants> PlantsinGame;
    ArrayList<Zombies> ZombiesinGame;
    ArrayList<Peas> peas;
    ArrayList<Rocket> rockets;
    ArrayList<Integer> showLawnX;
    ArrayList<Integer> showLawnY;
    ArrayList<Integer> showLawnHealth;

    public GameMode() {
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
    }

    public void deathSets() {
        for (int i = 0; i < PlantsinGame.size(); i++) {
            if (PlantsinGame.get(i).isDead()) {
                PlantsinGame.get(i).getGround().settledPlant = null;
                PlantsinGame.remove(i);
            }
        }
        for (int i = 0; i < ZombiesinGame.size(); i++) {
            if (ZombiesinGame.get(i).isDead()) {
                ZombiesinGame.get(i).getGround().settledZombie = null;
                ZombiesinGame.remove(i);
            }
        }
    }

    public void operate() {
        for (int i = 0; i < PlantsinGame.size(); i++) {
            PlantsinGame.get(i).operation();
        }
        for (int i = 0; i < peas.size(); i++) {
            int x = peas.get(i).getGroundX();
            peas.get(i).operation(GameGround[x]);
        }
        for (int i = 0; i < ZombiesinGame.size(); i++) {
            ZombiesinGame.get(i).operation();
        }
    }

    public void tripleadder() {

    }

    public void shotadder(int a, Ground ground, boolean icy) {
        for (int i = 0; i < a; i++) {
            Peas pea = new Peas(ground);
            peas.add(pea);
        }
    }

    public void shotadder(int a, Ground ground) {
        for (int i = 0; i < a; i++) {
            Peas pea = new Peas(ground);
            peas.add(pea);
        }
    }

    public void shotadder(int a, Ground ground, int damage, String kind) {
        for (int i = 0; i < a; i++) {
            Rocket rocket = new Rocket(ground, damage, kind);
            rockets.add(rocket);
        }
    }

    public int numberOfPlants() {

        return PlantsinGame.size();
    }

    public int numberOfZombies() {


        return ZombiesinGame.size();
    }

    public ArrayList<String> showLawn() {
        ArrayList<String> a = new ArrayList<>();
        for (int i = 0; i < PlantsinGame.size(); i++) {
            a.add(PlantsinGame.get(i).getName());
            showLawnX.add(PlantsinGame.get(i).getGround().groundX);
            showLawnY.add(PlantsinGame.get(i).getGround().groundY);
            showLawnHealth.add(PlantsinGame.get(i).getHealth());
        }
        for (int i = 0; i < ZombiesinGame.size(); i++) {
            a.add(ZombiesinGame.get(i).getName());
            showLawnX.add(ZombiesinGame.get(i).getGround().groundX);
            showLawnY.add(ZombiesinGame.get(i).getGround().groundY);
            showLawnHealth.add(ZombiesinGame.get(i).getHealth());
        }
        return a;
    }

    public ArrayList<Integer> showLawnX() {


        return showLawnX;
    }

    public ArrayList<Integer> showLawnY() {

        return showLawnY;
    }

    public ArrayList<Integer> showLawnHealth() {

        return showLawnHealth;
    }

}
