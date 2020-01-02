package gamecenter;

import controller.ViewController;
import gamecenter.plants.*;
import gamecenter.zombies.*;

import java.util.ArrayList;
import java.util.Random;

public class GameMode {
    public Ground[][] GameGround;
    public int sun;
    ArrayList<Plants> PlantsinGame;
    ArrayList<Zombies> ZombiesinGame;
    ArrayList<Peas> peas;
    ArrayList<Rocket> rockets;
    ArrayList<Integer> showLawnX;
    ArrayList<Integer> showLawnY;
    ArrayList<Integer> showLawnHealth;
    Random generator = new Random();

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
                ZombiesinGame.get(i).getGround().settledZombie.remove(ZombiesinGame.get(i));
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
            int x = ZombiesinGame.get(i).getGroundX();
            ZombiesinGame.get(i).operation(GameGround[x]);
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


    public Ground[] getGroundline(int i) {
        return GameGround[i];
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

    public void setSun(int sun) {

        this.sun += sun;
    }

    public void peaadder(int a) {
        for (int i = 0; i < a; i++) {
            Peas pea = new Peas();
            peas.add(pea);
        }
    }


    public Plants cardFinder(Plants plant, String name) {

        if (plant.type.equals("damage")) {
            return new Damage(name, null);
        }

        if (plant.type.equals("pea")) {
            return new Pea(name, null);
        }

        if (plant.type.equals("shooter")) {
            return new Shooter(name, null);
        }

        if (plant.type.equals("sunflower")) {
            return new Sunflower(name, null);
        }

        if (plant.type.equals("waterplants")) {
            return new WaterPlants(name, null);
        }

        if (plant.type.equals("withoutaction")) {
            return new WithoutActon(name, null);
        }

        return null;
    }

    public Zombies cardFinder(Zombies zombie, String name) {

        if (zombie.type.equals("BaloonZombie")) {
            return new BaloonZombie(null);
        }

        if (zombie.type.equals("CARZombie")) {
            return new CARZombie(name, null);
        }

        if (zombie.type.equals("GiantZombie")) {
            return new GiantZombie(null);
        }

        if (zombie.type.equals("JumperZombie")) {
            return new JumperZombie(null);
        }

        if (zombie.type.equals("Normal")) {
            return new Normal(name, null);
        }

        if (zombie.type.equals("ShieldZombie")) {
            return new ShieldZombie(name, null);
        }

        if (zombie.type.equals("SpiderZombie")) {
            return new SpiderZombie(null);
        }

        if (zombie.type.equals("WaterZombie")) {
            return new WaterZombie(name, null);
        }
        return null;
    }

    public Zombies randomZombie() {
        int k = generator.nextInt(ViewController.collection.zombies_s.size());
        gamecenter.zombies.Zombies current;
        current = ViewController.collection.zombies_s.get(k);
        return cardFinder(current, current.getName());
    }

}
