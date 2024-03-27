package by.bsuir.kostyademens.entity.creature;

import by.bsuir.kostyademens.map.Coordinates;
import by.bsuir.kostyademens.map.GameMap;
import by.bsuir.kostyademens.util.PathUtils;

import java.util.List;

public class Wolf extends Creature {
    private final int damagePoints;

    public Wolf(Coordinates coordinates, int damagePoints, int healPoints, int speed) {
        super(coordinates, healPoints, speed);
        this.damagePoints = damagePoints;
    }

    public void makeMove(GameMap map) {


        List<Coordinates> path = PathUtils.buildPathToTheNearestEntity(map, getCoordinates(), Rabbit.class);

        int stepCounter = 0;

        while (stepCounter < speed) {

            if (path == null) {
                roamAround(map);
            } else {
                Rabbit rabbit = (Rabbit) map.getEntityFromCoordinates(path.get(path.size() - 1));
                if (speed < path.size()) {
                    map.moveEntityOnTheMap(getCoordinates(), path.get(0));

                } else {
                    if (path.size() == 1) {

                        rabbit.setHealPoints(rabbit.healPoints - damagePoints);
                        if (rabbit.healPoints <= 0) {
                            map.moveEntityOnTheMap(getCoordinates(), path.get(path.size() - 1));
                            if (healPoints < 10) {
                                eat();
                            }
                        }
                    } else {
                        map.moveEntityOnTheMap(getCoordinates(), path.get(0));
                    }

                }
            }
            stepCounter++;
            path = PathUtils.buildPathToTheNearestEntity(map, getCoordinates(), Rabbit.class);
        }
    }

    @Override
    public void eat() {
        healPoints++;
    }

}
