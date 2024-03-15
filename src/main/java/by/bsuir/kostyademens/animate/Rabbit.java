package by.bsuir.kostyademens.animate;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.inanimate.Carrot;
import by.bsuir.kostyademens.map.MapImpl;

import java.util.List;

public class Rabbit extends Creature {


    public Rabbit(Coordinates coordinates, int healPoints) {
        super(coordinates);
        this.healPoints = healPoints;
    }

    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }

    @Override
    public void makeMove(MapImpl map) {
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
    }


    @Override
    public void eat() {
        healPoints++;
    }

}


