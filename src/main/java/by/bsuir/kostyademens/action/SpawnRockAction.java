package by.bsuir.kostyademens.action;


import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.inanimate.Rock;
import by.bsuir.kostyademens.map.MapImpl;


public class SpawnRockAction extends SpawnAction<Rock> {


    public SpawnRockAction(MapImpl map) {
        super(map);
        spawnRate = 5;
    }




    @Override
    public Rock spawnEntity(Coordinates coordinates) {
        return new Rock(coordinates);
    }
}
