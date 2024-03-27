package by.bsuir.kostyademens;

import by.bsuir.kostyademens.action.spawn.SpawnCarrotAction;
import by.bsuir.kostyademens.entity.creature.Creature;
import by.bsuir.kostyademens.map.GameMap;

import java.util.List;


public class Game {

    private final GameMap map;

    private final Renderer renderer = new Renderer();

    public Game(GameMap map) {
        this.map = map;
    }


    public void start() {

        while (true) {
            runSimulation();
        }

    }


    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void spawnMoreCarrots() {
        SpawnCarrotAction carrotSpawnAction = new SpawnCarrotAction(map, 7);
        carrotSpawnAction.perform();
    }


    public void runSimulation() {
        renderer.render(map);
        List<Creature> creatures = map.getListOfEntitiesOnTheMap(Creature.class);
        for (Creature creature : creatures) {
            if (creature.getHealPoints() <= 0) {
                continue;
            }
            creature.makeMove(map);
            System.out.println();
            renderer.render(map);
        }
        System.out.println();
        sleep();
//        if (map.getListOfEntitiesOnTheMap(Carrot.class).isEmpty()) {
//            spawnMoreCarrots();
//        }
    }
}

