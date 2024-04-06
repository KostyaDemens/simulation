package by.bsuir.kostyademens.entity.creature;

import by.bsuir.kostyademens.entity.inanimate.Carrot;
import by.bsuir.kostyademens.map.Coordinates;
import by.bsuir.kostyademens.map.GameMap;
import by.bsuir.kostyademens.util.PathUtils;

import java.util.Iterator;
import java.util.List;

public class Rabbit extends Creature {


    public Rabbit(Coordinates coordinates, int healPoints, int speed) {
        super(coordinates, healPoints, speed);

    }

    @Override
    public void makeMove(GameMap map) {

        Iterator<Coordinates> steps = null;
        int stepCounter = 0;
        while (stepCounter < speed) {
            if (steps == null) {
                List<Coordinates> path = PathUtils.buildPathToTheNearestEntity(map, getCoordinates(), Carrot.class);
                if (path == null) {
                    for (; stepCounter < speed; stepCounter++) {
                        roamAround(map);
                    }
                    return;
                }
                steps = path.iterator();
            }

            if (steps.hasNext()) {
                map.moveEntity(getCoordinates(), steps.next());
                stepCounter++;
                if (!steps.hasNext()) {
                    eat();
                    steps = null;
                }
            }
        }
    }


    @Override
    public void eat() {
        healPoints = Math.min(healPoints + 1, maxHealPoints);
    }

}



