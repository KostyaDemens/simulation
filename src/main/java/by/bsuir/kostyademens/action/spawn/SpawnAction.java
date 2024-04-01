package by.bsuir.kostyademens.action.spawn;

import by.bsuir.kostyademens.action.Action;
import by.bsuir.kostyademens.entity.Entity;
import by.bsuir.kostyademens.map.Coordinates;
import by.bsuir.kostyademens.map.GameMap;


public abstract class SpawnAction implements Action {
    private final GameMap map;
    protected int spawnRate;

    public SpawnAction(GameMap map, int spawnRate) {
        this.map = map;
        this.spawnRate = spawnRate;
    }

    @Override
    public void perform() {
        int rate = 0;
        for (int i = rate; i < spawnRate; i++) {
            Coordinates coordinates = map.getRandomCoordinates();
            map.addEntity(coordinates, spawnEntity(coordinates));
        }
    }

    protected abstract Entity spawnEntity(Coordinates coordinates);

}
