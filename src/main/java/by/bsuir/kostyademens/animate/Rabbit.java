package by.bsuir.kostyademens.animate;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.inanimate.Carrot;
import by.bsuir.kostyademens.map.MapImpl;

import java.util.List;

public class Rabbit extends Creature {


    public Rabbit(Coordinates coordinates, int healPoints, int speed) {
        super(coordinates);
        this.healPoints = healPoints;
        this.speed = speed;
    }

    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }

    @Override
    public void makeMove(MapImpl map) {

        for (int i = 0; i < speed; i++) {

            List<Coordinates> path = pathBuilder.buildPath(map, getCoordinates(), Carrot.class);
            if (path == null) {
                roamAround(map);
            } else {
                for (int j = i; j < speed; j++) {
                    Coordinates coordinates = path.get(j);
                    if (j == path.size() - 1) {
                        eat();
                    }
                    map.makeMove(this.getCoordinates(), coordinates, this);
                }
            }
        }
    }


    @Override
    public void eat() {
        healPoints++;
    }

}


