package by.bsuir.kostyademens.action.spawnActions;


import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.action.SpawnAction;
import by.bsuir.kostyademens.factory.EntityFactory;
import by.bsuir.kostyademens.inanimate.Rock;
import by.bsuir.kostyademens.map.GameMap;


public class SpawnRockAction extends SpawnAction {


    public SpawnRockAction(GameMap map, int spawnRate) {
        super(map, spawnRate);
    }


    @Override
    public Rock spawnEntity(Coordinates coordinates) {
        return EntityFactory.createRock(coordinates);
    }
}
