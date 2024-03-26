package by.bsuir.kostyademens.action.spawn;


import by.bsuir.kostyademens.map.Coordinates;
import by.bsuir.kostyademens.factory.EntityFactory;
import by.bsuir.kostyademens.entity.inanimate.Tree;
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
