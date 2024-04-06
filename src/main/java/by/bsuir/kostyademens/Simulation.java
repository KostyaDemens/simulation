package by.bsuir.kostyademens;

import by.bsuir.kostyademens.action.Action;
import by.bsuir.kostyademens.action.move.MoveCreatureAction;
import by.bsuir.kostyademens.action.spawn.*;
import by.bsuir.kostyademens.map.GameMap;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final Renderer renderer;
    private final GameMap gameMap;
    private final List<Action> initActions;
    private final List<Action> turnActions;

    public Simulation(GameMap gameMap) {
        this.gameMap = gameMap;
        this.renderer = new Renderer();
        this.initActions = new ArrayList<>();
        this.turnActions = new ArrayList<>();
    }

    public void startSimulation() {
        createActions();
        spawnEntities();
        while (true) {
            renderer.render(gameMap);
            nextTurn();
            System.out.println();
            sleep();
        }
    }


    private void nextTurn() {
        for (Action turns : turnActions) {
            turns.perform();
        }
    }

    private void spawnEntities() {
        for (Action initAction : initActions) {
            initAction.perform();
        }
    }

    private void createActions() {
        initActions.add(new SpawnWolfAction(gameMap, 2));
        initActions.add(new SpawnRabbitAction(gameMap, 3));
        initActions.add(new SpawnRockAction(gameMap, 4));
        initActions.add(new SpawnTreeAction(gameMap, 5));
        initActions.add(new SpawnCarrotAction(gameMap, 7));

        turnActions.add(new MoveCreatureAction(gameMap));
        turnActions.add(new GlobalSpawnAction(gameMap));
    }


    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
