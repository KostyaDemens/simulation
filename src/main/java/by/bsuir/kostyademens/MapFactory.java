package by.bsuir.kostyademens;

import by.bsuir.kostyademens.action.spawnActions.SpawnCarrotAction;
import by.bsuir.kostyademens.action.spawnActions.SpawnRabbitAction;
import by.bsuir.kostyademens.action.spawnActions.SpawnWolfAction;
import by.bsuir.kostyademens.map.MapImpl;

public class MapFactory {
    public MapImpl get() {
        MapImpl map = new MapImpl();
        SpawnCarrotAction carrot = new SpawnCarrotAction(map);
        SpawnRabbitAction rabbit = new SpawnRabbitAction(map);
//        SpawnWolfAction wolf = new SpawnWolfAction(map);
//        wolf.perform();
        carrot.perform();
        rabbit.perform();
        return map;
    }
}
