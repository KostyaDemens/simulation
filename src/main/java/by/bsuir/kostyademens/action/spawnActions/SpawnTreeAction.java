package by.bsuir.kostyademens.action.spawnActions;


import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.action.SpawnAction;
import by.bsuir.kostyademens.factory.EntityFactory;
import by.bsuir.kostyademens.inanimate.Tree;
import by.bsuir.kostyademens.map.GameMap;


public class SpawnTreeAction extends SpawnAction {


    public SpawnTreeAction(GameMap map, int spawnRate) {
        super(map, spawnRate);
    }


    @Override
    public Tree spawnEntity(Coordinates coordinates) {
        return EntityFactory.createTree(coordinates);
    }
}
