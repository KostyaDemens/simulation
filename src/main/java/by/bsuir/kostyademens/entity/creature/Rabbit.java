package by.bsuir.kostyademens.entity.creature;

import by.bsuir.kostyademens.map.Coordinates;
import by.bsuir.kostyademens.entity.inanimate.Carrot;
import by.bsuir.kostyademens.map.GameMap;
import by.bsuir.kostyademens.util.PathUtils;

import java.util.List;

public class Rabbit extends Creature {


    public Rabbit(Coordinates coordinates, int healPoints, int speed) {
        super(coordinates, healPoints, speed);
    }

    @Override
    public void makeMove(GameMap map) {

        List<Coordinates> path = PathUtils.buildPathToTheNearestEntity(map, getCoordinates(), Carrot.class);

        int stepCounter = 0;

        while (stepCounter < speed) {
            if (path == null) {
                roamAround(map);
            } else {
                if (speed < path.size()) {
                    map.moveEntityOnTheMap(getCoordinates(), path.get(0));
                } else {
                    if (path.size() == 1) {
                        map.moveEntityOnTheMap(getCoordinates(), path.get(0));
                        if (getHealPoints() < 9) {
                            eat();
                        }
                    } else {
                        map.moveEntityOnTheMap(getCoordinates(), path.get(0));
                    }
                }
            }
            stepCounter++;
            path = PathUtils.buildPathToTheNearestEntity(map, getCoordinates(), Carrot.class);
        }
    }


    @Override
    public void eat() {
        healPoints++;
    }

}



