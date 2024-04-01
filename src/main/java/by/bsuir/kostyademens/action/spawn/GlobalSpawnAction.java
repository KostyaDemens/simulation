package by.bsuir.kostyademens.action.spawn;

import by.bsuir.kostyademens.action.Action;
import by.bsuir.kostyademens.entity.creature.Rabbit;
import by.bsuir.kostyademens.entity.inanimate.Carrot;
import by.bsuir.kostyademens.map.GameMap;

public class GlobalSpawnAction implements Action {


    private final GameMap map;

    public GlobalSpawnAction(GameMap map) {
        this.map = map;
    }

    @Override
    public void perform() {
        if (map.getEntitiesByType(Carrot.class).isEmpty()) {
            new SpawnCarrotAction(map, 1).perform();
        }
        if (map.getEntitiesByType(Rabbit.class).isEmpty()) {
            new SpawnRabbitAction(map, 5).perform();
        }
    }
}
