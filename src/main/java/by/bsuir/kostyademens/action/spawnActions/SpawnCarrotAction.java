package by.bsuir.kostyademens.action.spawnActions;


import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.action.SpawnAction;
import by.bsuir.kostyademens.inanimate.Carrot;
import by.bsuir.kostyademens.map.MapInterface;


public class SpawnCarrotAction extends SpawnAction<Carrot> {


    public SpawnCarrotAction(MapInterface map) {
        super(map);
        spawnRate = 10;
    }




    @Override
    public Carrot spawnEntity(Coordinates coordinates) {
        return new Carrot(coordinates);
    }
}
