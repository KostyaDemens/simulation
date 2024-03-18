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

        // TODO: попробовать переписать на while, чтобы вместо i и j была одна общая переменная, соответствующая оставшемуся числу ходов на ходе
        // TODO: предусмотреть случаи, когда path.size() < speed (в таком случае ищем новый путь и идем по нему или бродим, если не нашли)
        List<Coordinates> path = pathBuilder.buildPath(map, getCoordinates(), Rabbit.class);

        int stepCounter = 0;

        do {
            if (path == null) {
                roamAround(map);
            } else {
                if (speed < path.size()) {
                    map.makeMove(this.getCoordinates(), path.get(stepCounter), this);

                } else {
                    map.makeMove(this.getCoordinates(), path.get(path.size() - 1), this);
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
//        pathBuilder.getListOfNeighbours(getCoordinates(), map);
    }

}
