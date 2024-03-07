package by.bsuir.kostyademens.action.spawnActions;


import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.action.SpawnAction;
import by.bsuir.kostyademens.inanimate.Tree;
import by.bsuir.kostyademens.map.MapInterface;


public class SpawnTreeAction extends SpawnAction<Tree> {


    public SpawnTreeAction(MapInterface map) {
        super(map);
        spawnRate = 3;
    }




    @Override
    public Tree spawnEntity(Coordinates coordinates) {
        return new Tree(coordinates);
    }
}
