package by.bsuir.kostyademens.action.spawn;


import by.bsuir.kostyademens.map.Coordinates;
import by.bsuir.kostyademens.entity.creature.Wolf;
import by.bsuir.kostyademens.factory.EntityFactory;
import by.bsuir.kostyademens.map.GameMap;


public class SpawnWolfAction extends SpawnAction {


    public SpawnWolfAction(GameMap map, int spawnRate) {
        super(map, spawnRate);
    }


    @Override
    public Wolf spawnEntity(Coordinates coordinates) {
        return EntityFactory.createWolf(coordinates);
    }
}
