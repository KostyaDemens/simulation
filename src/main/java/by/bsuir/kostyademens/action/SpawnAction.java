package by.bsuir.kostyademens.action;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.Entity;
import by.bsuir.kostyademens.map.GameMap;


public abstract class SpawnAction implements Action {
    GameMap map;
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
