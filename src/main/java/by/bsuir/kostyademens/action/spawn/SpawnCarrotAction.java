package by.bsuir.kostyademens.action.spawn;


import by.bsuir.kostyademens.map.Coordinates;
import by.bsuir.kostyademens.factory.EntityFactory;
import by.bsuir.kostyademens.entity.inanimate.Carrot;
import by.bsuir.kostyademens.map.GameMap;


public class SpawnCarrotAction extends SpawnAction {


    public SpawnCarrotAction(GameMap map, int spawnRate) {
        super(map, spawnRate);
    }


    @Override
    public Carrot spawnEntity(Coordinates coordinates) {
        return EntityFactory.createCarrot(coordinates);
    }
}
