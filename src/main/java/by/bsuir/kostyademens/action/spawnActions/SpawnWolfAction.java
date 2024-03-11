package by.bsuir.kostyademens.action.spawnActions;


import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.action.SpawnAction;
import by.bsuir.kostyademens.animate.Wolf;
import by.bsuir.kostyademens.map.MapInterface;


public class SpawnWolfAction extends SpawnAction<Wolf> {


    public SpawnWolfAction(MapInterface map) {
        super(map);
        spawnRate = 10;
    }




    @Override
    public Wolf spawnEntity(Coordinates coordinates) {
        return new Wolf(coordinates);
    }
}
