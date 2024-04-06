package by.bsuir.kostyademens.entity.creature;

import by.bsuir.kostyademens.entity.Entity;
import by.bsuir.kostyademens.map.Coordinates;
import by.bsuir.kostyademens.map.GameMap;
import by.bsuir.kostyademens.util.PathUtils;

import java.util.Iterator;
import java.util.List;

public class Wolf extends Creature {
    private final int damagePoints;

    public Wolf(Coordinates coordinates, int damagePoints, int healPoints, int speed) {
        super(coordinates, healPoints, speed);
        this.damagePoints = damagePoints;
    }

    public void makeMove(GameMap map) {

        Iterator<Coordinates> steps = null;
        int stepCounter = 0;
        while (stepCounter < speed) {
            if (steps == null) {
                List<Coordinates> path = PathUtils.buildPathToTheNearestEntity(map, getCoordinates(), Rabbit.class);
                if (path == null) {
                    for (; stepCounter < speed; stepCounter++) {
                        roamAround(map);
                    }
                    return;
                }
                steps = path.iterator();
            }

            if (steps.hasNext()) {
                Coordinates nextCoords = steps.next();
                Entity nextEntity = map.getEntityFromCoordinates(nextCoords);
                if (nextEntity instanceof Rabbit) {
                    Rabbit rabbit = (Rabbit) nextEntity;
                    while (rabbit.getHealPoints() > 0 && stepCounter < speed) {
                        rabbit.setHealPoints(rabbit.getHealPoints() - damagePoints);
                        stepCounter++;
                    }
                    if (rabbit.getHealPoints() <= 0) {
                        eat();
                        map.moveEntity(getCoordinates(), nextCoords);
                        steps = null;
                    }
                } else {
                    map.moveEntity(getCoordinates(), nextCoords);
                    stepCounter++;
                }
            }
        }
    }

    @Override
    public void eat() {
        healPoints = Math.min(healPoints + 1, maxHealPoints);
    }

}
