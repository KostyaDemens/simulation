package by.bsuir.kostyademens;

import by.bsuir.kostyademens.action.spawnActions.SpawnCarrotAction;
import by.bsuir.kostyademens.action.spawnActions.SpawnRabbitAction;
import by.bsuir.kostyademens.map.MapImpl;
import by.bsuir.kostyademens.map.MapInterface;

public class MapFactory {
    public MapInterface get() {
        MapInterface map = new MapImpl();
        SpawnCarrotAction carrot = new SpawnCarrotAction(map);
        SpawnRabbitAction rabbit = new SpawnRabbitAction(map);
        carrot.perform();
//        map.addEntity(new Coordinates(5, 5), carrot);
//        map.addEntity(new Coordinates(9, 9), carrot2);
        return map;
    }
}
