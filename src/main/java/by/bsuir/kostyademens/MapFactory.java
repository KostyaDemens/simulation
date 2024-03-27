package by.bsuir.kostyademens;


import by.bsuir.kostyademens.action.spawn.SpawnAction;
import by.bsuir.kostyademens.action.spawn.*;
import by.bsuir.kostyademens.entity.creature.Rabbit;
import by.bsuir.kostyademens.entity.creature.Wolf;
import by.bsuir.kostyademens.entity.inanimate.Carrot;
import by.bsuir.kostyademens.entity.inanimate.Rock;
import by.bsuir.kostyademens.map.Coordinates;
import by.bsuir.kostyademens.map.GameMap;

import java.util.HashMap;
import java.util.Map;


public class MapFactory {
    public GameMap get() {
//        return wolfAndRabbitTest();
//        return rabbitAndCarrotTest();
        return rabbitCollapseTest();
    }


    private GameMap readySimulation() {
        GameMap map = new GameMap(10, 10);

        Map<String, SpawnAction> actions = new HashMap<>();


        actions.put("carrot", new SpawnCarrotAction(map, 2));
        actions.put("rabbit", new SpawnRabbitAction(map, 3));
        actions.put("wolf", new SpawnWolfAction(map, 1));
        actions.put("rock", new SpawnRockAction(map,4));
        actions.put("tree", new SpawnTreeAction(map, 5));

        actions.values().forEach(SpawnAction::perform);

        return map;
    }

    public GameMap rabbitCollapseTest() {
        GameMap map = new GameMap(3, 4);

        map.addEntity(new Coordinates(1, 1), new Rock(new Coordinates(1, 1)));
        map.addEntity(new Coordinates(1, 2), new Rock(new Coordinates(1, 2)));
        map.addEntity(new Coordinates(2, 1), new Rock(new Coordinates(2, 1)));
        map.addEntity(new Coordinates(2, 2), new Rock(new Coordinates(2, 2)));
        map.addEntity(new Coordinates(4, 1), new Rock(new Coordinates(4, 1)));
        map.addEntity(new Coordinates(4, 2), new Rock(new Coordinates(4, 2)));

        map.addEntity(new Coordinates(3, 2), new Rabbit(new Coordinates(3, 2), 2, 1));
        map.addEntity(new Coordinates(2, 3), new Rabbit(new Coordinates(2, 3), 2, 1));

        map.addEntity(new Coordinates(4, 3), new Carrot(new Coordinates(4, 3)));
        return map;
    }

    private GameMap wolfAndRabbitTest() {
        GameMap map = new GameMap(20, 20);
        map.addEntity(new Coordinates(15, 15), new Rabbit(new Coordinates(15, 15), 2, 1));
        map.addEntity(new Coordinates(1, 1), new Wolf(new Coordinates(1, 1), 1, 8, 15));
        return map;
    }

    private GameMap rabbitAndCarrotTest() {
        GameMap map = new GameMap(4, 4);
        map.addEntity(new Coordinates(1, 1), new Rabbit(new Coordinates(1, 1), 1, 4));
        map.addEntity(new Coordinates(4, 4), new Carrot(new Coordinates(4, 4)));
        return map;
    }

}
