package by.bsuir.kostyademens.action.spawnActions;


import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.action.SpawnAction;
import by.bsuir.kostyademens.animate.Wolf;
import by.bsuir.kostyademens.factory.EntityFactory;
import by.bsuir.kostyademens.map.MapImpl;


public class SpawnWolfAction extends SpawnAction<Wolf> {


    public SpawnWolfAction(MapImpl map) {
        super(map);
        spawnRate = 1;
    }




    @Override
    public Wolf spawnEntity(Coordinates coordinates) {
        return EntityFactory.createWolf(coordinates);
    }
}
