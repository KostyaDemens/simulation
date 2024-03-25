package by.bsuir.kostyademens.action.spawnActions;


import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.action.SpawnAction;
import by.bsuir.kostyademens.factory.EntityFactory;
import by.bsuir.kostyademens.inanimate.Carrot;
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
