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

        for (int i = 0; i <= this.speed; i++) {

            if (map.findEntity(Carrot.class) == null) {
                roamAround(map);
            } else {


                List<Coordinates> path = pathBuilder.buildPath(map, this.getCoordinates(), Carrot.class);
                if (path == null) {
                    roamAround(map);
                } else {


                    for (Coordinates coordinates : path) {

                        if (map.getEntityFromCoordinates(coordinates) instanceof Carrot) {
                            eat();
                            map.makeMove(this.getCoordinates(), coordinates, this);
                        } else {
                            map.makeMove(this.getCoordinates(), coordinates, this);
                            break;
                        }
                    }
                }
            }
            i++;
        }
    }


    @Override
    public void eat() {
        healPoints++;
    }

}


