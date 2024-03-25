package by.bsuir.kostyademens.animate;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.inanimate.Carrot;
import by.bsuir.kostyademens.map.GameMap;
import by.bsuir.kostyademens.pathfinder.PathUtils;

import java.util.List;

public class Rabbit extends Creature {


    public Rabbit(Coordinates coordinates, int healPoints, int speed) {
        super(coordinates, healPoints, speed);
    }

    @Override
    public void makeMove(GameMap map) {

        List<Coordinates> path = PathUtils.buildPathToTheNearestEntity(map, getCoordinates(), Carrot.class);

        int stepCounter = 0;

        do {
            if (path == null) {
                roamAround(map);
            } else {
                if (speed < path.size()) {
                    map.moveEntityOnTheMap(getCoordinates(), path.get(stepCounter));

                } else {
                    map.moveEntityOnTheMap(getCoordinates(), path.get(path.size() - 1));
                    eat();
                    break;
                }
            }
            stepCounter++;

        } while (stepCounter < speed);
    }


    @Override
    public void eat() {
        healPoints++;
    }

}



