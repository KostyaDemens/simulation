package by.bsuir.kostyademens.animate;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.map.MapImpl;

import java.util.List;

public class Wolf extends Creature {
    private int damagePoints;

    public Wolf(Coordinates coordinates, int damagePoints, int healPoints, int speed) {
        super(coordinates, healPoints, speed);
        this.damagePoints = damagePoints;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }

    public void makeMove(MapImpl map) {


        List<Coordinates> path = pathBuilder.buildPath(map, getCoordinates(), Rabbit.class);

        int stepCounter = 0;

        do {

            if (path == null) {
                roamAround(map);
            } else {
                Rabbit rabbit = (Rabbit) map.getEntityFromCoordinates(path.get(path.size() - 1));
                if (speed < path.size()) {
                    map.makeMove(getCoordinates(), path.get(stepCounter), this);

                } else {
                    if (path.size() == 1) {

                        rabbit.setHealPoints(rabbit.healPoints - damagePoints);
                        if (rabbit.healPoints <= 0) {
                            map.makeMove(getCoordinates(), path.get(path.size() - 1), this);
                            eat();
                            break;
                        }
                    } else {
                        map.makeMove(getCoordinates(), path.get(path.size() - 2), this);
                        break;
                    }

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
