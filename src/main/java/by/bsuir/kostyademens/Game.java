package by.bsuir.kostyademens;

import by.bsuir.kostyademens.action.spawnActions.SpawnCarrotAction;
import by.bsuir.kostyademens.animate.Creature;
import by.bsuir.kostyademens.inanimate.Carrot;
import by.bsuir.kostyademens.map.MapImpl;

import java.util.List;
import java.util.Scanner;


public class Game {
    private final Scanner scanner = new Scanner(System.in);

    private final MapImpl map;

    private final Renderer renderer = new Renderer();

    public Game(MapImpl map) {
        this.map = map;
    }


    public void start() {
        System.out.println("Press 'S' to start simulation or 'E' to exit program");
        String endOrBegin = scanner.nextLine();
        boolean correctInput = false;
        while (!correctInput) {

            if (endOrBegin.matches("[sS]")) {
                runSimulation();
            } else if (endOrBegin.matches("[eE]")) {
                System.out.println("See you later!");
                correctInput = true;
            } else {
                System.out.println("You write wrong symbol. Try again");
                endOrBegin = scanner.nextLine();
            }
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
        SpawnCarrotAction carrotSpawnAction = new SpawnCarrotAction(map);
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
        }
        System.out.println();
        sleep();
        if (map.getListOfEntitiesOnTheMap(Carrot.class).isEmpty()) {
            spawnMoreCarrots();
        }
    }
}
