package by.bsuir.kostyademens.action;


import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.animate.Wolf;
import by.bsuir.kostyademens.map.MapImpl;


public class SpawnWolfAction extends SpawnAction<Wolf> {


    public SpawnWolfAction(MapImpl map) {
        super(map);
        spawnRate = 3;
    }




    @Override
    public Wolf spawnEntity(Coordinates coordinates) {
        return new Wolf(coordinates);
    }
}
