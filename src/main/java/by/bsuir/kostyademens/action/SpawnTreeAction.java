package by.bsuir.kostyademens.action;


import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.inanimate.Tree;
import by.bsuir.kostyademens.map.MapImpl;


public class SpawnTreeAction extends SpawnAction<Tree> {


    public SpawnTreeAction(MapImpl map) {
        super(map);
        spawnRate = 3;
    }




    @Override
    public Tree spawnEntity(Coordinates coordinates) {
        return new Tree(coordinates);
    }
}
