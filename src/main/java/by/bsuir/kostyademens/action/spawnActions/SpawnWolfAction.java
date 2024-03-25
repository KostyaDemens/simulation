package by.bsuir.kostyademens.action.spawnActions;


import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.action.SpawnAction;
import by.bsuir.kostyademens.animate.Wolf;
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
