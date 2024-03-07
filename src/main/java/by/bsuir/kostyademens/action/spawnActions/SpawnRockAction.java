package by.bsuir.kostyademens.action.spawnActions;


import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.action.SpawnAction;
import by.bsuir.kostyademens.inanimate.Rock;
import by.bsuir.kostyademens.map.MapInterface;


public class SpawnRockAction extends SpawnAction<Rock> {


    public SpawnRockAction(MapInterface map) {
        super(map);
        spawnRate = 5;
    }




    @Override
    public Rock spawnEntity(Coordinates coordinates) {
        return new Rock(coordinates);
    }
}
