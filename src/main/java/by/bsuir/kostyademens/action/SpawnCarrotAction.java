package by.bsuir.kostyademens.action;


import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.inanimate.Carrot;
import by.bsuir.kostyademens.map.MapImpl;


public class SpawnCarrotAction extends SpawnAction<Carrot> {


    public SpawnCarrotAction(MapImpl map) {
        super(map);
        spawnRate = 3;
    }




    @Override
    public Carrot spawnEntity(Coordinates coordinates) {
        return new Carrot(coordinates);
    }
}
