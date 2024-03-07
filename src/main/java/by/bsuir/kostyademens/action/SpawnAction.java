package by.bsuir.kostyademens.action;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.Entity;
import by.bsuir.kostyademens.map.MapInterface;


public abstract class SpawnAction <T extends Entity> extends Action {

    protected int spawnRate;

    public SpawnAction(MapInterface map) {
        super(map);
    }

    @Override
    public void perform() {
        int rate = 0;
        while (rate < spawnRate) {
            Coordinates coordinates = map.getRandomCoordinates();
            map.addEntity(coordinates, spawnEntity(coordinates));
            rate++;
        }
    }

    public abstract T spawnEntity(Coordinates coordinates);

}
