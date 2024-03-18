package by.bsuir.kostyademens.animate;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.inanimate.Carrot;
import by.bsuir.kostyademens.map.MapImpl;

import java.util.List;

public class Rabbit extends Creature {


    public Rabbit(Coordinates coordinates, int healPoints, int speed) {
        super(coordinates, healPoints, speed);
    }

    @Override
    public void makeMove(MapImpl map) {

        List<Coordinates> path = pathBuilder.buildPath(map, getCoordinates(), Carrot.class);

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
    }

}



