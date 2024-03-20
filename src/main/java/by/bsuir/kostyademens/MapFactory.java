package by.bsuir.kostyademens;


import by.bsuir.kostyademens.action.SpawnAction;
import by.bsuir.kostyademens.action.spawnActions.*;
import by.bsuir.kostyademens.map.MapImpl;

import java.util.HashMap;
import java.util.Map;


public class MapFactory {
    public MapImpl get() {
        return readySimulation();
    }


    private MapImpl readySimulation() {
        MapImpl map = new MapImpl(10, 10);

        Map<String, SpawnAction<?>> actions = new HashMap<>();

        actions.put("carrot", new SpawnCarrotAction(map));
        actions.put("rabbit", new SpawnRabbitAction(map));
        actions.put("wolf", new SpawnWolfAction(map));
        actions.put("rock", new SpawnRockAction(map));
        actions.put("tree", new SpawnTreeAction(map));

        actions.values().forEach(SpawnAction::perform);

        return map;

    }
}
