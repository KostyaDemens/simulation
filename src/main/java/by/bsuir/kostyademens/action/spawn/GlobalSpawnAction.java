package by.bsuir.kostyademens.action.spawn;

import by.bsuir.kostyademens.action.Action;
import by.bsuir.kostyademens.entity.creature.Rabbit;
import by.bsuir.kostyademens.entity.inanimate.Carrot;
import by.bsuir.kostyademens.map.GameMap;

public class GlobalSpawnAction implements Action {


    private final GameMap map;

    public GlobalSpawnAction (GameMap map) {
        this.map = map;
    }

    @Override
    public void perform() {
        if (map.getListOfEntitiesOnTheMap(Carrot.class).isEmpty()) {
            new SpawnCarrotAction(map, 6).perform();
        }
        if (map.getListOfEntitiesOnTheMap(Rabbit.class).isEmpty()) {
            new SpawnRabbitAction(map, 5).perform();
        }
    }
}
